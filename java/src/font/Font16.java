package font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//解析16*16的点阵字库  
public class Font16 {

	private final static String ENCODE = "GB2312";
	private final static String ZK16 = "HZK12";

	private boolean[][] arr;
	int LINES = 12;
	int BYTES = 24;

	public void drawString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 0x80) {
				continue;
			}
			int[] code = getByteCode(str.substring(i, i + 1));
			byte[] data = read(code[0], code[1]);
			drawString(data);
		}
	}

	private String drawString(byte[] data) {
		StringBuffer sb = new StringBuffer();
		int byteCount;
		int lCount;
		arr = new boolean[16][16];
		byteCount = 0;
		for (int line = 0; line < LINES; line++) {
			lCount = 0;
			for (int k = 0; k < 2; k++) {
				for (int j = 0; j < 8; j++) {
					if (((data[byteCount] >> (7 - j)) & 0x1) == 1) {
						arr[line][lCount] = true;
						sb.append("1");
						System.out.print("@");
					} else {
						sb.append("0");
						System.out.print(" ");
						// System.out.println(lCount);
						arr[line][lCount] = false;
					}
					lCount++;
				}
				byteCount++;
			}
			System.out.println();
		}
		return sb.toString();
	}

	protected byte[] read(int areaCode, int posCode) {
		byte[] data = null;
		try {
			int area = areaCode - 0xa0;
			int pos = posCode - 0xa0;

			InputStream in = new FileInputStream(new File(ZK16));
			long offset = BYTES * ((area - 1) * 94 + pos - 1);
			in.skip(offset);
			data = new byte[BYTES];
			in.read(data, 0, BYTES);
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	protected int[] getByteCode(String str) {
		int[] byteCode = new int[2];
		try {
			byte[] data = str.getBytes(ENCODE);
			byteCode[0] = data[0] < 0 ? 256 + data[0] : data[0];
			byteCode[1] = data[1] < 0 ? 256 + data[1] : data[1];
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return byteCode;
	}

	public void printAllChinese() throws Exception {
		OutputStream out = new FileOutputStream(new File("hz.lua"));
		out.write("hz={}\r\n".getBytes("UTF-8"));
		int start = 1411;
		int end = 5166;
		int index = 0;
		for (int areaCode = 0xa1; areaCode < 0xff; areaCode++)
			for (int posCode = 0xa1; posCode < 0xff; posCode++) {
				index++;
				if (index < start || index >= end)
					continue;
				String value = new String(new byte[] { (byte) areaCode, (byte) posCode });
				String matrix = drawString(read(areaCode < 0 ? 256 + areaCode : areaCode, posCode < 0 ? 256 + posCode : posCode));
				out.write((String.format("hz[#hz+1] = {value=\"%s\",matrix=\"%s\"};\r\n", value, matrix)).getBytes("UTF-8"));
			}
		out.close();
	}

	public static void main(String[] args) throws Exception {
		if (args == null || args.length < 1)
			return;
		new Font16().drawString("四");
		//new Font16().printAllChinese();
	}
}
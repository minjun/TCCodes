package utils.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.map.Exit;

public class ImportRoom {
	private static Logger logger = LoggerFactory.getLogger(ImportRoom.class);

	private static void printUsage() {
		System.out.println("Usage:ImportRoom dir suffix(.c/.h)");
	}

	private static String regexFind(StringBuffer sb, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sb);
		if (m.find()) {
			logger.debug("regex:" + m.group(0) + "[" + m.start() + "-" + m.end() + "]");
			return m.group(1);
		}
		return null;
	}

	private static List<Exit> getExits(String exits) {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		for (int i = 0; i < Exit.DIR.END.ordinal(); i++) {
			sb.append("\"").append(Exit.DIR.values()[i]).append("\"").append("|");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");
		logger.info(sb.toString());
		//sb = new StringBuffer("south");
		Pattern p = Pattern.compile(sb.toString());
		Matcher m = p.matcher(exits);
		int i = 0;
		while (m.find()) {
			logger.info("regex:" + m.group() + "[" + m.start() + "-" + m.end() + "]");
			i++;
		}
		return null;
	}

	private static void importRoom(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			if (line.trim().equals(""))
				continue;
			logger.debug(line);
			sb.append(line);
		}
		String name = regexFind(sb, "short\",\\s*\"(\\S+)\"");
		String desc = regexFind(sb, "@LONG(.+)LONG");
		String exits = regexFind(sb, "exits\",\\s*\\(\\[(.+?)\\]\\)");
		String objects = regexFind(sb, "objects\",\\s*\\(\\[(.+?)\\]\\)");

		br.close();
	}

	private static void importNpc(String fileName) {

	}

	private static void importObj(String fileName) {

	}

	private static void importDir(String strPath, String suffix) throws IOException {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				importDir(files[i].getAbsolutePath(), suffix);
			} else {
				String path = files[i].getAbsolutePath();
				if (path.endsWith(suffix)) {
					if (path.contains("\\item\\") || path.contains("\\misc\\") || path.contains("\\obj\\")) {
						importObj(path);
					} else if (path.contains("\\npc\\")) {
						importNpc(path);
					} else {
						importRoom(path);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			printUsage();
			return;
		}
		// importDir(args[0], args[1]);
		getExits(" //sizeof() == 4		\"south\" : __DIR__\"bank\",                \"north\" : __DIR__\"bookstore\",                \"west\" : __DIR__\"baihu-w2\",                \"east\" : __DIR__\"center\",        ");
	}
}

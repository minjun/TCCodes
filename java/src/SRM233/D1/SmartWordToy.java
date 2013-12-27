package SRM233.D1;

public class SmartWordToy {
	public int encode(String str) {
		int num = 0;
		// str.length === 4
		for (int i = 0; i < 4; i++) {
			num += (str.charAt(i) - 'a' + 1) << ((3 - i) * 5);
		}
		return num;
	}

	public String decode(int num) {
		String str = "";
		for (int i = 0; i < 4; i++) {
			int num1 = num & (31 << (3 - i) * 5);
			num1 >>= (3 - i) * 5;
			str += (char) (num1 + 'a' - 1);
		}
		return str;
	}

	public int minPresses(String from, String to, String[] forbid) {
		// initialize dists
		int[] dist = new int[1 + encode("zzzz")];
		dist[encode(from)] = 1;
		for (int i = 0; i < forbid.length; i++) {
			String[] chs = forbid[i].split(" ");
			for (int m = 0; m < chs[0].length(); m++) {
				for (int j = 0; j < chs[1].length(); j++)
					for (int k = 0; k < chs[2].length(); k++)
						for (int l = 0; l < chs[3].length(); l++) {
							String s = "" + chs[0].charAt(m) + chs[1].charAt(j)
									+ chs[2].charAt(k) + chs[3].charAt(l);
							dist[encode(s)] = -1;
						}
			}
		}
		// queue
		int[] queue = new int[1 + encode("zzzz")];
		int queuePut = 0, queueGet = 0;
		queue[queuePut++] = encode(from);
		int target = encode(to);
		while (queueGet < queuePut) {
			int pos = queue[queueGet++];
			if (pos == target)
				return dist[pos] - 1;
			String str = decode(pos);
			for (int delta = -1; delta <= 1; delta += 2)
				for (int i = 0; i < 4; i++) {
					// next position
					char ch = str.charAt(i);
					if (ch == 'a' && delta == -1) {
						ch = 'z';
					} else if (ch == 'z' && delta == 1) {
						ch = 'a';
					} else {
						ch += delta;
					}
					String strnew = "";
					switch (i) {
					case 0:
						strnew = "" + ch + str.charAt(1) + str.charAt(2)
								+ str.charAt(3);
						break;
					case 1:
						strnew = "" + str.charAt(0) + ch + str.charAt(2)
								+ str.charAt(3);
						break;
					case 2:
						strnew = "" + str.charAt(0) + str.charAt(1) + ch
								+ str.charAt(3);
						break;
					case 3:
						strnew = "" + str.charAt(0) + str.charAt(1)
								+ str.charAt(2) + ch;
						break;
					}
					int npos = encode(strnew);
					if (dist[npos] == 0) {
						dist[npos] = dist[pos] + 1;
						queue[queuePut++] = npos;
					}
				}
		}
		return -1;
	}
}

package SRM233.D1;

public class SmartWordToy {
	private int encode(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num += (str.charAt(i) - 'a') << ((str.length() - i - 1) * 5);
		}
		return num;
	}

	public int minPresses(String from, String to, String[] forbid) {
		int[] dist = new int[1 + encode("zzzz")];
		int[] queue = new int[1 + encode("zzzzz")];
		int queuePut = 0, queueGet = 0;
		queue[queuePut++] = encode(from);
		for (int i = 0; i < dist.length; i++) {
			dist[i] = 0;
		}
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
		int target = encode(to);
		while (queueGet < queuePut) {
			int pos = queue[queueGet++];
			if (pos == target)
				return dist[pos] - 1;
			for (int delta = -1; delta <= 1; delta += 2)
				for (int i = 0; i < 4; i++) {
					int npos = 0;// ...calc next position...
					if (dist[npos] == -1) {
						dist[npos] = dist[pos] + 1;
						queue[queuePut++] = npos;
					}
				}
		}
		// System.out.println(Integer.toBinaryString(encode("zzzz")));
		return -1;
	}
}

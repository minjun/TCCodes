package SRM663;

public class ChessFloor {
	public int minimumChanges(String[] floor) {
		int N = floor.length;
		int res = N * N;
		for (char A = 'a'; A <= 'z'; A++)
			for (char B = 'a'; B <= 'z'; B++) {
				if (A != B) {
					int cost = 0;
					for (int i = 0; i < N; i++)
						for (int j = 0; j < N; j++) {
							char z = ((i + j) % 2 == 0) ? A : B;
							if (floor[i].charAt(j) != z)
								cost++;
						}
					res = Math.min(res, cost);
				}
			}
		return res;
	}
}

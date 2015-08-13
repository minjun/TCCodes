package SRM661;

public class BridgeBuildingDiv2 {
	public int minDiameter(int[] a, int[] b, int K) {
		int n = a.length - 1;
		int d[][][]  = new int[a.length][b.length][K];
		for (int i=0;i<a.length-1;i++) {
			for (int j=0;j<b.length-1;j++) {
				for (int k=0;k<K;k++) {
					
				}
			}
		}
		return Math.min(d[n][0][K], d[n][n][K]);
	}
}

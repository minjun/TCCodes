package algorithms.others;

public class RMQ {
	// sparse table
	public int process(int[] A,int start,int end) {
		int n = A.length;
		int[][] m = new int[n][n];
		for (int i=0;i<n;i++) {
			m[i][0] = i;
		}
		for (int j=1;1<<j<=n;j++) {
			for (int i=0;i+(1<<j)-1<n;i++) {
				if (A[m[i][j-1]] <A[m[i+(1<<(j-1))][j-1]]) {
					 m[i][j] = m[i][j - 1];
				} else {
					m[i][j] = m[i+(1<<(j-1))][j-1];
				}
			}
		}
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		return 0;
	}
}

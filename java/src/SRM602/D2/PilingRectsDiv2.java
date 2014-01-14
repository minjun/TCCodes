package SRM602.D2;

public class PilingRectsDiv2 {

    public int getmax(int[] X, int[] Y, int limit) {
	int mx = -1;
	for (int w = 1; w <= limit; w++) {
	    int h = 1+(limit-1)/w;
	    int r = 0;
	    for (int i = 0; i < X.length; i++) {
		if ((X[i] >= w && Y[i] >= h) || (Y[i] >= w && X[i] >= h)) {
		    r++;
		}
	    }
	    if (r > 0)
		mx = Math.max(mx, r);
	}
	return mx;
    }
}

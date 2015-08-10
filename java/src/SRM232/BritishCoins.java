package SRM232;

public class BritishCoins {

	public int[] coins(int pence) {
		int[] ret = new int[3];
		ret[0] = pence/(12*20);
		int left = pence%(12*20);
		ret[1] = left/12;
		ret[2] = left%12;
		return ret;
	}
}

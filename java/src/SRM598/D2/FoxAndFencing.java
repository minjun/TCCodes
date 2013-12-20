package SRM598.D2;

public class FoxAndFencing {
	// Ciel go first
	// mov1+rng1 >= d => Ciel win
	// In the remaing case we have d > mov1+rng1.
	// d1 > mov2+rng2(1)
	// d1 + mov2 <= mov1+rng1(2)
	// (1) && (2) => mov2+rng2+mov2 < mov1+rng1 => 2mov2+rng2 < mov1+rng1
	// d+mov1>mov2+rng2
	public String WhoCanWin(int mov1, int mov2, int rng1, int rng2, int d) {
		if (d <= mov1 + rng1) {
			return "Ciel"; // first move
		} else if (d + mov1 <= mov2 + rng2) {
			return "Liss"; // second move
		} else if ((mov1 > mov2) && (mov2 * 2 + rng2 < mov1 + rng1)) {
			return "Ciel";
		} else if ((mov2 > mov1) && (mov1 * 2 + rng1 < mov2 + rng2)) {
			return "Liss";
		} else {
			return "Draw";
		}
	}
}

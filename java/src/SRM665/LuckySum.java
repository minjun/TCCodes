package SRM665;

public class LuckySum {

	private char[] numbers = null;

	private int replaceNumbers(String note) {
		int i;
		for (i = numbers.length - 1; i >= 0; i--) {
			if (note.charAt(i) == '?' && numbers[i] != '9')
				return i;
		}
		return -1;
	}

	private long getNumber() {
		long sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += (numbers[i] - '0') * (long) (Math.pow(10, numbers.length - 1 - i));
		}
		return sum;
	}

	private boolean isLuckySum(long number) {
		int i = 0;
		for (i = 0; i < number / 2 + 1; i++) {
			if (isLuckyNumber(i) && isLuckyNumber(number - i)) {
				break;
			}
		}
		return !(i == number / 2 + 1);
	}

	private long getNumber(String note, int index) {
		if (index <= note.length() - 1) {
			char ch = note.charAt(index);
			if (ch == '?') {
				numbers[index] = '0';
				if (index == 0)
					numbers[index] = '1';
			} else {
				numbers[index] = ch;
			}
		}
		if (index == note.length() - 1) {
			long number = getNumber();
			if (isLuckySum(number)) {
				return number;
			} else {
				int i = replaceNumbers(note);
				if (i == -1)
					return -1;
				numbers[i] = (char) (numbers[i] + 1);
				return getNumber(note, i + 1);
			}
		} else {
			return getNumber(note, index + 1);
		}
	}

	private boolean isLuckyNumber(long number) {
		if (number == 0)
			return false;
		while (number > 0) {
			long digit = number % 10;
			if (digit != 4 && digit != 7)
				return false;
			number /= 10;
		}
		return true;
	}

	public long construct(String note) {
		numbers = new char[note.length()];
		return getNumber(note, 0);
	}
}

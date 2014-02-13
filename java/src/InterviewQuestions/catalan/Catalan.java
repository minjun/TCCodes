package InterviewQuestions.catalan;

public class Catalan {
    private int number = 0;
    private int[] people = new int[12];
    private int[] all = new int[12];

    public void twelvepeople(int index, int firstnum) {
	if (index == 6) {
	    for (int i = 0; i < 6; i++) {
		System.out.print(people[i] + " ");
	    }
	    System.out.println();
	    for (int i = 0; i < 12; i++)
		if (all[i] == 0) {
		    System.out.print(i + " ");
		}
	    System.out.println();
	    System.out.println();
	    number++;
	} else {
	    for (int i = firstnum; i < index * 2 + 1; i++) {
		people[index] = i;
		all[i] = 1;
		twelvepeople(index + 1, i + 1);
		all[i] = 0;
	    }
	}
    }

    public int getNumber() {
	return number;
    }
}

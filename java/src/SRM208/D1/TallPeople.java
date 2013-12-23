package SRM208.D1;

public class TallPeople {
    public int[] getPeople(String[] people) {
	int[] numbers = new int[] { 1, 1000 };
	int cols = people[0].split(" ").length;
	int[][] heights = new int[people.length][cols];
	for (int i = 0; i < people.length; i++) {
	    String[] hs = people[0].split(" ");
	    for (int j = 0; j < hs.length; j++) {
		heights[i][j] = Integer.parseInt(people[i].split(" ")[j]);
	    }
	}
	for (int i = 0; i < people.length; i++) {
	    int min = 1000;
	    for (int j = 0; j < cols; j++) {
		min = Math.min(min, heights[i][j]);
	    }
	    numbers[0] = Math.max(numbers[0], min);
	}
	
	for (int i = 0; i < cols; i++) {
	    int max = 1;
	    for (int j = 0; j < people.length; j++) {
		max = Math.max(max, heights[j][i]);
	    }
	    numbers[1] = Math.min(numbers[1], max);
	}
	return numbers;
    }
}

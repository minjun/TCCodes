package algorithms.sort;

public class HeapSort {
	private static final int MAXNUM = Integer.MAX_VALUE;

	@SuppressWarnings("unused")
	private void print(int[] numbers) {
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + " ");
	}

	private void minHeapify(int[] numbers, int index) {
		int parent = index;
		while ((parent = (int) Math.floor((float) (parent - 1) / 2)) >= 0) {
			if (numbers[index] < numbers[parent]) {
				int temp = numbers[index];
				numbers[index] = numbers[parent];
				numbers[parent] = temp;
				minHeapify(numbers, parent);
			}
		}
	}

	private void buildMinHeap(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			minHeapify(numbers, i);
		}
	}

	private int getMin(int[] numbers) {
		int min = numbers[0];
		int index = 0;
		int left, right;
		while ((left = index * 2 + 1) <= numbers.length - 1) {
			right = left + 1;
			if (left == numbers.length - 1) {
				numbers[index] = numbers[left];
				numbers[left] = MAXNUM;
				index = left;
			} else if (numbers[left] <= numbers[right]) {
				numbers[index] = numbers[left];
				numbers[left] = MAXNUM;
				index = left;
			} else {
				numbers[index] = numbers[right];
				numbers[right] = MAXNUM;
				index = right;
			}
		}
		return min;
	}

	public int[] sort(int[] numbers) {
		buildMinHeap(numbers);
		int[] sorted = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			sorted[i] = getMin(numbers);

		}
		return sorted;
	}
}

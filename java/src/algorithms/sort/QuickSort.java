package algorithms.sort;

public class QuickSort {
	private int partition(int[] arr, int s, int e) {
		int sentry = arr[s];
		while (s < e) {
			while (s < e && arr[e] >= sentry)
				e--;
			arr[s] = arr[e];
			while (s < e && arr[s] <= sentry)
				s++;
			arr[e] = arr[s];
		}
		arr[s] = sentry;
		return s;
	}

	public void sort(int[] arr, int s, int e) {
		if (s < e) {
			int q = partition(arr, s, e);
			sort(arr, s, q - 1);
			sort(arr, q + 1, e);
		}
	}

}

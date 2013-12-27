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
	
	@SuppressWarnings("unused")
	private int partition2(int[] arr, int s, int e) {
	    int sentry = arr[e];
	    int j = s;
	    for (int i=s;i<e;i++) {
		if (arr[i] < sentry) {
		    int temp = arr[j];
		    arr[j] = arr[i];
		    arr[i] = temp;
		    j++;
		}
	    }
	    int temp = arr[j];
	    arr[j] = arr[e];
	    arr[e] = temp;
	    return j;
	}
	@SuppressWarnings("unused")
	private int partition1(int[] arr,int s,int e) {
	    int sentry = arr[s];
	    int j = s;
	    for (int i=s+1;i<=e;i++) {
		if (arr[i] < sentry) {
		    int temp = arr[j];
		    arr[j] = arr[i];
		    arr[i] = temp;
		    j++;
		}
	    }
	    for (int i=j;i<e;i++) {
		if (arr[i] == sentry) {
		    int temp = arr[j];
		    arr[j] = arr[i];
		    arr[i] = temp;
		    break;
		}
	    }
	    return j;
	    
	}

	public void sort(int[] arr, int s, int e) {
		if (s < e) {
			int q = partition(arr, s, e);
			for (int i=0;i<arr.length;i++)
			    System.out.print(arr[i]+" ");
			System.out.println(q);
			sort(arr, s, q - 1);
			sort(arr, q + 1, e);
		}
	}

}

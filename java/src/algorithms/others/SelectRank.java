package algorithms.others;

public class SelectRank {
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

    public int getRank(int[] arr, int s, int e, int rank) {
	if (s == e)
	    return arr[s];
	int m = partition(arr, s, e);
	int k = m -s+1;
	if (rank == k)
	    return arr[m];
	else if (rank < k)
	    return getRank(arr, s, m - 1, rank);
	else
	    return getRank(arr, m + 1, e, rank - k);
    }
}

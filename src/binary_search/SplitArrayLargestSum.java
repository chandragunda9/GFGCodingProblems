package binary_search;

public class SplitArrayLargestSum {
    static long f(int[] arr, int mid) {
        long count = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                count++;
                sum = arr[i];
            }
        }
        return count;
    }

    static int splitArray(int[] arr, int N, int K) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            long count = f(arr, mid);
            if (count > K) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

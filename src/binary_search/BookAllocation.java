package binary_search;

public class BookAllocation {
    static long f(int[] arr, int mid) {
        long stu = 1, pages = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pages + arr[i] <= mid) {
                pages += arr[i];
            } else {
                stu++;
                pages = arr[i];
            }
        }
        return stu;
    }

    public static long findPages(int n, int[] arr, int m) {
        if (m > n)
            return -1;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            long count = f(arr, mid);
            if (count > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

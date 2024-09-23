package binary_search;

public class MedianOfTwoSortedArrays {
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        if (n > m) {
            return medianOfArrays(m, n, b, a);
        }

        int low = 0, high = n, len = n + m;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = ((len + 1) / 2) - cut1;
            int l1 = (cut1 > 0) ? a[cut1 - 1] : Integer.MIN_VALUE;
            int l2 = (cut2 > 0) ? b[cut2 - 1] : Integer.MIN_VALUE;
            int r1 = (cut1 < n) ? a[cut1] : Integer.MAX_VALUE;
            int r2 = (cut2 < m) ? b[cut2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((len & 1) != 0) {
                    return Math.max(l1, l2);
                } else {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}

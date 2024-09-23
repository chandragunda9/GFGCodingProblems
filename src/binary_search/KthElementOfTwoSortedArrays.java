package binary_search;

public class KthElementOfTwoSortedArrays {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int n = arr1.length, m = arr2.length;
        if (n > m) {
            return kthElement(k, arr2, arr1);
        }
        int low = Math.max(0, k - m), high = Math.min(k, n);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            int l1 = (cut1 > 0) ? arr1[cut1 - 1] : Integer.MIN_VALUE;
            int l2 = (cut2 > 0) ? arr2[cut2 - 1] : Integer.MIN_VALUE;
            int r1 = (cut1 < n) ? arr1[cut1] : Integer.MAX_VALUE;
            int r2 = (cut2 < m) ? arr2[cut2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}

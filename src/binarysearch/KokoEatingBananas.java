package binarysearch;

public class KokoEatingBananas {
    static int f(int[] nums, int mid) {
        int hours = 0;
        for (int ele : nums) {
            if (ele < mid) {
                hours += 1;
            } else {
                hours += Math.ceil((double) ele / mid);
            }
        }
        return hours;
    }

    public static int KoKoEat(int[] arr, int k) {
        int low = 0, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            int h = f(arr, mid);
            if (h <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

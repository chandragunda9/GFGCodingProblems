package binarysearch;

public class SmallestPositiveDivisor {
    static int f(int[] nums, int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mid) {
                sum += 1;
            } else {
                sum += Math.ceil((double) nums[i] / mid);
            }
        }
        return sum;
    }

    public static int smallestDivisor(int[] nums, int K) {
        int low = 1, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = f(nums, mid);
            if (sum <= K) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

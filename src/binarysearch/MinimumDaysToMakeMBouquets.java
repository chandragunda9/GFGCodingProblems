package binarysearch;

public class MinimumDaysToMakeMBouquets {
    static int f(int[] nums, int mid, int k) {
        int count = 0;
        int noOfBouquets = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid)
                count++;
            else {
                noOfBouquets += count / k;
                count = 0;
            }
        }
        noOfBouquets += count / k;
        return noOfBouquets;
    }

    public static int solve(int M, int K, int[] bloomDay) {
        int n = bloomDay.length;
        if (n < (long) M * K)
            return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int no = f(bloomDay, mid, K);
            if (no >= M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

package arrays;

public class MaximumProductSubarray {
    long maxProduct(int[] nums, int n) {
        long prefix = 1, suffix = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - 1 - i];
            max = Math.max(max, Math.max(prefix, suffix));
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
        }
        return max;
    }
}

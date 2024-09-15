package sliding_window;

public class CountSubarraysWithKOdds {
    public static int countSubarray(int n, int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    static int count(int[] nums, int goal) {
        int sum = 0, count = 0, l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r] % 2;
            while (sum > goal) {
                sum -= nums[l] % 2;
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}

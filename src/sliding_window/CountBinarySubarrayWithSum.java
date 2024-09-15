package sliding_window;

public class CountBinarySubarrayWithSum {
    public int numberOfSubarrays(int[] arr, int target) {
        return count(arr, target) - count(arr, target - 1);
    }

    int count(int[] arr, int goal) {
        int sum = 0, count = 0;
        int l = 0, r = 0;
        while (r < arr.length) {
            sum += arr[r];
            while (sum > goal) {
                sum -= arr[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}

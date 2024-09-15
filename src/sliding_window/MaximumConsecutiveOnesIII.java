package sliding_window;

public class MaximumConsecutiveOnesIII {
    int findZeroes(int arr[], int n, int m) {
        //longest subarray with atmost m zeroes
        int l = 0, r = 0, zeroes = 0, maxLen = 0;
        while (r < n) {
            if (arr[r] == 0) {
                zeroes++;
            }
            while (zeroes > m) {
                if (arr[l] == 0)
                    zeroes--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}

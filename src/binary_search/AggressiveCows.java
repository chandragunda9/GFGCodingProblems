package binary_search;

import java.util.Arrays;

public class AggressiveCows {
    static boolean isPossible(int[] stalls, int mid, int k) {
        int cntCows = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= mid) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows == k)
                return true;
        }
        return false;
    }

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDist = Math.min(minDist, stalls[i] - stalls[i - 1]);
        }
        int low = minDist, high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(stalls, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}

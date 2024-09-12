package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);
        int len = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (prefixSums.containsKey(sum - K)) {
                len = Math.max(len, i - prefixSums.get(sum - K));
            }
            if (!prefixSums.containsKey(sum)) {
                prefixSums.put(sum, i);
            }
        }
        return len;
    }
}

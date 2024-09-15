package greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dept[]) {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 0, j = 0;
        int count = 0, ans = 0;
        while (i < arr.length && j < dept.length) {
            if (arr[i] <= dept[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}

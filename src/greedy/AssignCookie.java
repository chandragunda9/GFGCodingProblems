package greedy;

import java.util.Arrays;

public class AssignCookie {
    public int maxChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);
        int l = 0, r = 0, count = 0;
        while (l < cookie.length && r < greed.length) {
            if (cookie[l] >= greed[r]) {
                count++;
                l++;
                r++;
            } else {
                l++;
            }
        }
        return count;
    }
}

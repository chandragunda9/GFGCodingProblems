package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDistinctCharacters {
    static int longestSubstrDistinctChars(String S) {
        int l = 0, r = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < S.length()) {
            char ch = S.charAt(r);
            if (map.containsKey(ch) && map.get(ch) >= l) {
                l = map.get(ch) + 1;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            map.put(ch, r);
            r++;
        }
        return maxLen;
    }
}

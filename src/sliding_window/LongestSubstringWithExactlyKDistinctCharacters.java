package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithExactlyKDistinctCharacters {
    public int longestkSubstr(String s, int k) {
        int maxLen = 0, l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() > k) {
                char leftCh = s.charAt(l);
                map.put(leftCh, map.get(leftCh) - 1);
                if (map.get(leftCh) == 0) {
                    map.remove(leftCh);
                }
                l++;
            }
            if (map.size() == k)
                maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen == 0 ? -1 : maxLen;
    }

    public static void main(String[] args) {
        String st = "aabacbebebe";
        int k = 5;
        LongestSubstringWithExactlyKDistinctCharacters obj = new LongestSubstringWithExactlyKDistinctCharacters();
        System.out.println(obj.longestkSubstr(st, k));
    }
}

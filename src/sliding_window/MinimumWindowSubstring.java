package sliding_window;

public class MinimumWindowSubstring {
    public static String smallestWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE, l = 0, r = 0, count = 0, startInd = -1;
        int[] freq = new int[26];
        for (char ch : t.toCharArray()) {
            freq[ch - 'a'] += 1;
        }
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (freq[ch - 'a'] > 0) {
                count++;
            }
            freq[ch - 'a'] -= 1;
            while (count == t.length()) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    startInd = l;
                }
                char leftCh = s.charAt(l);
                freq[leftCh - 'a']++;
                if (freq[leftCh - 'a'] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return startInd == -1 ? "-1" : s.substring(startInd, startInd + minLen);
    }
}

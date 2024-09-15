package sliding_window;

import java.util.Arrays;

public class CountSubstringsWithAtleastOneOccurrence {
    public static int countSubstring(String s) {
        int[] lastSeenInd = new int[3];
        int count = 0;
        Arrays.fill(lastSeenInd, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastSeenInd[ch - 'a'] = i;
            if (lastSeenInd[0] != -1 && lastSeenInd[1] != -1 && lastSeenInd[2] != -1) {
                int minInd = Math.min(lastSeenInd[0], Math.min(lastSeenInd[1], lastSeenInd[2]));
                count += minInd + 1;
            }
        }
        return count;
    }

    public static int method1(String s) {
        int n = s.length(), count = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[3];
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq[ch - 'a'] += 1;
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    count += s.length() - j;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String st = "abcabc";
        System.out.println(countSubstring(st));
    }
}

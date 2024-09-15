package sliding_window;

public class LongestRepeatingCharacterReplacement {
    static int method2(String S, int K) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] freq = new int[26];
        while (r < S.length()) {
            char ch = S.charAt(r);
            freq[ch - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
//           charsToBeReplaced is (r - l + 1) - maxFreq;
            while ((r - l + 1) - maxFreq > K) {
                char leftCh = S.charAt(l);
                freq[leftCh - 'A'] -= 1;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    static int characterReplacement(String S, int K) {
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] freq = new int[26];
        while (r < S.length()) {
            char ch = S.charAt(r);
            freq[ch - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            if ((r - l + 1) - maxFreq > K) {
                char leftCh = S.charAt(l);
                freq[leftCh - 'A'] -= 1;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String st = "AABAABB";
        int k = 2;
        System.out.println(characterReplacement(st, k));
    }
}

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freqS = new int[26];

        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        for (int k = n - 1; k >= 0; k--) {
            int[] freq = freqS.clone();
            boolean canFormPrefix = true;

            for (int i = 0; i < k; i++) {
                char required = target.charAt(i);

                if (freq[required - 'a'] == 0) {
                    canFormPrefix = false;
                    break;
                }

                freq[required - 'a']--;
            }

            if (!canFormPrefix) {
                continue;
            }

            char targetChar = target.charAt(k);
            char nextChar = 0;

            for (int i = targetChar - 'a' + 1; i < 26; i++) {
                if (freq[i] > 0) {
                    nextChar = (char) (i + 'a');
                    freq[i]--;
                    break;
                }
            }

            if (nextChar != 0) {
                StringBuilder result = new StringBuilder();

                result.append(target, 0, k);
                result.append(nextChar);

                for (int i = 0; i < 26; i++) {
                    while (freq[i] > 0) {
                        result.append((char) (i + 'a'));
                        freq[i]--;
                    }
                }

                return result.toString();
            }
        }

        return "";
    }
}
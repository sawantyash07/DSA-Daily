class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'a');
            }
        }
        
        // Frequencies strictly for the first half of the palindrome
        int[] halfCnt = new int[26];
        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
            halfLen += halfCnt[i];
        }
        
        // Precompute Pascal's triangle up to halfLen. 
        // Cap values to 2,000,000 to cleanly dodge large number limits (Since k <= 10^6)
        int[][] C = new int[halfLen + 1][];
        for (int i = 0; i <= halfLen; i++) {
            C[i] = new int[i + 1];
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                long val = (long) C[i - 1][j - 1] + C[i - 1][j];
                if (val > 2000000) {
                    val = 2000000;
                }
                C[i][j] = (int) val;
            }
        }
        
        long totalPerms = getPerms(halfCnt, C);
        if (totalPerms < k) {
            return "";
        }
        
        // Building the first half string structure
        StringBuilder firstHalf = new StringBuilder();
        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfCnt[c] > 0) {
                    halfCnt[c]--; // Tentatively assign this character
                    long p = getPerms(halfCnt, C);
                    
                    if (p < k) {
                        k -= p;
                        halfCnt[c]++; // Backtrack/Revert choice
                    } else {
                        firstHalf.append((char) (c + 'a'));
                        break; // Progress successfully down to determine the next position
                    }
                }
            }
        }
        
        // Assemble the full palindrome
        StringBuilder res = new StringBuilder(firstHalf);
        if (oddCount == 1) {
            res.append(oddChar);
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            res.append(firstHalf.charAt(i));
        }
        
        return res.toString();
    }

    private long getPerms(int[] cnt, int[][] C) {
        long perms = 1;
        int sum = 0;
        for (int x : cnt) {
            if (x > 0) {
                sum += x;
                perms *= C[sum][x];
                if (perms > 2000000) {
                    return 2000001; // Safe upper bound lock return
                }
            }
        }
        return perms;
    }
}
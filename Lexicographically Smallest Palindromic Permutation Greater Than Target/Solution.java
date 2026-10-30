class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        
        // Step 1: Character frequency mapping
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int oddCount = 0;
        Character mid = null;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                mid = (char) ('a' + i);
            }
        }
        
        // A palindrome cannot be formed if more than one char has an odd frequency
        if (oddCount > 1) {
            return "";
        }
        
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = freq[i] / 2;
        }
        
        StringBuilder half = new StringBuilder();
        
        // Step 2: Build the first half greedily
        for (int i = 0; i < n / 2; i++) {
            boolean found = false;
            
            for (int c = 0; c < 26; c++) {
                if (count[c] > 0) {
                    count[c]--; // Provisionally pick the character
                    
                    // Form P_max for our check criteria
                    StringBuilder pMaxHalf = new StringBuilder();
                    pMaxHalf.append(half).append((char)('a' + c));
                    for (int d = 25; d >= 0; d--) {
                        for (int k = 0; k < count[d]; k++) {
                            pMaxHalf.append((char) ('a' + d));
                        }
                    }
                    
                    StringBuilder pMax = new StringBuilder(pMaxHalf);
                    if (mid != null) {
                        pMax.append(mid);
                    }
                    for (int j = pMaxHalf.length() - 1; j >= 0; j--) {
                        pMax.append(pMaxHalf.charAt(j));
                    }
                    
                    // If the maximum possible configuration > target, we commit to this character
                    if (pMax.toString().compareTo(target) > 0) {
                        half.append((char)('a' + c));
                        found = true;
                        break;
                    }
                    
                    // Backtrack
                    count[c]++;
                }
            }
            if (!found) {
                return "";
            }
        }
        
        // Step 3: Construct the final palindromic formulation
        StringBuilder finalPal = new StringBuilder(half);
        if (mid != null) {
            finalPal.append(mid);
        }
        for (int i = half.length() - 1; i >= 0; i--) {
            finalPal.append(half.charAt(i));
        }
        
        String res = finalPal.toString();
        if (res.compareTo(target) > 0) {
            return res;
        }
        
        return "";
    }
}
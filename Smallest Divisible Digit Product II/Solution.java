class Solution {
    public String smallestNumber(String num, long t) {
        // Find prime factors of t
        long temp = t;
        int T2 = 0, T3 = 0, T5 = 0, T7 = 0;
        while (temp % 2 == 0) { T2++; temp /= 2; }
        while (temp % 3 == 0) { T3++; temp /= 3; }
        while (temp % 5 == 0) { T5++; temp /= 5; }
        while (temp % 7 == 0) { T7++; temp /= 7; }
        
        // Digits 1-9 can only furnish factors of 2, 3, 5, and 7.
        if (temp > 1) {
            return "-1";
        }
        
        // Precompute the minimum length required to satisfy r2 twos and r3 threes
        int[][] minLen23 = new int[61][61];
        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                int min = Integer.MAX_VALUE;
                for (int c6 = 0; c6 <= Math.max(i, j); c6++) {
                    int rem2 = Math.max(0, i - c6);
                    int rem3 = Math.max(0, j - c6);
                    min = Math.min(min, c6 + (rem2 + 2) / 3 + (rem3 + 1) / 2);
                }
                minLen23[i][j] = min;
            }
        }
        
        int N = num.length();
        int[] f2 = {0, 0, 1, 0, 2, 0, 1, 0, 3, 0};
        int[] f3 = {0, 0, 0, 1, 0, 0, 1, 0, 0, 2};
        int[] f5 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        int[] f7 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        
        int[] pref2 = new int[N + 1];
        int[] pref3 = new int[N + 1];
        int[] pref5 = new int[N + 1];
        int[] pref7 = new int[N + 1];
        
        int firstZero = N;
        for (int i = 0; i < N; i++) {
            int d = num.charAt(i) - '0';
            if (d == 0 && firstZero == N) {
                firstZero = i;
            }
            pref2[i + 1] = pref2[i] + f2[d];
            pref3[i + 1] = pref3[i] + f3[d];
            pref5[i + 1] = pref5[i] + f5[d];
            pref7[i + 1] = pref7[i] + f7[d];
        }
        
        // Subcase: if num itself is valid
        if (firstZero == N && pref2[N] >= T2 && pref3[N] >= T3 && pref5[N] >= T5 && pref7[N] >= T7) {
            return num;
        }
        
        // Attempt to find a valid prefix variation to mutate matching length
        int startI = Math.min(N - 1, firstZero);
        for (int i = startI; i >= 0; i--) {
            int d_original = num.charAt(i) - '0';
            int startD = d_original + 1;
            
            for (int d = startD; d <= 9; d++) {
                int curr2 = pref2[i] + f2[d];
                int curr3 = pref3[i] + f3[d];
                int curr5 = pref5[i] + f5[d];
                int curr7 = pref7[i] + f7[d];
                
                int req2 = Math.max(0, T2 - curr2);
                int req3 = Math.max(0, T3 - curr3);
                int req5 = Math.max(0, T5 - curr5);
                int req7 = Math.max(0, T7 - curr7);
                
                int L = N - 1 - i;
                if (req5 + req7 + minLen23[req2][req3] <= L) {
                    StringBuilder ans = new StringBuilder();
                    ans.append(num.substring(0, i));
                    ans.append(d);
                    ans.append(buildSuffix(req2, req3, req5, req7, L, minLen23, f2, f3, f5, f7));
                    return ans.toString();
                }
            }
        }
        
        // Subcase: if no variation yields validity, we necessitate expanding the target string's length footprint
        int NewL = Math.max(N + 1, T5 + T7 + minLen23[T2][T3]);
        return buildSuffix(T2, T3, T5, T7, NewL, minLen23, f2, f3, f5, f7);
    }
    
    // Builds the optimal suffix sequentially utilizing the smallest viable combinations factoring in dynamic constraints
    private String buildSuffix(int req2, int req3, int req5, int req7, int length, int[][] minLen23, int[] f2, int[] f3, int[] f5, int[] f7) {
        StringBuilder sb = new StringBuilder();
        for (int len = length; len >= 1; len--) {
            for (int d = 1; d <= 9; d++) {
                int nreq2 = Math.max(0, req2 - f2[d]);
                int nreq3 = Math.max(0, req3 - f3[d]);
                int nreq5 = Math.max(0, req5 - f5[d]);
                int nreq7 = Math.max(0, req7 - f7[d]);
                
                if (nreq5 + nreq7 + minLen23[nreq2][nreq3] <= len - 1) {
                    sb.append(d);
                    req2 = nreq2;
                    req3 = nreq3;
                    req5 = nreq5;
                    req7 = nreq7;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
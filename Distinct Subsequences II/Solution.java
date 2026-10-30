class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007L;
        long dp = 1;
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newDp = (2 * dp % MOD - last[idx] + MOD) % MOD;
            last[idx] = dp;
            dp = newDp;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }
}
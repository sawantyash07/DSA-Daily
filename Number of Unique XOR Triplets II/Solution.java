class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        boolean[] ans = new boolean[MAX];

        for (int v : nums) {
            ans[v] = true;

            for (int cnt = 2; cnt >= 0; cnt--) {
                for (int x = 0; x < MAX; x++) {
                    if (dp[cnt][x]) {
                        dp[cnt + 1][x ^ v] = true;
                    }
                }
            }
        }

        for (int x = 0; x < MAX; x++) {
            if (dp[3][x]) {
                ans[x] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}
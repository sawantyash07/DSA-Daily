class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // Length = 2 initialization
        for (int x = 1; x <= m; x++) {
            up[x] = x - 1;      // smaller values before x
            down[x] = m - x;    // larger values before x
        }

        // Build lengths 3 ... n
        for (int len = 3; len <= n; len++) {

            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 1; i <= m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long totalUp = prefUp[m];

            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            for (int x = 1; x <= m; x++) {
                // previous value < x and last direction was DOWN
                newUp[x] = prefDown[x - 1];

                // previous value > x and last direction was UP
                newDown[x] = (totalUp - prefUp[x] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int x = 1; x <= m; x++) {
                ans = (ans + up[x] + down[x]) % MOD;
            }
        } else {
            for (int x = 1; x <= m; x++) {
                ans = (ans + up[x] + down[x]) % MOD;
            }
        }

        return (int) ans;
    }
}
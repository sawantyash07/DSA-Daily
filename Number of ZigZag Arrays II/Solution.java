class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        long[] base = new long[size];

        // Length = 2 initialization
        for (int i = 0; i < m; i++) {
            base[i] = i;               // up[i]
            base[m + i] = m - 1 - i;   // down[i]
        }

        long[][] T = new long[size][size];

        // up'[x] = sum down[y] where y < x
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                T[x][m + y] = 1;
            }
        }

        // down'[x] = sum up[y] where y > x
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                T[m + x][y] = 1;
            }
        }

        long[] state = powerApply(T, n - 2, base);

        long ans = 0;
        for (long v : state) {
            ans = (ans + v) % MOD;
        }

        return (int) ans;
    }

    private long[] powerApply(long[][] mat, long exp, long[] vec) {
        int n = mat.length;

        long[][] cur = mat;
        long[] res = vec.clone();

        boolean first = true;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                if (first) {
                    res = multiply(cur, res);
                    first = false;
                } else {
                    res = multiply(cur, res);
                }
            }

            exp >>= 1;
            if (exp > 0) {
                cur = multiply(cur, cur);
            }
        }

        return first ? vec : res;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    sum = (sum + A[i][j] * v[j]) % MOD;
                }
            }
            res[i] = sum;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}
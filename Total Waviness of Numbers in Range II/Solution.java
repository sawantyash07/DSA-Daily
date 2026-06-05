class Solution {

    static class Pair {
        long count;   // number of valid numbers
        long sum;     // total waviness

        Pair(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Pair[][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        digits = Long.toString(n).toCharArray();

        // pos, lenState(0,1,2), prev2(0..10), prev1(0..10)
        memo = new Pair[digits.length][3][11][11];

        return dfs(0, true, 0, 10, 10).sum;
    }

    private Pair dfs(int pos, boolean tight, int lenState, int prev2, int prev1) {
        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (!tight && memo[pos][lenState][prev2][prev1] != null) {
            return memo[pos][lenState][prev2][prev1];
        }

        int limit = tight ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = tight && (d == limit);

            if (lenState == 0) {
                // Number has not started yet
                if (d == 0) {
                    Pair child = dfs(pos + 1, nextTight, 0, 10, 10);
                    totalCount += child.count;
                    totalSum += child.sum;
                } else {
                    Pair child = dfs(pos + 1, nextTight, 1, 10, d);
                    totalCount += child.count;
                    totalSum += child.sum;
                }
            } else if (lenState == 1) {
                // Have exactly one digit so far
                Pair child = dfs(pos + 1, nextTight, 2, prev1, d);

                totalCount += child.count;
                totalSum += child.sum;
            } else {
                // Have at least two digits so far
                int add = 0;

                if ((prev1 > prev2 && prev1 > d) ||
                    (prev1 < prev2 && prev1 < d)) {
                    add = 1;
                }

                Pair child = dfs(pos + 1, nextTight, 2, prev1, d);

                totalCount += child.count;
                totalSum += child.sum + add * child.count;
            }
        }

        Pair ans = new Pair(totalCount, totalSum);

        if (!tight) {
            memo[pos][lenState][prev2][prev1] = ans;
        }

        return ans;
    }
}
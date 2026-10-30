class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        long sum = 0;
        for (int x : stones) {
            sum += x;
        }

        long dp = sum;
        long prefix = sum;

        for (int i = n - 1; i >= 2; i--) {
            prefix -= stones[i];
            dp = Math.max(dp, prefix - dp);
        }

        return (int) dp;
    }
}
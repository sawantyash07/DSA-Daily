class Solution {

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int totalMasks = 1 << n;

        long[] lcm = new long[totalMasks];
        int[] sign = new int[totalMasks];

        lcm[0] = 1;

        // Precompute LCM and inclusion-exclusion sign
        for (int mask = 1; mask < totalMasks; mask++) {
            int bit = Integer.numberOfTrailingZeros(mask);
            int prev = mask & (mask - 1);

            long g = gcd(lcm[prev], coins[bit]);
            long value = lcm[prev] / g * coins[bit];

            lcm[mask] = value;

            // Odd number of coins -> add
            // Even number of coins -> subtract
            sign[mask] = -sign[prev];

            if (prev == 0) {
                sign[mask] = 1;
            }
        }

        long low = 1;
        long high = (long) k * getMinimum(coins);

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, lcm, sign) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, long[] lcm, int[] sign) {
        long result = 0;

        for (int mask = 1; mask < lcm.length; mask++) {

            // No multiple of this LCM can exist <= x
            if (lcm[mask] > x) {
                continue;
            }

            result += sign[mask] * (x / lcm[mask]);
        }

        return result;
    }

    private long getMinimum(int[] coins) {
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
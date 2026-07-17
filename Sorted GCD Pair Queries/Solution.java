class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] divisible = new long[max + 1];

        // Count numbers divisible by each value
        for (int d = 1; d <= max; d++) {
            long cnt = 0;
            for (int m = d; m <= max; m += d) {
                cnt += freq[m];
            }
            divisible[d] = cnt;
        }

        long[] exact = new long[max + 1];

        // Inclusion-Exclusion
        for (int d = max; d >= 1; d--) {
            long pairs = divisible[d] * (divisible[d] - 1) / 2;

            for (int m = d + d; m <= max; m += d) {
                pairs -= exact[m];
            }

            exact[d] = pairs;
        }

        // Prefix counts
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;

            int l = 1, r = max;

            while (l < r) {
                int mid = (l + r) >>> 1;

                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}
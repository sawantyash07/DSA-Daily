import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        for (long start : freq.keySet()) {

            if (start == 1) {
                int f = freq.get(1L);
                if ((f & 1) == 0) f--;
                ans = Math.max(ans, Math.max(1, f));
                continue;
            }

            long cur = start;
            int len = 0;

            while (true) {
                Integer f = freq.get(cur);

                if (f == null) {
                    len--;
                    break;
                }

                if (f >= 2) {
                    len += 2;

                    if (cur > 1000000000L / cur) {
                        len--;
                        break;
                    }

                    cur = cur * cur;
                } else {
                    len++;
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
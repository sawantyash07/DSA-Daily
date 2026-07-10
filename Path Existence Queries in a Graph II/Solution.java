import java.util.*;

class Solution {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        Arrays.sort(order, Comparator.comparingInt(a -> nums[a]));

        int[] values = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = nums[order[i]];
            pos[order[i]] = i;
        }

        // Connected Components
        int[] comp = new int[n];
        int cid = 0;
        comp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (values[i] - values[i - 1] > maxDiff) cid++;
            comp[i] = cid;
        }

        // next[i] = farthest reachable in one jump
        int[] next = new int[n];
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && values[r + 1] - values[l] <= maxDiff) {
                r++;
            }
            next[l] = r;
        }

        int LOG = 18;
        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++) up[0][i] = next[i];

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            int jumps = 0;
            int cur = u;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    jumps += 1 << k;
                    cur = up[k][cur];
                }
            }

            ans[qi] = jumps + 1;
        }

        return ans;
    }
}
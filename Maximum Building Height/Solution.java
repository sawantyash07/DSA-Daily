import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
        }

        Collections.sort(list, (a, b) -> a[0] - b[0]);

        if (list.get(list.size() - 1)[0] != n) {
            list.add(new int[]{n, n - 1});
        }

        int m = list.size();

        // Left -> Right
        for (int i = 1; i < m; i++) {
            int d = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i - 1)[1] + d
            );
        }

        // Right -> Left
        for (int i = m - 2; i >= 0; i--) {
            int d = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(
                list.get(i)[1],
                list.get(i + 1)[1] + d
            );
        }

        int ans = 0;

        for (int i = 1; i < m; i++) {

            long id1 = list.get(i - 1)[0];
            long h1  = list.get(i - 1)[1];

            long id2 = list.get(i)[0];
            long h2  = list.get(i)[1];

            long d = id2 - id1;

            long peak = (h1 + h2 + d) / 2;

            ans = (int)Math.max(ans, peak);
        }

        return ans;
    }
}
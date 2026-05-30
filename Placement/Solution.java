import java.util.*;

class Solution {
    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) >> 1;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return 0;

            if (ql <= l && r <= qr) return tree[node];

            int mid = (l + r) >> 1;

            return Math.max(
                query(node * 2, l, mid, ql, qr),
                query(node * 2 + 1, mid + 1, r, ql, qr)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 50001;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        SegmentTree seg = new SegmentTree(maxX + 1);

        Integer prev = null;
        for (int pos : obstacles) {
            if (prev == null) {
                seg.update(pos, 0);
            } else {
                seg.update(pos, pos - prev);
            }
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                int lastObstacle = obstacles.floor(x);

                int bestGapBeforeX = seg.query(0, x);
                int tailGap = x - lastObstacle;

                ans.add(Math.max(bestGapBeforeX, tailGap) >= sz);
            } else {
                int x = q[1];

                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);

                seg.update(x, 0);

                if (right != null) {
                    seg.update(right, right - left);
                }

                obstacles.remove(x);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
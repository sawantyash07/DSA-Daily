import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') totalOnes++;
        }

        List<int[]> ZB = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') i++;
                ZB.add(new int[]{start, i - 1, i - start});
            } else {
                i++;
            }
        }

        int m = ZB.size();
        int[] OB = new int[Math.max(0, m - 1)];
        for (int j = 0; j < m - 1; j++) {
            OB[j] = ZB.get(j + 1)[0] - ZB.get(j)[1] - 1;
        }

        int[] maxAdjZ = new int[Math.max(0, m - 1)];
        for (int j = 0; j < m - 1; j++) {
            maxAdjZ[j] = ZB.get(j)[2] + ZB.get(j + 1)[2];
        }

        int[] maxZ = new int[m];
        for (int j = 0; j < m; j++) {
            maxZ[j] = ZB.get(j)[2];
        }

        int[][] stMaxAdj = buildMaxST(maxAdjZ);
        int[][] stMaxZ = buildMaxST(maxZ);
        int[][] stMinO = buildMinST(OB);

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int L = q[0], R = q[1];
            
            // Binary search for first overlapping 0-block
            int low = 0, high = m - 1, idx1 = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (ZB.get(mid)[1] >= L) {
                    idx1 = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Binary search for last overlapping 0-block
            low = 0; high = m - 1; int idx2 = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (ZB.get(mid)[0] <= R) {
                    idx2 = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // If zero or one 0-block inside the query range, trade cannot be completed
            if (idx1 == -1 || idx2 == -1 || idx1 >= idx2) {
                ans.add(totalOnes);
                continue;
            }

            int zFirst = Math.min(ZB.get(idx1)[1], R) - Math.max(ZB.get(idx1)[0], L) + 1;
            int zLast = Math.min(ZB.get(idx2)[1], R) - Math.max(ZB.get(idx2)[0], L) + 1;

            int max_adj = 0;
            if (idx1 + 1 == idx2) {
                max_adj = zFirst + zLast;
            } else {
                max_adj = Math.max(zFirst + ZB.get(idx1 + 1)[2], ZB.get(idx2 - 1)[2] + zLast);
                if (idx1 + 1 <= idx2 - 2) {
                    max_adj = Math.max(max_adj, queryMax(stMaxAdj, idx1 + 1, idx2 - 2));
                }
            }

            int currentMaxZ = Math.max(zFirst, zLast);
            if (idx1 + 1 <= idx2 - 1) {
                currentMaxZ = Math.max(currentMaxZ, queryMax(stMaxZ, idx1 + 1, idx2 - 1));
            }

            int currentMinO = queryMin(stMinO, idx1, idx2 - 1);

            int netGain = Math.max(max_adj, currentMaxZ - currentMinO);
            ans.add(totalOnes + netGain);
        }

        return ans;
    }

    private int[][] buildMaxST(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0][0];
        int log = Integer.numberOfTrailingZeros(Integer.highestOneBit(n)) + 1;
        int[][] st = new int[log][n];
        for (int i = 0; i < n; i++) st[0][i] = arr[i];
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[j][i] = Math.max(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
            }
        }
        return st;
    }

    private int[][] buildMinST(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0][0];
        int log = Integer.numberOfTrailingZeros(Integer.highestOneBit(n)) + 1;
        int[][] st = new int[log][n];
        for (int i = 0; i < n; i++) st[0][i] = arr[i];
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                st[j][i] = Math.min(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
            }
        }
        return st;
    }

    private int queryMax(int[][] st, int L, int R) {
        if (L > R) return 0;
        int j = Integer.numberOfTrailingZeros(Integer.highestOneBit(R - L + 1));
        return Math.max(st[j][L], st[j][R - (1 << j) + 1]);
    }

    private int queryMin(int[][] st, int L, int R) {
        if (L > R) return Integer.MAX_VALUE;
        int j = Integer.numberOfTrailingZeros(Integer.highestOneBit(R - L + 1));
        return Math.min(st[j][L], st[j][R - (1 << j) + 1]);
    }
}
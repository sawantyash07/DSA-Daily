class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int[][] a = new int[n * n][2];
        int[][] b = new int[n * n][2];

        int countA = 0, countB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    a[countA][0] = i;
                    a[countA][1] = j;
                    countA++;
                }

                if (img2[i][j] == 1) {
                    b[countB][0] = i;
                    b[countB][1] = j;
                    countB++;
                }
            }
        }

        int[] freq = new int[(2 * n - 1) * (2 * n - 1)];
        int size = 2 * n - 1;

        int ans = 0;

        for (int i = 0; i < countA; i++) {
            for (int j = 0; j < countB; j++) {
                int dx = a[i][0] - b[j][0] + n - 1;
                int dy = a[i][1] - b[j][1] + n - 1;

                int index = dx * size + dy;

                freq[index]++;
                ans = Math.max(ans, freq[index]);
            }
        }

        return ans;
    }
}
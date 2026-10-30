import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(id[i], -1);

            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int fullMask = (1 << litterCount) - 1;

        int[][][] bestEnergy = new int[m][n][1 << litterCount];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{sr, sc, energy, 0});
        bestEnergy[sr][sc][0] = energy;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == fullMask) {
                    return moves;
                }

                if (e == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    if (cell == 'X') {
                        continue;
                    }

                    int newEnergy = e - 1;
                    int newMask = mask;

                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    if (cell == 'L') {
                        newMask |= (1 << id[nr][nc]);
                    }

                    if (newMask == fullMask) {
                        return moves + 1;
                    }

                    if (newEnergy > bestEnergy[nr][nc][newMask]) {
                        bestEnergy[nr][nc][newMask] = newEnergy;

                        queue.offer(new int[]{
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
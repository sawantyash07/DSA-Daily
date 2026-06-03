import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        RideHelper waterHelper = new RideHelper(waterStartTime, waterDuration);
        RideHelper landHelper = new RideHelper(landStartTime, landDuration);

        long ans = Long.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < landStartTime.length; i++) {
            long landFinish = (long) landStartTime[i] + landDuration[i];
            ans = Math.min(ans, waterHelper.query(landFinish));
        }

        // Water -> Land
        for (int j = 0; j < waterStartTime.length; j++) {
            long waterFinish = (long) waterStartTime[j] + waterDuration[j];
            ans = Math.min(ans, landHelper.query(waterFinish));
        }

        return (int) ans;
    }

    static class RideHelper {
        int[] start;
        long[] prefixMinDuration;
        long[] suffixMinStartPlusDuration;
        int n;

        RideHelper(int[] startTime, int[] duration) {
            n = startTime.length;

            int[][] rides = new int[n][2];
            for (int i = 0; i < n; i++) {
                rides[i][0] = startTime[i];
                rides[i][1] = duration[i];
            }

            Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

            start = new int[n];
            prefixMinDuration = new long[n];
            suffixMinStartPlusDuration = new long[n];

            for (int i = 0; i < n; i++) {
                start[i] = rides[i][0];
            }

            prefixMinDuration[0] = rides[0][1];
            for (int i = 1; i < n; i++) {
                prefixMinDuration[i] =
                        Math.min(prefixMinDuration[i - 1], rides[i][1]);
            }

            suffixMinStartPlusDuration[n - 1] =
                    (long) rides[n - 1][0] + rides[n - 1][1];

            for (int i = n - 2; i >= 0; i--) {
                suffixMinStartPlusDuration[i] = Math.min(
                        suffixMinStartPlusDuration[i + 1],
                        (long) rides[i][0] + rides[i][1]
                );
            }
        }

        long query(long finishTime) {
            int pos = upperBound(start, (int) finishTime);

            long res = Long.MAX_VALUE;

            // rides with start <= finishTime
            if (pos > 0) {
                res = Math.min(res,
                        finishTime + prefixMinDuration[pos - 1]);
            }

            // rides with start > finishTime
            if (pos < n) {
                res = Math.min(res,
                        suffixMinStartPlusDuration[pos]);
            }

            return res;
        }

        private int upperBound(int[] arr, int target) {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}
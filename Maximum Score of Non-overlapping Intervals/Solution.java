import java.util.*;
class Solution {
    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Interval[] a = new Interval[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(a, (x, y) -> {
            if (x.r != y.r)
                return Integer.compare(x.r, y.r);
            return Integer.compare(x.l, y.l);
        });

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = a[i].r;
        }

        State[] prev = new State[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = new State(0, new int[0]);
        }

        for (int k = 1; k <= 4; k++) {
            State[] cur = new State[n + 1];

            cur[0] = new State(0, new int[0]);

            for (int i = 1; i <= n; i++) {
                Interval current = a[i - 1];

                State skip = cur[i - 1];

                int p = lowerBound(ends, current.l);

                State previous = prev[p];

                int[] newIndices = addIndex(
                    previous.indices,
                    current.idx
                );

                State take = new State(
                    previous.score + current.w,
                    newIndices
                );

                cur[i] = better(take, skip);
            }

            prev = cur;
        }

        return prev[n].indices;
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int[] addIndex(int[] indices, int idx) {
        int[] result = Arrays.copyOf(indices, indices.length + 1);

        result[indices.length] = idx;

        Arrays.sort(result);

        return result;
    }

    private State better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return lexicographicallySmaller(a, b);
    }

    private State lexicographicallySmaller(State a, State b) {
        int n = Math.min(a.indices.length, b.indices.length);

        for (int i = 0; i < n; i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i] ? a : b;
            }
        }

        if (a.indices.length != b.indices.length) {
            return a.indices.length < b.indices.length ? a : b;
        }

        return a;
    }
}   
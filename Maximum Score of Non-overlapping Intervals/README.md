Problem

You are given a 2D integer array intervals, where:

intervals[i] = [left_i, right_i, weight_i]

Each interval has a starting position, ending position, and weight.

You can select at most 4 non-overlapping intervals.

The score is the sum of the weights of the selected intervals.

Two intervals are considered overlapping if they share any point. Therefore, for two intervals:

[a, b] and [c, d]

they are non-overlapping only when:

b < c

If multiple selections have the same maximum score, return the lexicographically smallest array of original indices.

Approach

We use Dynamic Programming + Binary Search.

1. Sort by Right Endpoint

Sort all intervals according to their ending position.

This allows us to efficiently find the last interval that can be selected before the current interval.

2. Binary Search

For every interval [l, r, weight], we find the first interval whose right endpoint is greater than or equal to l.

Since intervals sharing a boundary are considered overlapping, the previous interval must satisfy:

previous.right < current.left

Therefore, we use a lower-bound binary search.

3. Dynamic Programming

We can select at most 4 intervals, so we perform DP for:

k = 1, 2, 3, 4

For every interval, we have two choices:

Skip the interval

Keep the best result obtained so far.

Take the interval

Add its weight to the best result consisting of compatible intervals.

The recurrence is conceptually:

dp[k][i] =
    max(
        dp[k][i - 1],
        weight[i] + dp[k - 1][previous]
    )
Lexicographical Tie-Breaking

If two selections have the same score, we compare their original interval indices.

For example:

[1, 4]
[1, 5]

[1, 4] is lexicographically smaller.

The selected indices are maintained in sorted order before comparison.

Example
Input
intervals = [
    [1,3,2],
    [4,5,2],
    [1,5,5],
    [6,9,3],
    [6,7,1],
    [8,9,1]
]

The optimal selection is:

[2, 3]

Their weights are:

interval 2 -> 5
interval 3 -> 3

Total score:

5 + 3 = 8

Therefore:

Output: [2,3]
Complexity

Let n be the number of intervals.

Time Complexity

Sorting:

O(n log n)

Binary search for every interval and each of the 4 DP levels:

O(4n log n)

Since 4 is constant:

O(n log n)
Space Complexity

We store the intervals, DP states, and selected indices:

O(n)

Therefore:

Time:  O(n log n)
Space: O(n)
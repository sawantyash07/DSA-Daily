Problem

Given n points on a 1-D plane, where the ith point is located at x = i, find the number of ways to draw exactly k non-overlapping line segments.

Each segment:

Must cover at least two points.
Must have integral-coordinate endpoints.
Cannot overlap another segment.
Can share endpoints with another segment.
Does not need to cover all n points.

Since the answer can be very large, return it modulo:

10^9 + 7
Example
Input
n = 4
k = 2

The points are:

0   1   2   3
●---●---●---●

We need to choose exactly 2 non-overlapping segments.

There are 5 valid ways.

Output
5
Key Observation

The number of valid ways can be represented using a combination:

C(n + k - 1, 2k)

where:

n = number of points
k = number of segments
2k = total number of segment endpoints

So the answer is:

C(n + k - 1, 2k)
Example

For:

n = 4
k = 2

we get:

C(4 + 2 - 1, 2 × 2)
= C(5, 4)
= 5

Therefore:

Answer = 5
Approach

We calculate the binomial coefficient using Pascal's identity:

C(i, j) = C(i - 1, j) + C(i - 1, j - 1)

Instead of building a complete 2D Pascal triangle, we use a 1D array.

Initially:

dp[0] = 1

For every value of i, we update the array from right to left.

Updating from right to left is important because it prevents the current iteration from using values that have already been modified.

Algorithm

Calculate:

target = 2 × k
Create a DP array of size target + 1.

Set:

dp[0] = 1
Iterate from 1 to n + k - 1.
For each iteration, update dp from target down to 1.

The final answer is:

dp[2 × k]
Return the answer modulo 10^9 + 7.
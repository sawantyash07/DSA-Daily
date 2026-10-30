LeetCode 1872 — Stone Game VIII
Problem

Alice and Bob play a game with stones arranged in a row. On each turn, a player must remove at least two stones from the left side, add their sum to their score, and replace them with one stone containing that sum.

Alice wants to maximize the score difference, while Bob wants to minimize it.

The goal is to return:

Alice's Score - Bob's Score

assuming both players play optimally.

Approach

The solution uses:

Prefix sums
Dynamic programming
Bottom-up optimization

Let prefix[i] represent the sum of the first i + 1 stones.

If the current player takes the first i + 1 stones, they gain prefix[i]. The remaining game is then played by the opponent.

If dp represents the opponent's optimal score difference, the current player's score difference becomes:

prefix[i] - dp

Therefore, we update:

dp = max(dp, prefix[i] - dp)

We start with the case where Alice takes all stones:

dp = total sum

Then process possible prefix lengths from right to left.

Algorithm
Calculate the total sum of all stones.
Initialize dp with the total sum.
Maintain the current prefix sum.
Iterate from n - 1 down to 2.
Remove stones[i] from the current prefix sum.

Update dp using:

dp = max(dp, prefix - dp)
Return dp.
Complexity
Time Complexity: O(n)
Space Complexity: O(1)
Integer Type: long is used internally to safely handle sums.
Example
Input
stones = [-1, 2, -3, 4, -5]
Output
5
Explanation

Alice removes the first four stones:

-1 + 2 - 3 + 4 = 2

Alice's score is 2.

Bob then removes the remaining two stones:

2 + (-5) = -3

Bob's score is -3.

Therefore:

2 - (-3) = 5
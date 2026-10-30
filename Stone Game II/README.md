1140. Stone Game II
Problem

Alice and Bob play a game with piles of stones arranged in a row.

Alice starts first. On each turn, a player can take the first X remaining piles, where:

1 <= X <= 2 * M

After taking X piles:

M = max(M, X)

Initially:

M = 1

Both players play optimally. The goal is to maximize the number of stones collected.

Given an integer array piles, return the maximum number of stones Alice can get.

Examples
Example 1

Input:

piles = [2,7,9,4,4]

Output:

10
Example 2

Input:

piles = [1,2,3,4,5,100]

Output:

104
Approach

We use Dynamic Programming with a suffix sum array.

Define:

dp[i][M]

as the maximum number of stones the current player can collect starting from index i with the current value of M.

For every state, the player can take X piles where:

1 <= X <= 2 * M

After taking X piles:

newM = max(M, X)

If the current player takes X piles, the opponent starts from:

i + X

with:

newM

The total stones remaining from index i are:

suffix[i]

Therefore, if the opponent can collect:

dp[i + X][newM]

the current player gets:

suffix[i] - dp[i + X][newM]

We try every possible X and take the maximum.

Complexity

Let n be the number of piles.

Time Complexity: O(n³)
Space Complexity: O(n²)

With n <= 100, this approach is efficient enough.
1510. Stone Game IV
Problem

Alice and Bob play a game with n stones in a pile. Alice goes first.

On each turn, a player can remove any non-zero perfect square number of stones.

A player who cannot make a move loses the game.

Given n, return true if Alice can win when both players play optimally. Otherwise, return false.

Examples
Example 1

Input:

n = 1

Output:

true

Explanation:

Alice can remove 1 stone:

1 → 0

Bob has no stones left and cannot make a move, so Alice wins.

Example 2

Input:

n = 2

Output:

false

Explanation:

Alice can only remove 1 stone:

2 → 1

Bob removes the remaining 1 stone:

1 → 0

Therefore, Alice loses.

Example 3

Input:

n = 4

Output:

true

Explanation:

Alice can remove 4, which is a perfect square:

4 → 0

Bob cannot make a move, so Alice wins.

Approach

This problem can be solved using Dynamic Programming.

Define:

dp[i] = true

if the player whose turn it is can force a win when there are exactly i stones remaining.

Otherwise:

dp[i] = false
Transition

For every number of stones i, try removing every possible perfect square:

1, 4, 9, 16, ...

If removing a square leaves the opponent in a losing position:

dp[i - square] == false

then the current player can win.

Therefore:

dp[i] = true

If no perfect-square move leads to a losing position for the opponent, then:

dp[i] = false
Base Case
dp[0] = false

When there are 0 stones, the current player cannot make a move and therefore loses.

Algorithm
Create a boolean array dp of size n + 1.
Set dp[0] = false.
For every i from 1 to n:
Try every square j * j <= i.
If dp[i - j * j] is false, set dp[i] = true.
Stop checking further squares for this i.
Return dp[n].
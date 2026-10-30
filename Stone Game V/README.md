# 1563. Stone Game V

## Problem

Alice has a row of stones. In each round, she divides the row into two non-empty parts.

Bob compares the sums of both parts:

- If the left sum is smaller, Bob removes the right part.
- If the right sum is smaller, Bob removes the left part.
- If both sums are equal, Alice can choose which part to remove.

Alice adds the value of the remaining part to her score.

Return the maximum score Alice can obtain.

## Approach

Use Interval Dynamic Programming.

Let:

`dp[l][r]`

represent the maximum score Alice can obtain from the subarray `stoneValue[l...r]`.

For every possible split position `k`:

- If `leftSum < rightSum`:
  - Right part is removed.
  - Score = `leftSum + dp[l][k]`

- If `leftSum > rightSum`:
  - Left part is removed.
  - Score = `rightSum + dp[k+1][r]`

- If `leftSum == rightSum`:
  - Alice chooses the better side.
  - Score = `leftSum + max(dp[l][k], dp[k+1][r])`

Prefix sums are used to calculate subarray sums in `O(1)`.

## Complexity

- Time: `O(n^3)`
- Space: `O(n^2)`

## Example

Input:

`[6,2,3,4,5,5]`

Output:

`18`

## Language

Java 21
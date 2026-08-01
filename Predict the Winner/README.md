# 486. Predict the Winner

## Problem Statement

Two players are playing a game with an integer array `nums`.

- Player 1 starts first.
- On each turn, a player picks **either the leftmost or rightmost** number from the array.
- The picked number is added to that player's score.
- Both players play **optimally**.
- If both players end with the same score, **Player 1 is considered the winner**.

Return `true` if Player 1 can win, otherwise return `false`.

**LeetCode:** 486. Predict the Winner  
**Difficulty:** Medium

---

## Examples

### Example 1

**Input**
```text
nums = [1,5,2]
```

**Output**
```text
false
```

**Explanation**

No matter whether Player 1 picks `1` or `2`, Player 2 can always pick `5`, resulting in Player 2 having a higher score.

---

### Example 2

**Input**
```text
nums = [1,5,233,7]
```

**Output**
```text
true
```

**Explanation**

Player 1 can force the game so that they eventually pick `233`, ensuring victory.

---

## Approach

Instead of tracking both players' scores separately, we calculate the **maximum score difference** the current player can achieve over the opponent.

Let:

```text
dp(i, j)
```

represent the **maximum score difference** the current player can obtain from the subarray `nums[i...j]`.

### Choices

If the current player picks the left element:

```text
nums[i] - dp(i + 1, j)
```

If the current player picks the right element:

```text
nums[j] - dp(i, j - 1)
```

Choose the better option:

```text
dp(i, j) = max(
    nums[i] - dp(i + 1, j),
    nums[j] - dp(i, j - 1)
)
```

---

## Base Case

When only one element remains,

```text
dp(i, i) = nums[i]
```

because the current player picks that element.

---

## Algorithm

1. If only one number is left, return that number.
2. Try picking the leftmost number.
3. Try picking the rightmost number.
4. Recursively calculate the opponent's best response.
5. Store results using memoization.
6. If the final score difference is **greater than or equal to zero**, Player 1 wins.

---

## Dry Run

### Input

```text
nums = [1,5,2]
```

```
solve(0,2)

Pick Left:
1 - solve(1,2)

Pick Right:
2 - solve(0,1)
```

```
solve(1,2)
= max(5-2, 2-5)
= 3

solve(0,1)
= max(1-5, 5-1)
= 4
```

```
solve(0,2)
= max(1-3, 2-4)
= max(-2,-2)
= -2
```

Since the result is negative,

```text
Player 1 loses.
```

Output:

```text
false
```

---

### Input

```text
nums = [1,5,233,7]
```

The optimal play results in

```text
dp(0,3) = 222
```

Since it is positive,

```text
Player 1 wins.
```

Output:

```text
true
```
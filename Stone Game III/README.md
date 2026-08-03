# 1406. Stone Game III

## Problem Statement

Alice and Bob are playing a game with a row of stones, where each stone has an associated integer value. Alice starts first, and on each turn, a player can take **1, 2, or 3 stones** from the beginning of the remaining row.

Each player's score is the sum of the values of the stones they take. Both players play **optimally**, aiming to maximize their final score.

Return:

- `"Alice"` if Alice wins.
- `"Bob"` if Bob wins.
- `"Tie"` if both players finish with the same score.

---

## Examples

### Example 1

**Input**

```text
stoneValue = [1,2,3,7]
```

**Output**

```text
Bob
```

**Explanation**

Alice's best possible move still results in Bob having a higher total score.

---

### Example 2

**Input**

```text
stoneValue = [1,2,3,-9]
```

**Output**

```text
Alice
```

**Explanation**

Alice must take the first three stones to force Bob into taking the negative-valued stone.

---

### Example 3

**Input**

```text
stoneValue = [1,2,3,6]
```

**Output**

```text
Tie
```

**Explanation**

Both players can achieve the same final score if they play optimally.

---

# Approach

This problem is a classic **Dynamic Programming + Game Theory (Minimax)** problem.

Instead of tracking the individual scores of Alice and Bob, we calculate the **maximum score difference** that the current player can obtain over the opponent.

Let:

- `dp[i]` = Maximum score difference (Current Player − Opponent) starting from index `i`.

At every position, the current player has three choices:

1. Take one stone.
2. Take two stones.
3. Take three stones.

After taking the stones, the opponent plays optimally from the next index.

Therefore,

```
Current Difference = Stones Taken - Opponent's Best Difference
```

The recurrence becomes:

```
dp[i] = max(
    sum(1 stone)  - dp[i+1],
    sum(2 stones) - dp[i+2],
    sum(3 stones) - dp[i+3]
)
```

The final answer depends on `dp[0]`:

- `dp[0] > 0` → Alice wins.
- `dp[0] < 0` → Bob wins.
- `dp[0] == 0` → Tie.

---

# Algorithm

1. Let `n` be the number of stones.
2. Create a DP array of size `n + 1`.
3. Initialize `dp[n] = 0`.
4. Traverse from right to left.
5. At every position:
   - Try taking 1, 2, and 3 stones.
   - Compute the current sum.
   - Update the best score difference.
6. Check `dp[0]` and return the winner.

---
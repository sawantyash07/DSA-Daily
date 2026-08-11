# 877. Stone Game

## Problem Statement
Alice and Bob are playing a game with an even number of stone piles arranged in a row.

- Alice always plays first.
- On each turn, a player removes the **entire** pile from either the beginning or the end of the row.
- Both players play optimally.
- The total number of stones is **odd**, so a tie is impossible.

Return **true** if Alice wins; otherwise, return **false**.

---

## Approach

Instead of using Dynamic Programming, this problem has a mathematical observation.

Since:

- The number of piles is **even**.
- Alice makes the first move.
- Alice can always choose to collect either:
  - all piles at **even indices**, or
  - all piles at **odd indices**.
- Before making the first move, Alice knows which parity (even or odd indexed piles) has the larger total number of stones.
- By choosing the appropriate end on her first move, she can force the game so that she always picks piles from that parity.

Because the total number of stones is odd, one parity must contain strictly more stones than the other.

Therefore, Alice is guaranteed to collect more stones than Bob.

Hence, the answer is always **true**.

---

## Algorithm

1. Observe that the number of piles is even.
2. Alice chooses the parity (even-indexed or odd-indexed piles) with the larger total.
3. She can always force herself to take piles from that parity.
4. Therefore, Alice always wins.
5. Return `true`.

---

## Correctness

- Alice has complete control over which parity of indices she collects.
- One parity always has a strictly greater total number of stones.
- Since both players play optimally, Alice secures the larger total.
- Therefore, Alice always wins.

---

## Complexity Analysis

- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)` 
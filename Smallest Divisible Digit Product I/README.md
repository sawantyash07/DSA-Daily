# 3345. Smallest Divisible Digit Product I

## Problem Statement

Given two integers `n` and `t`, return the **smallest integer greater than or equal to `n`** such that the **product of its digits** is divisible by `t`.

### Examples

**Example 1**
```
Input: n = 10, t = 2
Output: 10
```

**Example 2**
```
Input: n = 15, t = 3
Output: 16
```

---

## Approach

Since the constraints are very small (`1 <= n <= 100`), we can simply check every number starting from `n`.

For each number:

1. Compute the product of its digits.
2. Check whether the product is divisible by `t`.
3. If yes, return the current number.
4. Otherwise, increment the number and repeat.

This brute-force approach is efficient enough because only a small range of numbers needs to be examined.

---

## Algorithm

1. Start from the given integer `n`.
2. Calculate the product of its digits.
3. If `product % t == 0`, return the current number.
4. Otherwise, increment `n` and continue searching.

---

## Complexity Analysis

- **Time Complexity:** `O(k × d)`
  - `k` = number of integers checked.
  - `d` = number of digits in each integer (at most 3 for the given constraints).

- **Space Complexity:** `O(1)`
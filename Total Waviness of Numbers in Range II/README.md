# 3753. Total Waviness of Numbers in Range II

## Problem
Given two integers `num1` and `num2`, find the total sum of waviness for all numbers in the inclusive range `[num1, num2]`.

A digit is:
- **Peak** if it is strictly greater than both adjacent digits.
- **Valley** if it is strictly less than both adjacent digits.

The first and last digits cannot be peaks or valleys.

## Approach

This solution uses **Digit Dynamic Programming (Digit DP)**.

### Key Idea
For every number ≤ N:

- Build the number digit by digit.
- Maintain the last two digits.
- When a new digit is added, determine whether the middle digit forms:
  - a Peak
  - a Valley
- Accumulate the total waviness across all valid numbers.

To get the answer for a range:

Total Waviness = F(num2) - F(num1 - 1)

Where:
- F(N) = Total waviness of all numbers from 1 to N.

## State Definition

Digit DP State:

(pos, tight, lenState, prev2, prev1)

Where:
- pos = current digit position
- tight = whether current prefix matches N
- lenState:
  - 0 = number not started
  - 1 = one digit chosen
  - 2 = at least two digits chosen
- prev2 = second last digit
- prev1 = last digit

## Complexity

- Time Complexity: O(16 × 3 × 11 × 11 × 10)
- Space Complexity: O(16 × 3 × 11 × 11)

## Concepts Used

- Digit DP
- Dynamic Programming
- State Compression
- Range Query Optimization

## LeetCode

Problem: 3753 - Total Waviness of Numbers in Range II

Difficulty: Hard
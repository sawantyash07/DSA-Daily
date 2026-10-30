# 3702. Longest Subsequence With Non-Zero Bitwise XOR

## 📝 Problem Statement

Given an integer array `nums`, return the length of the **longest subsequence** in `nums` whose bitwise **XOR is non-zero**.

If no such subsequence exists, return `0`.

### Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`

---

## 💡 Approach

The key observation is to calculate the XOR of all elements in the array.

### Case 1: Total XOR is non-zero

If the XOR of all elements is non-zero, then the entire array is a valid subsequence.

Therefore:

```text
answer = n
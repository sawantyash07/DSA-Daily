# 2574. Left and Right Sum Differences

## Problem Statement

Given a 0-indexed integer array `nums` of size `n`, calculate:

- `leftSum[i]`: Sum of all elements to the left of index `i`.
- `rightSum[i]`: Sum of all elements to the right of index `i`.

Return an array `answer` where:

answer[i] = |leftSum[i] - rightSum[i]|

---

## Example

### Input
```text
nums = [10,4,8,3]
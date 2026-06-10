# 3691. Maximum Total Subarray Value II

## Problem Link
https://leetcode.com/problems/maximum-total-subarray-value-ii/

## Difficulty
Hard

## Approach

The value of a subarray is:

Value = max(subarray) - min(subarray)

We need to select exactly `k` distinct subarrays such that the total sum of their values is maximized.

### Key Observations

1. For a fixed starting index `l`, as the ending index `r` increases, the subarray grows.
2. We need efficient range maximum and minimum queries.
3. A Sparse Table allows:
   - Range Maximum Query (RMQ) in O(1)
   - Range Minimum Query (RMQ) in O(1)
4. For every starting index `l`, compute the value of the largest possible subarray `[l...n-1]`.
5. Store these candidates in a Max Heap.
6. Repeatedly extract the largest value from the heap:
   - Add it to the answer.
   - Generate the next candidate by reducing the right boundary.
7. Continue until exactly `k` subarrays are selected.

### Data Structures Used

- Sparse Table
- Priority Queue (Max Heap)

### Complexity Analysis

Building Sparse Table:
- Time: O(n log n)
- Space: O(n log n)

Heap Operations:
- O(k log n)

Overall:
- Time: O(n log n + k log n)
- Space: O(n log n)
# 3689. Maximum Total Subarray Value I

## Problem
Given an integer array `nums` and an integer `k`, choose exactly `k` non-empty subarrays.

The value of a subarray is:

value = max(subarray) - min(subarray)

Subarrays may overlap, and the same subarray can be chosen multiple times.

Return the maximum possible total value.

## Approach

Since the same subarray can be selected multiple times, we only need to find the maximum possible value of a single subarray.

The maximum subarray value is:

max(nums) - min(nums)

because a subarray containing both the global maximum and global minimum will achieve this value.

Since we can choose the same subarray `k` times:

Answer = k × (max(nums) - min(nums))

## Algorithm

1. Find the maximum element in the array.
2. Find the minimum element in the array.
3. Compute `maxVal - minVal`.
4. Multiply the result by `k`.
5. Return the answer.

## Complexity Analysis

- Time Complexity: O(n)
- Space Complexity: O(1)
# 3300. Minimum Element After Replacement With Digit Sum

## Problem Statement
Given an integer array `nums`, replace each element with the sum of its digits and return the minimum element after all replacements.

### Example 1
Input:
nums = [10,12,13,14]

Output:
1

Explanation:
Digit sums = [1,3,4,5]
Minimum = 1

### Example 2
Input:
nums = [1,2,3,4]

Output:
1

### Example 3
Input:
nums = [999,19,199]

Output:
10

## Approach
1. Traverse each element in the array.
2. Calculate the sum of its digits.
3. Keep track of the minimum digit sum.
4. Return the minimum value found.

## Algorithm
- Initialize `min` as `Integer.MAX_VALUE`.
- For every number:
  - Extract digits using `% 10`.
  - Add digits to `digitSum`.
  - Update `min`.
- Return `min`.

## Time Complexity
O(n × d)

Where:
- n = number of elements
- d = number of digits in each element

Since `nums[i] <= 10^4`, d is at most 5.

## Space Complexity
O(1)


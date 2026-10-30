3471. Find the Largest Almost Missing Integer
Problem

Given an integer array nums and an integer k, an integer x is called almost missing if it appears in exactly one subarray of size k.

Return the largest almost missing integer. If no such integer exists, return -1.

Example

Input:

nums = [3,9,2,1,7]
k = 3

Output:

7
Explanation

The subarrays of size 3 are:

[3, 9, 2]
[9, 2, 1]
[2, 1, 7]

The number of subarrays containing each value is:

Number	Subarrays
1	2
2	3
3	1
7	1
9	2

Only 3 and 7 appear in exactly one subarray. Therefore, the largest almost missing integer is 7.

Approach

We examine every possible subarray of size k.

For each subarray:

Create a seen array to identify distinct values in the current subarray.
Mark every value present in that subarray.
Increase count[x] for every distinct value x.
After processing all subarrays, search from 50 down to 0.
Return the first value whose count is exactly 1.

The seen array is important because if a number appears multiple times in the same subarray, that subarray should still count only once.

For example:

nums = [0, 0]
k = 1

Each [0] is a separate subarray, so 0 appears in two subarrays and is not almost missing.
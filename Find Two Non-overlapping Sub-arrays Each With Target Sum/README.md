Given an integer array arr and an integer target, find two non-overlapping subarrays whose sums are both equal to target.

Return the minimum possible sum of their lengths.

If it is impossible to find two such subarrays, return -1.

Example
Input:
arr = [7,3,4,7]
target = 7

Output:
2

Explanation:

[7]       → length 1
[3,4]     → length 2
[7]       → length 1

Choose the first and third subarrays:

1 + 1 = 2
Approach

We use:

Two Pointers / Sliding Window to find subarrays with sum equal to target.
An auxiliary array len[] to remember the shortest valid subarray found so far.

Since every element is positive (arr[i] >= 1), the sliding window technique works efficiently.

Two Pointer Technique

Maintain two pointers:

left
right

and a running sum:

sum

For every right:

Add arr[right] to sum.
If sum > target, move left forward and subtract elements.
If sum == target, we found a valid subarray.
Calculate its length:
currentLength = right - left + 1
How len[] Works

len[i] stores:

The minimum length of a target-sum subarray found completely within arr[0...i].

For example:

arr = [7,3,4,7]
target = 7

The first [7] has length 1.

So as we move through the array, we preserve this minimum:

len[0] = 1
len[1] = 1
len[2] = 1
len[3] = 1

This allows us to quickly find the best previous subarray.

Finding Two Non-overlapping Subarrays

When we find the current target-sum subarray:

[left ... right]

the previous subarray must end before left.

Therefore, we use:

len[left - 1]

If it exists:

answer = Math.min(
    answer,
    currentLength + len[left - 1]
);

This guarantees that the two subarrays do not overlap.
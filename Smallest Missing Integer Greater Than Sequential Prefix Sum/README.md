2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
Problem

You are given a 0-indexed array nums.

A prefix nums[0..i] is called sequential if every element after the first is exactly one greater than the previous element:

nums[j] = nums[j - 1] + 1

The prefix containing only nums[0] is also considered sequential.

The task is to:

Find the longest sequential prefix of the array.
Calculate the sum of all elements in that prefix.
Find the smallest integer that:
is greater than or equal to this sum, and
does not exist anywhere in nums.
Example 1
Input
nums = [1,2,3,2,5]

The longest sequential prefix is:

[1,2,3]

Its sum is:

1 + 2 + 3 = 6

6 is not present in the array.

Output
6
Example 2
Input
nums = [3,4,5,1,12,14,13]

The longest sequential prefix is:

[3,4,5]

Its sum is:

3 + 4 + 5 = 12

The numbers 12, 13, and 14 are present in the array.

The first missing number greater than or equal to 12 is:

15
Output
15
Approach
Step 1: Find the longest sequential prefix

Start with the first element and keep adding elements while:

nums[i] == nums[i - 1] + 1

For example:

[1, 2, 3, 2, 5]

We have:

1 → 2 → 3

But:

2 != 3 + 1

So the sequential prefix ends at 3.

The sum is:

6
Step 2: Mark all numbers present in the array

Use a boolean array where:

present[x] = true

if x occurs in nums.

Step 3: Find the smallest missing number

Start from the sequential prefix sum and check whether that number exists.

If it exists, increment it and continue.

For example:

sum = 12

If:

12 → present
13 → present
14 → present
15 → missing

then the answer is:

15
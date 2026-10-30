Problem

You are given a 0-indexed array of positive integers nums and a positive integer limit.

In one operation, you can swap nums[i] and nums[j] if:

|nums[i] - nums[j]| <= limit

You can perform the operation any number of times.

The goal is to return the lexicographically smallest array that can be obtained.

Approach

The main observation is that values can be connected through a chain of valid swaps.

For example, if:

nums = [1, 3, 5]
limit = 2

Then:

|1 - 3| = 2
|3 - 5| = 2

So all three values can be rearranged among their original positions, even though:

|1 - 5| = 4

Therefore, we first sort the values and divide them into groups.

Steps
Store each value along with its original index.
Sort the pairs by value.
Create groups:
If the difference between consecutive values is <= limit, they belong to the same group.
Otherwise, start a new group.
For each group:
Get all original indices.
Sort the indices.
The values are already sorted.
Assign the smallest value to the smallest original index.
Return the resulting array.
Example
Input
nums = [1, 7, 6, 18, 2, 1]
limit = 3

After sorting:

Value   Index
1       0
1       5
2       4
6       2
7       1
18      3

Groups:

[1, 1, 2]
[6, 7]
[18]

For the first group, original indices are:

[0, 5, 4]

After sorting:

[0, 4, 5]

Assign the sorted values:

index 0 -> 1
index 4 -> 1
index 5 -> 2

For the second group:

indices = [2, 1]
sorted  = [1, 2]

index 1 -> 6
index 2 -> 7

Final answer:

[1, 6, 7, 18, 1, 2]
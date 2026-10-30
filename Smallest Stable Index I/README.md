3903. Smallest Stable Index I
Problem

You are given an integer array nums and an integer k.

For every index i, calculate its instability score:

max(nums[0..i]) - min(nums[i..n-1])

An index is called stable if its instability score is less than or equal to k.

Return the smallest stable index. If no stable index exists, return -1.

Approach

We need two values for every index:

Prefix Maximum
The maximum value from index 0 to i.
Suffix Minimum
The minimum value from index i to n - 1.

We first calculate the suffix minimum array.

Then, while traversing the array from left to right, we maintain the prefix maximum.

For each index:

instability = prefixMax - suffixMin[i]

If:

instability <= k

then the current index is stable, so we return it immediately because we are traversing from left to right.

If no index satisfies the condition, return -1.

Algorithm
Create a suffixMin array of size n.

Set the last element:

suffixMin[n - 1] = nums[n - 1]
Traverse from right to left and calculate the minimum value from each index to the end.
Initialize prefixMax.
Traverse the array from left to right.
Update prefixMax with the current element.

Calculate:

prefixMax - suffixMin[i]
If the result is less than or equal to k, return i.
If no stable index is found, return -1.
Example
Input
nums = [5, 0, 1, 4]
k = 3
Prefix Maximum
[5, 5, 5, 5]
Suffix Minimum
[0, 0, 1, 4]
Instability Scores
Index 0: 5 - 0 = 5
Index 1: 5 - 0 = 5
Index 2: 5 - 1 = 4
Index 3: 5 - 4 = 1

At index 3:

1 <= 3

Therefore:

Answer = 3
Complexity
Time Complexity: O(n)
Space Complexity: O(n)

The array is traversed a constant number of times.
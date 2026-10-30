3904. Smallest Stable Index II
Problem

Given an integer array nums and an integer k, the instability score of an index i is:

max(nums[0..i]) - min(nums[i..n-1])

An index is called stable if its instability score is less than or equal to k.

Return the smallest stable index. If no stable index exists, return -1.

Approach

We need two values for every index:

Maximum from the beginning to the current index
Minimum from the current index to the end
Step 1: Suffix Minimum

Create an array suffixMin[] where:

suffixMin[i] = minimum value from nums[i] to nums[n-1]

Build this array from right to left.

Step 2: Prefix Maximum

Traverse the array from left to right and maintain:

prefixMax = maximum value from nums[0] to nums[i]

For every index i, calculate:

instability = prefixMax - suffixMin[i]

If:

instability <= k

then i is stable, so return it immediately.

If no index satisfies the condition, return -1.

Example
Input
nums = [5, 0, 1, 4]
k = 3
Calculation
Index	Prefix Maximum	Suffix Minimum	Instability
0	5	0	5
1	5	0	5
2	5	1	4
3	5	4	1

At index 3:

1 <= 3

Therefore:

Answer = 3
Algorithm
1. Create suffixMin array of size n.
2. Set suffixMin[n-1] = nums[n-1].
3. Traverse from right to left:
      suffixMin[i] = min(nums[i], suffixMin[i+1])

4. Set prefixMax = nums[0].
5. Traverse from left to right:
      prefixMax = max(prefixMax, nums[i])

      if prefixMax - suffixMin[i] <= k:
          return i

6. Return -1.
Complexity
Time Complexity
O(n)

We traverse the array twice.

Space Complexity
O(n)

The suffixMin[] array requires O(n) extra space.

Key Idea

The main idea is to avoid calculating the maximum and minimum for every index separately.

Instead:

prefixMax gives the maximum from the left.
suffixMin[i] gives the minimum from the right.

Therefore, the instability score can be calculated in O(1) for each index.

instability(i) = prefixMax - suffixMin[i]

This makes the complete solution O(n) instead of O(n²).
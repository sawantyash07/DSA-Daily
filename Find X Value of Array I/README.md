You are given an array of positive integers nums and a positive integer k.

You can remove a prefix and a suffix from nums, as long as the remaining array is non-empty.

The x-value is the number of ways to perform this operation such that the product of the remaining elements has remainder x when divided by k.

Return an array result of size k, where:

result[x] = number of subarrays whose product % k == x
Example
Input
nums = [1,2,3,4,5]
k = 3
Output
[9,2,4]

There are:

9 subarrays with product % 3 == 0
2 subarrays with product % 3 == 1
4 subarrays with product % 3 == 2
Approach

Removing a prefix and suffix while keeping the array non-empty is equivalent to choosing a non-empty contiguous subarray.

So, the problem becomes:

Count all non-empty subarrays according to the remainder of their product modulo k.

Since k <= 5, we can maintain the number of subarrays ending at the current position for every possible remainder.

DP State
dp[r]

represents the number of subarrays ending at the previous index whose product has remainder r modulo k.

For every nums[i]:

Start a new subarray containing only nums[i].
Extend every previous subarray by multiplying its product by nums[i].
Calculate the new remainder using:
(newRemainder) = (oldRemainder * (nums[i] % k)) % k
Add the newly generated subarrays to result.
Algorithm
Initialize result[k] with 0
Initialize dp[k] with 0

For every number num in nums:

    Create next[k]

    Start a new subarray:
        next[num % k]++

    Extend every previous subarray:
        for every remainder r:
            newRemainder = (r * (num % k)) % k
            next[newRemainder] += dp[r]

    Add next[] to result[]

    dp = next

Return result
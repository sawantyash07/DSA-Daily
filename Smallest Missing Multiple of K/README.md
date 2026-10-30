Problem Statement

Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from nums.

A positive multiple of k is:

k, 2k, 3k, 4k, ...
Example 1
Input:
nums = [8,2,3,4,6]
k = 2

Output:
10

Explanation:

Multiples of 2 → 2, 4, 6, 8, 10, ...

2  → present
4  → present
6  → present
8  → present
10 → missing

Answer = 10
Example 2
Input:
nums = [1,4,7,10,15]
k = 5

Output:
5

Explanation:

Multiples of 5 → 5, 10, 15, 20, ...

5 → missing

Answer = 5
Approach — Mathematical Logic

Every positive multiple of k can be represented as:

i × k

where:

i = 1, 2, 3, 4, ...

So we start with i = 1 and generate:

k
2k
3k
4k
...

For each generated multiple, search for it in the array.

If it is present, continue to the next multiple.
If it is not present, return it immediately.

The first missing multiple is guaranteed to be the smallest missing positive multiple.
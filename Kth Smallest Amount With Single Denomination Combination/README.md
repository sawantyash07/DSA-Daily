3116. Kth Smallest Amount With Single Denomination Combination
Problem

You are given an array coins containing different coin denominations and an integer k.

You have an unlimited number of coins of each denomination, but you cannot combine different denominations.

For each coin c, you can create:

c, 2c, 3c, 4c, ...

The task is to find the kth smallest distinct amount that can be created.

Example
Input:
coins = [5, 2]
k = 7


Output:
12

The possible amounts in sorted order are:

2, 4, 5, 6, 8, 10, 12, 14, 15, ...

Therefore, the 7th smallest amount is:

12
Approach

We use:

Binary Search
Inclusion-Exclusion Principle
LCM and GCD
Bitmasking
1. Count amounts ≤ X

For a coin c, the number of multiples of c less than or equal to X is:

X / c

For example:

X = 20
c = 5


20 / 5 = 4

The amounts are:

5, 10, 15, 20

However, when multiple coins are present, some amounts are counted multiple times.
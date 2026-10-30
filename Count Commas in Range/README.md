3870. Count Commas in Range
Problem

You are given an integer n.

Return the total number of commas used when writing all integers from 1 to n in standard number formatting.

A comma is inserted after every three digits from the right.

Example 1

Input:

n = 1002

Output:

3

Explanation:

The numbers 1000, 1001, and 1002 each contain one comma.

Example 2

Input:

n = 998

Output:

0

All numbers from 1 to 998 contain fewer than four digits, so no commas are used.

Approach

We iterate through every number from 1000 to n.

For each number:

Check whether it has at least four digits.
While the number is at least 1000, count one comma.
Divide the number by 1000 and continue checking.
Add the number of commas to the total answer.

For example:

1000 → 1 comma
10000 → 1 comma
100000 → 2 commas

Numbers smaller than 1000 do not contain any commas.

Algorithm
Initialize ans = 0.
Iterate from 1000 to n.
For each number, repeatedly divide it by 1000 while it is at least 1000.
Increment ans for every division.
Return ans.
Complexity
Time Complexity: O(n log n)
Space Complexity: O(1)
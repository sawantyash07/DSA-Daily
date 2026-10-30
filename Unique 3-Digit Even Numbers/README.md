Problem Statement

You are given an array of digits. Find the number of distinct three-digit even numbers that can be formed using these digits.

Rules
Each copy of a digit can be used only once in a number.
The number must contain exactly 3 digits.
The first digit cannot be 0.
The last digit must be even (0, 2, 4, 6, 8).
Duplicate numbers should be counted only once.
Examples
Example 1
Input: digits = [1,2,3,4]
Output: 12

The valid numbers include:

124, 132, 134, 142, 214, 234,
312, 314, 324, 342, 412, 432
Example 2
Input: digits = [0,2,2]
Output: 2

The valid numbers are:

202, 220
Example 3
Input: digits = [6,6,6]
Output: 1

The only possible number is:

666
Approach

We use three nested loops to select the hundreds, tens, and units digits.

For every combination:

Make sure all three array indices are different.
The hundreds digit must not be 0.
The units digit must be even.
Construct the three-digit number.
Store it in a HashSet to automatically remove duplicates.

Since the input contains at most 10 digits, there are at most:

10 × 10 × 10 = 1000

possible combinations, making brute force efficient.

Algorithm
Create an empty HashSet

For every index i:
    For every index j:
        For every index k:

            If i, j, and k are not distinct:
                skip

            If digits[i] == 0:
                skip

            If digits[k] is odd:
                skip

            Create the number:
                digits[i] * 100 + digits[j] * 10 + digits[k]

            Add the number to the HashSet

Return the size of the HashSet
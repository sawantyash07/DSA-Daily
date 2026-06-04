3751. Total Waviness of Numbers in Range I
Problem

Given two integers num1 and num2 representing an inclusive range [num1, num2], find the total sum of waviness for all numbers in the range.

Waviness Definition

A digit is:

A Peak if it is strictly greater than both of its immediate neighbors.
A Valley if it is strictly less than both of its immediate neighbors.

Notes:

The first and last digits cannot be peaks or valleys.
Any number with fewer than 3 digits has a waviness of 0.
Approach
Iterate through every number in the range [num1, num2].
Convert the number into a string.
For each middle digit:
Check if it forms a peak.
Check if it forms a valley.
Count all peaks and valleys.
Add the waviness of each number to the final answer.
Example

Input:

num1 = 120
num2 = 130

Output:

3

Explanation:

120 → Peak at digit 2 → Waviness = 1
121 → Peak at digit 2 → Waviness = 1
130 → Peak at digit 3 → Waviness = 1

Total = 3

Complexity Analysis
Time Complexity

O((num2 - num1 + 1) × d)

where d is the number of digits.

Space Complexity

O(1)
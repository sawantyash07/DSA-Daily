Given a positive integer n, determine whether n is divisible by the sum of its digit sum and digit product.

Formula
digitSum = sum of all digits
digitProduct = product of all digits

value = digitSum + digitProduct

Answer = n % value == 0
Examples
Example 1
Input: n = 99

Digit Sum = 9 + 9 = 18
Digit Product = 9 × 9 = 81

Total = 18 + 81 = 99

99 % 99 = 0

Output: true
Example 2
Input: n = 23

Digit Sum = 2 + 3 = 5
Digit Product = 2 × 3 = 6

Total = 5 + 6 = 11

23 % 11 ≠ 0

Output: false
Approach
Store n in a temporary variable.
Extract each digit using % 10.
Add each digit to sum.
Multiply each digit into product.
Remove the last digit using / 10.
Check whether n is divisible by sum + product.
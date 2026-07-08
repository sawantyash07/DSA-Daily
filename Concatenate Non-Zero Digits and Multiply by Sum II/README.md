Idea

For each query:

Ignore all zero digits.
Form the new number.
Compute the digit sum.
Return
(number × digitSum) % MOD
Key Observation

The digit sum can be answered in O(1) using a prefix sum of non-zero digits.

The number is reconstructed using modular arithmetic:

digit × 10^position

where the position depends on how many non-zero digits remain to the right.

Preprocessing
pow10[i] = 10^i mod MOD
prefixSum[i] = sum of non-zero digits before i
prefixCount[i] = count of non-zero digits before i
Query Steps
Get digit sum using prefix sums.
Count non-zero digits.
Traverse the substring.
Skip zeros.
Add each digit's contribution:
digit × 10^(remainingDigits-1)
Multiply the reconstructed number by the digit sum.
Complexity
Preprocessing: O(n)
Each query: O(length of substring)
Space: O(n)
Note

For the official constraints (n, q up to 10^5), the accepted solution on LeetCode requires a more advanced data structure (such as a segment tree with custom merge information) to achieve approximately O((n + q) log n). The above solution is easy to understand and demonstrates the core idea, but it can time out on the largest test cases.
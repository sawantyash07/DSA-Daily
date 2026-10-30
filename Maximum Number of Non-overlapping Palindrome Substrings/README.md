Given a string s and a positive integer k, select the maximum number of non-overlapping substrings such that:

Each substring has length at least k.
Each substring is a palindrome.
The selected substrings do not overlap.

Return the maximum possible number of substrings.

Examples
Example 1
Input:
s = "abaccdbbd"
k = 3

Output:
2

Explanation:

We can select:

"aba"
"dbbd"

Both are palindromes with length at least 3, and they do not overlap.

Example 2
Input:
s = "adbcda"
k = 2

Output:
0

There is no palindrome of length at least 2.

Approach

We use Dynamic Programming in two steps.

1. Palindrome DP

Create a 2D array:

palindrome[i][j]

It is true if the substring s[i...j] is a palindrome.

The recurrence is:

s[i] == s[j] && palindrome[i + 1][j - 1]

For substrings of length 1, they are always palindromes.

For substrings of length 2, they are palindromes if both characters are equal.

2. Maximum Non-overlapping Substrings

Define:

dp[i] = maximum number of valid palindromes using the first i characters

For every ending position, we have two choices:

Don't select a palindrome ending there:
dp[i] = dp[i - 1]
Select a palindrome s[j...i-1] if its length is at least k:
dp[i] = max(dp[i], dp[j] + 1)

This guarantees that the selected substrings are non-overlapping.

Complexity

Let n = s.length().

Operation	Complexity
Build palindrome table	O(n²)
DP	O(n²)
Total Time	O(n²)
Space	O(n²)
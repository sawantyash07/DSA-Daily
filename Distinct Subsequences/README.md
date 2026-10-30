115. Distinct Subsequences
Problem

Given two strings s and t, return the number of distinct subsequences of s which equals t.

A subsequence is formed by deleting some characters from a string without changing the order of the remaining characters.

Example 1

Input:

s = "rabbbit"
t = "rabbit"

Output:

3
Example 2

Input:

s = "babgbag"
t = "bag"

Output:

5
Approach

We use Dynamic Programming.

Let:

dp[i][j]

represent the number of ways to form the first j characters of t using the first i characters of s.

If:

s[i - 1] == t[j - 1]

we have two choices:

Use the current character from s.
Skip the current character from s.

Therefore:

dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]

If the characters are different, we cannot use the current character:

dp[i][j] = dp[i - 1][j]
Base Case

An empty string t can always be formed by choosing no characters from s.

Therefore:

dp[i][0] = 1
Complexity
Time Complexity: O(n × m)
Space Complexity: O(n × m)

Where:

n = s.length()
m = t.length()
Problem

Given a string s, return the number of distinct non-empty subsequences of s.

Since the answer can be very large, return it modulo 10^9 + 7.

Approach

We maintain:

dp = number of distinct subsequences including the empty subsequence.
last[c] = the value of dp before the previous occurrence of character c.

When processing a new character:

newDp = 2 * dp - last[c]

Why?

Every existing subsequence can either:

Stay unchanged.
Append the current character.

Therefore, the number initially becomes 2 * dp.

However, if the current character appeared before, some subsequences are duplicates of subsequences already created during its previous occurrence. We subtract last[c] to remove these duplicates.

After processing the character:

last[c] = dp
dp = newDp

The empty subsequence is included in dp, so we subtract 1 at the end.

Example
Input
s = "aba"

The distinct non-empty subsequences are:

"a"
"b"
"ab"
"aa"
"ba"
"aba"

Therefore:

Output: 6
Complexity
Time Complexity
O(n)

Each character is processed exactly once.

Space Complexity
O(26)

We store information for the 26 lowercase English letters.
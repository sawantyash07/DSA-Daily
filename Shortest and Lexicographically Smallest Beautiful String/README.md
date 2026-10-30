Given a binary string s and an integer k, find a substring that contains exactly k ones.

The required substring must:

Contain exactly k ones.
Have the minimum possible length.
If multiple substrings have the same minimum length, return the lexicographically smallest one.
Return an empty string if no such substring exists.
Example
Input:
s = "1011"
k = 2

Output:
"11"

The substring "11" contains exactly 2 ones and has the shortest length.

Approach

We use the Sliding Window / Two Pointer technique.

Maintain:

left → starting index of the current window
right → ending index of the current window
ones → number of ones in the current window
ans → best answer found so far
Steps
Move right from left to right.
If s[right] is 1, increment ones.
If ones > k, move left forward until the window contains at most k ones.
When ones == k:
Remove unnecessary leading zeros.
The remaining window is the shortest beautiful substring ending at right.
Compare it with ans:
Choose it if it is shorter.
If both have the same length, choose the lexicographically smaller one.
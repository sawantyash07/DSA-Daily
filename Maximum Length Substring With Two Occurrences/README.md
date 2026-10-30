Maximum Length Substring With Two Occurrences
Problem

Given a string s, return the maximum length of a substring such that each character appears at most two times in the substring.

Example 1

Input:

s = "bcbbbcba"

Output:

4
Example 2

Input:

s = "aaaa"

Output:

2
Approach

This problem can be solved efficiently using the Sliding Window technique.

We maintain a window using two pointers:

left — start of the current window
right — end of the current window
freq — stores the frequency of each character

For every character added at right:

Increment its frequency.
If its frequency becomes greater than 2, move left forward.
Decrease the frequency of characters removed from the window.
Continue until every character occurs at most twice.
Update the maximum window length.
Key Observation

The current window always satisfies:

frequency of every character <= 2

Therefore, whenever a character occurs three times, we shrink the window until the condition becomes valid again.
Problem

Given a string s containing only lowercase English letters, find the maximum number of non-empty substrings such that:

The selected substrings do not overlap.
If a substring contains a character, it must contain all occurrences of that character in the entire string.
If multiple solutions contain the same maximum number of substrings, choose the one with the minimum total length.
Approach

Since there are only 26 lowercase English letters, we can store the first and last occurrence of every character.

For every character:

Start from its first occurrence.
Extend the substring to include the last occurrence of every character inside it.
If a character inside the substring has an occurrence before the starting position, the substring is invalid.
Store every valid substring as an interval [left, right].

After generating all valid intervals, sort them by their ending position.

Then use a greedy interval scheduling strategy:

Select the interval that ends earliest.
Skip intervals that overlap with the previously selected interval.
Continue until all intervals are processed.

This gives the maximum number of non-overlapping substrings.

Example
Input
s = "adefaddaccc"

Valid candidate substrings include:

"adefadda"
"e"
"f"
"ccc"

The maximum number of non-overlapping substrings is:

["e", "f", "ccc"]
Algorithm
Find first and last occurrence of each character

For each character:
    left = first occurrence
    right = last occurrence

    Expand right while processing characters inside [left, right]

    If any character has an occurrence before left:
        substring is invalid
    Otherwise:
        store [left, right]

Sort all valid intervals by right endpoint

Select intervals greedily:
    If current.left > previous.right:
        add the substring to the answer
Complexity

Let n be the length of the string.

Time Complexity: O(26 × n) → effectively O(n)
Space Complexity: O(26)

Since the alphabet contains only 26 characters, the solution is efficient even for n = 10^5.
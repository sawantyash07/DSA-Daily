3302. Find the Lexicographically Smallest Valid Sequence
Problem

Given two strings word1 and word2, we need to select indices from word1 such that:

The indices are in strictly ascending order.
The characters at those indices form a string that is almost equal to word2.
At most one character can be changed.
Among all valid index sequences, return the lexicographically smallest one.

If no valid sequence exists, return an empty array.

Approach

The solution uses a greedy approach with suffix preprocessing.

1. Build the last array

We scan word1 from right to left and match word2 from right to left.

last[j] stores the latest index in word1 that can match word2[j] while allowing the remaining suffix of word2 to be matched.

This helps determine whether we can safely use our one allowed character modification at the current position.

2. Greedy Construction

We scan word1 from left to right.

For every position:

If word1[i] == word2[j], we select index i.
Otherwise, we can use the one allowed modification if the remaining characters of word2 can still be matched.
Once the modification is used, no further mismatches are allowed.

Because we always select the earliest possible index, the resulting sequence is lexicographically smallest.

Example
Input
word1 = "vbcca"
word2 = "abc"
Output
[0, 1, 2]

We select:

word1[0] = 'v' → change to 'a'
word1[1] = 'b'
word1[2] = 'c'

The resulting string is "abc", so the sequence is valid.

Complexity

Let:

n = word1.length()
m = word2.length()
Time Complexity
O(n + m)
Space Complexity
O(m)



Lexicographically Smallest Palindromic Permutation Greater Than Target
Problem
Given two lowercase strings s and target of the same length, return the lexicographically smallest string that:

Is a palindrome.

Is a permutation of s.

Is strictly greater than target.

If no such string exists, return "".

Key Idea
A palindrome is completely determined by its first half.

For example:

s = "baba"

Counts:
a = 2
b = 2

First half = "ab"

Possible palindromes:
"ab" + "ba" = "abba"
"ba" + "ab" = "baab"
Therefore, instead of generating complete palindromes, we only need to find the smallest valid permutation of the first half.

Algorithm
Count the frequency of every character.

A palindrome is possible only when at most one character has an odd frequency.

Build the multiset representing the first half using count[c] / 2.

Build the smallest palindrome from that half.

If it is already greater than target, return it.

Check whether the first half can be exactly equal to target's first half.

If possible, build that palindrome and check whether it is greater than target.

Otherwise, construct the smallest half greater than target's first half:

Start from the rightmost position.

Keep the prefix equal to target.

At the current position, choose the smallest available character greater than the target character.

Fill all remaining positions with the smallest available characters.

Convert the half into a palindrome and return it.

If no valid half exists, return "".

Why It Works
For two palindromes of the same length, their lexicographical order is determined by their first halves.

Suppose two palindromes have different first-half characters. The first position where their halves differ is also the first position where the complete palindromes differ.

Therefore, finding the smallest valid first half is equivalent to finding the smallest valid palindrome.

When constructing the next half:

Positions before the changed position remain equal to target.

The changed position uses the smallest possible character greater than the target character.

All remaining positions are filled in ascending order.

This produces the lexicographically smallest possible half greater than the target prefix.

Example
Example 1
s = "baba"
target = "abba"
The smallest palindrome is:

"abba"
It is not strictly greater than the target.

The next half is:

"ba"
which gives:

"baab"
Answer:

"baab"
Example 2
s = "baba"
target = "bbaa"
The possible palindromes are:

"abba"
"baab"
Both are smaller than "bbaa".

Answer:

""
Example 3
s = "abc"
Every character occurs once, so there are three odd frequencies.

A palindrome cannot be formed.

Answer:

""
Example 4
s = "aac"
target = "abb"
The only palindrome is:

"aca"
Since:

"aca" > "abb"
the answer is:

"aca"
Complexity
There are only 26 lowercase English letters.

The implementation uses at most O(n^2) work because it may check prefixes of the first half.

Time:  O(26 * n^2)
Space: O(n + 26)
With n <= 300, this comfortably fits the constraints.
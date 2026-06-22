1189. Maximum Number of Balloons
Problem Statement

Given a string text, determine the maximum number of times the word "balloon" can be formed using the characters in text.

Each character in text can be used at most once.

Example 1

Input:

text = "nlaebolko"

Output:

1
Example 2

Input:

text = "loonbalxballpoon"

Output:

2
Example 3

Input:

text = "leetcode"

Output:

0
Approach

The word "balloon" consists of:

Character	Required Count
b	1
a	1
l	2
o	2
n	1
Steps
Count the frequency of each character in the input string.
Extract the frequencies of the required characters:
b
a
l
o
n
Since l and o appear twice in "balloon", divide their frequencies by 2.
The minimum among these values represents the maximum number of complete "balloon" words that can be formed.
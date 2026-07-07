Intuition

We need to preserve the order of non-zero digits while forming a new integer. Since extracting digits mathematically processes them from right to left, using string traversal is the simplest way to maintain the original order.

Algorithm
Convert n into a string.
Initialize:
x = 0
sum = 0
Traverse every character:
If the character is '0', skip it.
Otherwise:
Convert it into an integer.

Append it to x using:

x = x * 10 + digit
Add it to sum.

Return:

x * sum
Dry Run

Input:

n = 10203004
Digit	x	sum
1	1	1
0	1	1
2	12	3
0	12	3
3	123	6
0	123	6
0	123	6
4	1234	10

Final Answer:

1234 × 10 = 12340
Complexity Analysis
Time Complexity: O(d) where d is the number of digits in n.
Space Complexity: O(1) (excluding the temporary string representation).
2213. Longest Substring of One Repeating Character
Problem

You are given a string s and a sequence of update queries.

For each query:

queryIndices[i] specifies the index to update.
queryCharacters[i] specifies the new character.
After performing the update, find the length of the longest substring consisting of only one repeating character.

Return an array containing the answer after every query.

Example
Input
s = "babacc"
queryCharacters = "bcb"
queryIndices = [1, 3, 3]
Output
[3, 3, 4]
Explanation
Initial: babacc

Query 1:
index = 1, character = b
String = bbbacc
Longest repeating substring = "bbb"
Answer = 3

Query 2:
index = 3, character = c
String = bbbccc
Longest repeating substring = "bbb" or "ccc"
Answer = 3

Query 3:
index = 3, character = b
String = bbbbcc
Longest repeating substring = "bbbb"
Answer = 4
Approach

A brute-force solution would scan the entire string after every update, resulting in:

O(n * k)

Since both n and k can be 10^5, this is too slow.

We use a Segment Tree to efficiently maintain the longest repeating substring.

Each segment-tree node stores information about its interval.

Information stored in each node
len        → Length of the interval
prefix     → Longest repeating prefix
suffix     → Longest repeating suffix
best       → Longest repeating substring in the interval
leftChar   → First character of the interval
rightChar  → Last character of the interval

For example, for:

"aaabbc"

the node information is approximately:

len = 6
prefix = 3
suffix = 1
best = 3
leftChar = 'a'
rightChar = 'c'
Merging Two Nodes

Suppose the left segment is:

aaa

and the right segment is:

aabb

The boundary characters are both a.

Therefore, the suffix of the left segment and prefix of the right segment can be combined.

aaa + aabb
^^^   ^^

The combined repeating sequence has length:

left.suffix + right.prefix

If the boundary characters are different, no combination is possible.

The merge operation therefore takes O(1) time.

Why Segment Tree?

Every query changes only one character.

Therefore, only the nodes on the path from the modified leaf to the root need to be recalculated.

             Root
            /    \
           /      \
        Node      Node
        / \       / \
       ... ...   ... ...
                 |
              Updated
               index

This makes each update:

O(log n)

The root always contains the answer for the entire string.

Algorithm
Convert the string into a character array.
Build a segment tree from the original string.
For every query:
Update the character in the original array.
Update the corresponding leaf in the segment tree.
Recalculate all affected parent nodes.
Read tree[1].best.
Store the result in the answer array.
Return the answer array.
Complexity Analysis

Let:

n = length of s
k = number of queries
Time Complexity

Building the segment tree:

O(n)

Each update:

O(log n)

For k updates:

O(k log n)

Total:

O(n + k log n)
Space Complexity

The segment tree uses:

O(n)

additional space.
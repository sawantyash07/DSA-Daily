Given two strings s and target of the same length, find the lexicographically smallest permutation of s that is strictly greater than target.

If no permutation of s is greater than target, return an empty string.

Example
Input:
s = "abc"
target = "bba"

Output:
"bca"
Approach

The main idea is to find the position where our answer will become greater than target.

We try positions from right to left.

For every position k:

Try to make the prefix target[0...k-1] exactly the same.
Check whether we have a character greater than target[k].
Choose the smallest possible greater character.
Put all remaining characters in ascending order.
Return the result.

If we cannot find such a position, return "".

Why Right to Left?

Suppose:

target = "bba"

We want the answer to be as small as possible.

If we make the difference at an earlier position:

bca

the answer becomes larger than necessary.

If we can make the difference at a later position, the result will be smaller.

Therefore, we try the rightmost possible position first.

Frequency Array

Since the strings contain only lowercase English letters, we use:

int[26]

For example:

s = "aabbc"

The frequency array stores:

a → 2
b → 2
c → 1

This allows us to efficiently check which characters are available.

Example Walkthrough

Consider:

s = "abc"
target = "bba"
Step 1

Try k = 2.

We need the prefix:

"bb"

But s contains only one b.

So we cannot form the prefix.

Move to the left.

Step 2

Try k = 1.

We need:

"b"

This is possible.

Now target[1] = 'b'.

Available characters greater than b:

c

Choose:

c

Now we have:

"b" + "c"

Remaining character:

a

Put it in sorted order:

"bca"

Therefore:

Answer = "bca"
Given a string s, calculate its reverse degree.

For each character:

Find its position in the reversed alphabet:
a = 26
b = 25
...
z = 1
Multiply this value by the character's 1-indexed position in the string.
Return the sum of all products.
Example
Input:  s = "abc"
Output: 148

Calculation:

a → 26 × 1 = 26
b → 25 × 2 = 50
c → 24 × 3 = 72

Total = 26 + 50 + 72 = 148
Approach

For every character at index i:

Reverse Alphabet Value = 'z' - s.charAt(i) + 1
Position = i + 1

Then add:

Reverse Alphabet Value × Position

to the answer.

Why ('z' - ch + 1)?

The ASCII/Unicode values of lowercase English letters are consecutive.

For example:

'z' - 'a' + 1 = 26
'z' - 'b' + 1 = 25
'z' - 'z' + 1 = 1

Therefore, this directly gives the character's position in the reversed alphabet.
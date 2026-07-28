Approach

Since the given string is already guaranteed to be palindromic, every character appears an even number of times except possibly one character (which becomes the middle of the palindrome).

To obtain the lexicographically smallest palindrome:

Count the frequency of each character.
Build the left half by adding frequency / 2 occurrences of each character in alphabetical order.
Store the character with an odd frequency (if any) as the middle character.
Append the reverse of the left half to complete the palindrome.

Because the left half is constructed in sorted order, the resulting palindrome is the smallest possible lexicographically.

Algorithm
Count the frequency of each lowercase letter.
Traverse characters from 'a' to 'z'.
Append frequency / 2 copies of each character to the left half.
Save the odd-frequency character as the middle.
Return:
Left Half
Middle Character (if present)
Reverse of Left Half
Complexity Analysis
Time Complexity: O(n)
Space Complexity: O(n)
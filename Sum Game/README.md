Alice and Bob play a game using a string num of even length containing digits and ?.

Alice plays first.
Each player replaces one ? with a digit from 0 to 9.
The game ends when there are no ? characters.
Bob wins if the sum of the first half equals the sum of the second half.
Alice wins otherwise.

Return true if Alice wins and false if Bob wins.

Approach

Maintain:

diff → difference between the digit sums of the two halves.
q → difference between the number of ? in the two halves.

For the first half:

diff += digit
q += 1

For the second half:

diff -= digit
q -= 1
Key Observation

If the total number of ? characters is odd, Alice always wins because she makes the final move and can force the sums to be different.

If the number of ? characters is even, Bob can force equality only when:

2 × diff = -9 × q

Therefore:

Alice wins if:

q is odd
OR
2 × diff != -9 × q
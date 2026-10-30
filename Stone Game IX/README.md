Problem

Given an integer array stones, Alice and Bob take turns removing one stone.

The player who removes a stone when the sum of all removed stones is divisible by 3 loses.

Alice plays first, and both players play optimally.

Return true if Alice wins, otherwise return false.

Approach

The actual values of the stones are not important. Only their remainder when divided by 3 matters.

We count:

count[0] → number of stones where stone % 3 == 0
count[1] → number of stones where stone % 3 == 1
count[2] → number of stones where stone % 3 == 2
Winning Conditions

If the number of stones divisible by 3 is even:

Alice wins if |count[1] - count[2]| > 2

If the number of stones divisible by 3 is odd:

Alice wins if count[1] > 0 AND count[2] > 0
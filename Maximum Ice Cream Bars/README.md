1833. Maximum Ice Cream Bars
Problem Statement

A boy wants to buy as many ice cream bars as possible with a limited number of coins.

You are given:

costs[i] = cost of the ith ice cream bar
coins = total coins available

The boy can buy ice cream bars in any order.

Return the maximum number of ice cream bars that can be purchased.

Example
Input
costs = [1,3,2,4,1]
coins = 7
Output
4
Explanation

After sorting:

[1,1,2,3,4]

Buy the cheapest ice creams first:

Buy 1 → coins = 6
Buy 1 → coins = 5
Buy 2 → coins = 3
Buy 3 → coins = 0

Total ice creams purchased = 4

Approach (Greedy)

To maximize the number of ice cream bars:

Sort the costs array in ascending order.
Always purchase the cheapest available ice cream first.
Continue purchasing until there are not enough coins left.
Return the total number of ice creams purchased.
Why Greedy Works?

Buying cheaper ice creams first leaves more coins available for future purchases, which maximizes the total number of ice creams that can be bought.
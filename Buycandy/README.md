# 2144. Minimum Cost of Buying Candies With Discount

## Problem Statement
A shop offers a discount where for every two candies purchased, a third candy can be taken for free. The free candy must have a cost less than or equal to the minimum cost of the two purchased candies.

Given an integer array `cost`, return the minimum cost of buying all candies.

## Approach

1. Sort the candy costs in ascending order.
2. Traverse from the most expensive candy to the least expensive.
3. For every group of three candies:
   - Pay for the two most expensive candies.
   - Get the third candy for free.
4. Sum only the costs of the candies that must be paid for.


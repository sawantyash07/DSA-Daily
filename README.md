# 3121. Count the Number of Special Characters II

## Problem
A letter is called special if:
- it appears in both lowercase and uppercase
- all lowercase occurrences appear before the first uppercase occurrence

## Approach
- Store last occurrence of lowercase letters
- Store first occurrence of uppercase letters
- Check validity using indexes

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java
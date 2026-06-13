# 3838. Weighted Word Mapping

## Problem
Given an array of words and a weight for each lowercase English letter, calculate the weight of each word as the sum of its character weights.

For each word:
1. Compute the total weight.
2. Take the result modulo 26.
3. Map the modulo value to a lowercase letter using reverse alphabetical order:
   - 0 -> z
   - 1 -> y
   - ...
   - 25 -> a

Return the concatenation of all mapped characters.

## Approach
- Iterate through each word.
- Calculate the sum of weights for all characters in the word.
- Compute `sum % 26`.
- Convert the result into a character using:
  ```java
  (char)('z' - mod)
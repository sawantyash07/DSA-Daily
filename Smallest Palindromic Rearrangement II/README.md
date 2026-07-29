# 3518. Smallest Palindromic Rearrangement II

## Problem Statement

Given a palindromic string `s` and an integer `k`, return the **k-th lexicographically smallest palindromic permutation** of `s`.

If fewer than `k` distinct palindromic permutations exist, return an empty string.

---

## Approach

Since the input string is already a palindrome, only the **first half** of the palindrome determines all unique palindromic permutations.

The algorithm constructs the answer greedily:

1. Count the frequency of each character.
2. Build the frequency array for the left half of the palindrome.
3. Identify the middle character (if one exists).
4. Precompute binomial coefficients using Pascal's Triangle.
5. Compute the total number of distinct half permutations.
6. If `k` exceeds the total number of permutations, return an empty string.
7. Construct the first half character by character:
   - Try each possible character in lexicographical order.
   - Temporarily place the character.
   - Count the number of permutations possible with the remaining characters.
   - If the count is smaller than `k`, skip those permutations.
   - Otherwise, fix the character and continue.
8. Append the middle character (if present).
9. Append the reverse of the first half to complete the palindrome.

---

## Key Idea

The number of distinct permutations of the remaining half is computed using the multinomial coefficient:

```
(total)! / (c1! × c2! × ... × c26!)
```

Instead of computing factorials directly, the solution uses combinations:

```
C(total, c1) × C(total-c1, c2) × ...
```

Pascal's Triangle is precomputed to efficiently calculate these values while capping large numbers to avoid overflow.

---

## Algorithm

1. Count character frequencies.
2. Extract frequencies for the first half.
3. Precompute combinations using Pascal's Triangle.
4. Calculate total possible half permutations.
5. If `k` is too large, return `""`.
6. Greedily construct the lexicographically smallest valid first half.
7. Build the complete palindrome.

---

## Complexity Analysis

### Time Complexity

- Frequency counting: **O(n)**
- Pascal Triangle construction: **O((n/2)²)**
- Greedy construction: **O((n/2) × 26 × 26)**

Overall:

```
O(n²)
```

where `n` is the length of the string.

---

### Space Complexity

- Frequency arrays: **O(26)**
- Pascal Triangle: **O((n/2)²)**

Overall:

```
O(n²)
```

---

## Features

- Greedy lexicographical construction.
- Efficient combinatorial counting using Pascal's Triangle.
- Avoids duplicate palindrome generation.
- Handles odd and even length palindromes.
- Prevents integer overflow by capping large combination values.
- Returns an empty string when the k-th permutation does not exist.

---

## Example

### Input

```
s = "abba"
k = 2
```

### Output

```
baab
```

### Explanation

Distinct palindromic permutations are:

```
abba
baab
```

The second lexicographically smallest palindrome is:

```
baab
```

---

## Concepts Used

- Greedy Algorithm
- Combinatorics
- Pascal's Triangle
- Multinomial Coefficient
- Lexicographical Ordering
- String Construction
- Frequency Counting

---

## Tags

`Greedy` `Combinatorics` `Math` `Backtracking` `String` `Lexicographical Order`
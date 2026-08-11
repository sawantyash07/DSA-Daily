# 3348. Smallest Divisible Digit Product II

## Problem Statement

Given:

- A string `num` representing a positive integer.
- An integer `t`.

Find the **smallest zero-free number** (contains no digit `0`) that is **greater than or equal to `num`** and whose **product of digits is divisible by `t`**.

If no such number exists, return `"-1"`.

---

## Example

### Example 1

**Input**

```
num = "1234"
t = 256
```

**Output**

```
1488
```

**Explanation**

The product of digits:

```
1 × 4 × 8 × 8 = 256
```

which is divisible by `256`.

---

### Example 2

**Input**

```
num = "12355"
t = 50
```

**Output**

```
12355
```

The digit product is already divisible by `50`.

---

### Example 3

**Input**

```
num = "11111"
t = 26
```

**Output**

```
-1
```

Since `26 = 2 × 13` and digit products can never contain prime factor `13`, no valid answer exists.

---

# Approach

## Key Observation

Every digit from **1 to 9** contributes only the following prime factors:

| Digit | Prime Factors |
|--------|---------------|
|1|—|
|2|2|
|3|3|
|4|2²|
|5|5|
|6|2×3|
|7|7|
|8|2³|
|9|3²|

Therefore, if `t` contains any prime factor other than:

- 2
- 3
- 5
- 7

then the answer is immediately `-1`.

---

## Algorithm

1. Factorize `t`.
2. Check whether `t` contains unsupported prime factors.
3. Convert every digit into its prime-factor contribution.
4. Traverse the number from left to right while maintaining the remaining prime requirements.
5. Whenever the current prefix cannot lead to a valid solution, backtrack and increase a previous digit.
6. Greedily fill the remaining suffix with the smallest possible digits satisfying the remaining prime factors.
7. If no solution of the same length exists, construct the smallest valid number with one extra digit.

---

## Data Structures Used

- StringBuilder
- Arrays
- Greedy construction
- Prime factor counting
- Backtracking
- Suffix feasibility checking

---

## Complexity Analysis

Let **n = num.length()**

### Time Complexity

```
O(n)
```

Each position is processed a constant number of times.

### Space Complexity

```
O(n)
```

for constructing the answer.

---

# Key Concepts

- Greedy Algorithm
- Prime Factorization
- String Manipulation
- Backtracking
- Mathematical Observation

---

# Edge Cases

- `num` contains zeros.
- `t = 1`.
- Impossible prime factors (11,13,17,...).
- Very large numbers (`2 × 10^5` digits).
- Answer requires increasing the length.
- Existing number already satisfies all conditions.

---

# Learning Outcomes

This problem teaches:

- Mathematical reduction using prime factors.
- Greedy construction with constraints.
- Efficient handling of very large strings.
- Backtracking techniques.
- Designing optimal algorithms for large input sizes.

---

# Tags

- Greedy
- Math
- Prime Factorization
- String
- Backtracking
- Dynamic Programming (Feasibility)
- Hard
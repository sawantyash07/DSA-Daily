# 3739. Count Subarrays With Majority Element II

## Problem Statement

Given an integer array `nums` and an integer `target`, return the number of subarrays in which `target` is the **majority element**.

A majority element is an element that appears **strictly more than half** the number of times in a subarray.

---

## Approach

### Key Observation

For any subarray:

- Let `x` = number of occurrences of `target`
- Let `y` = number of occurrences of all other elements

The target is a majority if:

```
x > y
```

Instead of counting frequencies directly, transform the array as follows:

- Replace every occurrence of `target` with **+1**
- Replace every other element with **-1**

Now the sum of any transformed subarray becomes:

```
(+1 × x) + (-1 × y)
= x - y
```

The majority condition becomes:

```
x > y
⇔ x - y > 0
⇔ Subarray Sum > 0
```

Thus, the problem is reduced to:

> Count the number of subarrays whose transformed sum is **positive**.

---

## Prefix Sum

Let:

```
prefix[i] = sum of transformed values from index 0 to i-1
```

For any subarray `(l...r)`:

```
Subarray Sum = prefix[r+1] - prefix[l]
```

We need:

```
prefix[r+1] - prefix[l] > 0
```

which implies:

```
prefix[l] < prefix[r+1]
```

So, while iterating through the prefix sums, for every current prefix sum we count how many previous prefix sums are **strictly smaller**.

---

## Efficient Solution

Since prefix sums range from `-n` to `n`, we:

1. Compute all prefix sums.
2. Coordinate-compress the prefix sums.
3. Use a **Fenwick Tree (Binary Indexed Tree)** to:
   - Count previous prefix sums smaller than the current one.
   - Insert the current prefix sum.

Both operations take **O(log n)** time.

---

## Algorithm

1. Convert the array:
   - `target → +1`
   - others → `-1`
2. Compute prefix sums.
3. Coordinate-compress the prefix sums.
4. Initialize a Fenwick Tree.
5. Traverse the prefix sums:
   - Query how many previous prefix sums are smaller.
   - Add this count to the answer.
   - Insert the current prefix sum into the Fenwick Tree.
6. Return the answer.

---

## Complexity Analysis

- **Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(n)`

---

## Example

### Input

```
nums = [1,2,2,3]
target = 2
```

### Transformation

```
[-1, +1, +1, -1]
```

### Prefix Sums

```
0, -1, 0, 1, 0
```

Counting previous prefix sums smaller than the current prefix:

| Current Prefix | Smaller Previous Prefixes | New Valid Subarrays |
|----------------|---------------------------|---------------------|
| 0              | 0                         | 0                   |
| -1             | 0                         | 0                   |
| 0              | 1                         | 1                   |
| 1              | 3                         | 3                   |
| 0              | 1                         | 1                   |

Total:

```
0 + 0 + 1 + 3 + 1 = 5
```

### Output

```
5
```

---

## Data Structures Used

- Prefix Sum Array
- Coordinate Compression
- Fenwick Tree (Binary Indexed Tree)
- HashMap

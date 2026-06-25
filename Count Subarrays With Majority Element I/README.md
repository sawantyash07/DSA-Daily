# 3737. Count Subarrays With Majority Element I

## Problem
Given an integer array `nums` and an integer `target`, return the number of subarrays in which `target` is the **majority element**.

A majority element is an element that appears **strictly more than half** of the total elements in the subarray.

---

## Approach

### Key Observation

For any subarray,

- Let `x` = number of occurrences of `target`
- Let `y` = number of non-target elements

For `target` to be the majority element:

```
x > (x + y) / 2
```

Multiplying both sides by 2:

```
2x > x + y
x > y
```

Thus, the number of target elements must be greater than the number of non-target elements.

---

### Array Transformation

Convert the original array into:

- `+1` if the element is equal to `target`
- `-1` otherwise

Example:

```
nums   = [1, 2, 2, 3]
target = 2

Converted Array:
[-1, +1, +1, -1]
```

Now,

```
Subarray Sum
= (#target) - (#non-target)
```

If the sum is positive,

```
#target > #non-target
```

which means `target` is the majority element.

---

### Prefix Sum

Build a prefix sum array to compute any subarray sum in O(1).

```
prefix[0] = 0

prefix[i+1] = prefix[i] + convertedValue
```

Subarray sum from `l` to `r`:

```
sum = prefix[r + 1] - prefix[l]
```

If

```
sum > 0
```

then the subarray is valid.

---

## Algorithm

1. Convert each element:
   - `target → +1`
   - `others → -1`
2. Build the prefix sum array.
3. Iterate through every possible subarray.
4. Compute its sum using prefix sums.
5. If the sum is greater than 0, increment the answer.
6. Return the final count.

---

## Complexity Analysis

- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(n)`

Since `n ≤ 1000`, checking all subarrays is efficient enough.
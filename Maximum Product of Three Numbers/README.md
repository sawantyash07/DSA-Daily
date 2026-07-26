# 628. Maximum Product of Three Numbers

## Problem Statement

Given an integer array `nums`, return the maximum product that can be obtained by multiplying any three numbers in the array.

**LeetCode Link:** https://leetcode.com/problems/maximum-product-of-three-numbers/

---

## Examples

### Example 1

**Input**
```text
nums = [1,2,3]
```

**Output**
```text
6
```

---

### Example 2

**Input**
```text
nums = [1,2,3,4]
```

**Output**
```text
24
```

---

### Example 3

**Input**
```text
nums = [-1,-2,-3]
```

**Output**
```text
-6
```

---

## Approach

The maximum product can be formed in two different ways:

1. Product of the three largest numbers.
2. Product of the two smallest (most negative) numbers and the largest number.

Since multiplying two negative numbers results in a positive number, both possibilities must be considered.

The answer is:

```text
max(
    largest1 × largest2 × largest3,
    smallest1 × smallest2 × largest1
)
```

---

## Algorithm

1. Traverse the array once.
2. Keep track of:
   - Three largest numbers.
   - Two smallest numbers.
3. Compute both possible products.
4. Return the larger product.

---

## Java Solution

```java
class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }

            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(1)** |

---

## Key Insight

The maximum product is **not always** obtained from the three largest numbers.

Example:

```text
nums = [-10, -10, 1, 2, 3]
```

- Three largest: `3 × 2 × 1 = 6`
- Two smallest and largest: `(-10) × (-10) × 3 = 300`

Therefore, we must consider both possibilities.

---

## Tags

- Array
- Greedy
- Math
- Sorting

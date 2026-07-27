# 1464. Maximum Product of Two Elements in an Array

## Problem Statement

Given an integer array `nums`, choose two different indices `i` and `j` such that the product of `(nums[i] - 1)` and `(nums[j] - 1)` is maximized.

Return the maximum value of:

(nums[i] - 1) * (nums[j] - 1)

---

## Example

### Example 1

**Input**
```
nums = [3,4,5,2]
```

**Output**
```
12
```

**Explanation**
- Choose 5 and 4.
- (5 - 1) × (4 - 1) = 4 × 3 = 12.

---

### Example 2

**Input**
```
nums = [1,5,4,5]
```

**Output**
```
16
```

---

## Approach

### Optimized Linear Scan

Instead of sorting the array, we maintain the two largest numbers while traversing the array once.

1. Initialize two variables:
   - `max1` → Largest element
   - `max2` → Second largest element
2. Traverse every element:
   - If the current number is greater than `max1`, update both.
   - Otherwise, update `max2` if necessary.
3. Return:

```
(max1 - 1) * (max2 - 1)
```

This approach avoids sorting and runs in linear time.

---

## Algorithm

1. Initialize `max1 = 0` and `max2 = 0`.
2. Traverse the array.
3. Update the largest and second largest values.
4. Compute:

```
(max1 - 1) * (max2 - 1)
```

5. Return the result.

---

## Java Solution

```java
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
```

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Why This Approach?

- Single traversal of the array.
- No sorting required.
- Constant extra space.
- Faster than the sorting approach (`O(n log n)`).

---

## Key Concepts

- Array Traversal
- Greedy Selection
- Finding Largest & Second Largest Element
- Time Optimization
- Constant Space Algorithm

---

## Tags

- Arrays
- Greedy
- Simulation
- Math

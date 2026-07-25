# 3536. Maximum Product of Two Digits

## Problem Statement

Given a positive integer `n`, return the maximum product of any two digits in `n`.

- You may use the same digit twice only if it appears more than once.

## Approach

The maximum product will always be obtained by multiplying the two largest digits.

Instead of storing all digits and sorting them, we scan the digits once while maintaining:

- `max1` → largest digit seen so far
- `max2` → second largest digit seen so far

For every digit:

1. If it is greater than or equal to `max1`
   - Move `max1` to `max2`
   - Update `max1`
2. Otherwise, if it is greater than `max2`
   - Update `max2`

Finally, return:

```
max1 * max2
```

## Algorithm

1. Initialize:
   - `max1 = -1`
   - `max2 = -1`
2. Traverse each digit of the number.
3. Update the two largest digits.
4. Return their product.

## Dry Run

### Example 1

Input:

```
n = 124
```

Digits:

```
1, 2, 4
```

Processing:

| Digit | max1 | max2 |
|------:|-----:|-----:|
| 1 | 1 | -1 |
| 2 | 2 | 1 |
| 4 | 4 | 2 |

Answer:

```
4 × 2 = 8
```

---

### Example 2

Input:

```
n = 22
```

Digits:

```
2, 2
```

Processing:

| Digit | max1 | max2 |
|------:|-----:|-----:|
| 2 | 2 | -1 |
| 2 | 2 | 2 |

Answer:

```
2 × 2 = 4
```

---

## Correctness

The largest possible product must involve the two largest digits in the number.

Since the algorithm always keeps track of the largest and second-largest digits during a single traversal, it correctly computes the maximum product.

## Complexity Analysis

- **Time Complexity:** `O(d)`
  - where `d` is the number of digits (at most 10).

- **Space Complexity:** `O(1)`

## Java 21 Solution

```java
class Solution {
    public int maxProduct(int n) {
        int max1 = -1;
        int max2 = -1;

        while (n > 0) {
            int digit = n % 10;

            if (digit >= max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }

            n /= 10;
        }

        return max1 * max2;
    }
}
```
# 1732. Find the Highest Altitude

## Problem Statement

There is a biker going on a road trip. The road trip consists of `n + 1` points at different altitudes. The biker starts at point `0` with an altitude of `0`.

You are given an integer array `gain` of length `n`, where `gain[i]` represents the net gain (or loss) in altitude between points `i` and `i + 1`.

Return the **highest altitude** reached during the trip.

---

## Examples

### Example 1

**Input:**
```text
gain = [-5,1,5,0,-7]
```

**Output:**
```text
1
```

**Explanation:**
```text
Altitudes = [0, -5, -4, 1, 1, -6]
Highest altitude = 1
```

### Example 2

**Input:**
```text
gain = [-4,-3,-2,-1,4,3,2]
```

**Output:**
```text
0
```

**Explanation:**
```text
Altitudes = [0, -4, -7, -9, -10, -6, -3, -1]
Highest altitude = 0
```

---

## Approach

- Start with altitude `0`.
- Maintain a running sum to calculate the current altitude after each gain/loss.
- Track the maximum altitude encountered during the traversal.
- Return the maximum altitude.

### Algorithm

1. Initialize:
   - `currentAltitude = 0`
   - `maxAltitude = 0`
2. Iterate through the `gain` array:
   - Add the current gain to `currentAltitude`.
   - Update `maxAltitude` if `currentAltitude` is greater.
3. Return `maxAltitude`.

---

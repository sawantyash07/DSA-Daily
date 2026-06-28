# 1846. Maximum Element After Decreasing and Rearranging

## Problem Statement

You are given an array of positive integers `arr`.

You can perform the following operations any number of times:

1. Rearrange the elements in any order.
2. Decrease any element to any smaller positive integer.

After performing these operations, the array must satisfy:

- The first element must be `1`.
- The absolute difference between every pair of adjacent elements must be at most `1`.

Return the maximum possible value of any element in the final array.

---

## Approach (Greedy + Sorting)

Since we can rearrange the array freely, the optimal strategy is to **sort** it first.

### Greedy Idea

- After sorting, make the first element `1`.
- For every remaining element:
  - If it is greater than `previous + 1`, decrease it to `previous + 1`.
  - Otherwise, keep it unchanged.

This ensures:
- The adjacent difference is always at most `1`.
- Every element is as large as possible, maximizing the final answer.

---

## Algorithm

1. Sort the array.
2. Set `arr[0] = 1`.
3. Traverse from left to right:
   - Update
     ```
     arr[i] = min(arr[i], arr[i - 1] + 1)
     ```
4. Return the last element.

---

## Dry Run

### Input

```
arr = [100,1,1000]
```

### Step 1: Sort

```
[1,100,1000]
```

### Step 2: First element

```
[1,100,1000]
```

### Step 3: Process remaining elements

```
100 → min(100,2) = 2
```

```
[1,2,1000]
```

```
1000 → min(1000,3) = 3
```

Final array

```
[1,2,3]
```

Maximum element

```
3
```

---

## Correctness

After sorting, each element should be as large as possible while satisfying:

```
current ≤ previous + 1
```

- Choosing a smaller value would unnecessarily reduce the maximum element.
- Choosing a larger value would violate the adjacent difference constraint.

Thus, the greedy choice is always optimal.

---

## Complexity Analysis

- **Time Complexity:** `O(n log n)` (sorting dominates)
- **Space Complexity:** `O(1)` (excluding sorting space)
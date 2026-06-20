# 1840. Maximum Building Height

## Problem Statement

You want to build `n` buildings in a line, numbered from `1` to `n`.

The following conditions must be satisfied:

1. The height of the first building must be `0`.
2. The height of each building must be a non-negative integer.
3. The height difference between adjacent buildings cannot exceed `1`.
4. Some buildings have maximum height restrictions:
   - `restrictions[i] = [id, maxHeight]`
   - Building `id` must have height ≤ `maxHeight`.

Return the maximum possible height of the tallest building.

---

## Approach

### Step 1: Add Mandatory Restrictions

- Building `1` always has height `0`, so add:

```java
[1, 0]
```

- If building `n` is not present in restrictions, add:

```java
[n, n - 1]
```

because starting from height `0`, the maximum possible height at building `n` is `n - 1`.

---

### Step 2: Sort Restrictions

Sort all restrictions by building index.

---

### Step 3: Left-to-Right Constraint Propagation

For two consecutive restricted buildings:

```text
(id1, h1)
(id2, h2)
```

The maximum reachable height at `id2` from `id1` is:

```text
h1 + (id2 - id1)
```

Update:

```java
h2 = min(h2, h1 + distance)
```

---

### Step 4: Right-to-Left Constraint Propagation

Similarly:

```java
h1 = min(h1, h2 + distance)
```

This ensures all restrictions are mutually valid.

---

### Step 5: Find Maximum Peak

For two adjacent restricted points:

```text
(id1, h1)
(id2, h2)
```

Let:

```text
distance = id2 - id1
```

The highest achievable height between them is:

```text
(h1 + h2 + distance) / 2
```

Take the maximum over all intervals.

---

## Dry Run

### Input

```java
n = 5
restrictions = [[2,1],[4,1]]
```

After adding mandatory restrictions:

```text
[1,0]
[2,1]
[4,1]
[5,4]
```

After propagation:

```text
[1,0]
[2,1]
[4,1]
[5,2]
```

Possible heights:

```text
0 1 2 1 2
```

Maximum height:

```text
2
```

---

## Complexity Analysis

### Time Complexity

```text
O(m log m)
```

where `m` is the number of restrictions.

- Sorting: `O(m log m)`
- Two passes: `O(m)`
- Peak calculation: `O(m)`

### Space Complexity

```text
O(m)
```

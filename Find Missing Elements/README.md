# 3731. Find Missing Elements

## Problem Statement

You are given an integer array `nums` consisting of **unique integers**.

Originally, the array contained every integer within a continuous range. However, some integers are now missing. The **smallest** and **largest** integers of the original range are guaranteed to still be present.

Return a **sorted list** of all missing integers within the range. If no integers are missing, return an empty list.

---

## Examples

### Example 1

**Input**

```text
nums = [1,4,2,5]
```

**Output**

```text
[3]
```

**Explanation**

The original range is `[1,2,3,4,5]`. Only `3` is missing.

---

### Example 2

**Input**

```text
nums = [7,8,6,9]
```

**Output**

```text
[]
```

**Explanation**

The range is `[6,7,8,9]` and no elements are missing.

---

### Example 3

**Input**

```text
nums = [5,1]
```

**Output**

```text
[2,3,4]
```

**Explanation**

The original range is `[1,2,3,4,5]`.

---

## Approach

We use a **HashSet** to efficiently check whether a number exists in the array.

### Algorithm

1. Create a `HashSet` and insert every element of the array.
2. Simultaneously determine the minimum and maximum values.
3. Iterate from `min` to `max`.
4. If a number is not present in the set, add it to the answer list.
5. Return the list.

---

## Dry Run

### Input

```text
nums = [1,4,2,5]
```

### Step 1: Build HashSet

```text
Set = {1,2,4,5}
```

### Step 2: Find Range

```text
Minimum = 1
Maximum = 5
```

### Step 3: Traverse Range

| Number | Present? | Action |
|--------:|:--------:|--------|
| 1 | Yes | Skip |
| 2 | Yes | Skip |
| 3 | No | Add to answer |
| 4 | Yes | Skip |
| 5 | Yes | Skip |

### Final Answer

```text
[3]
```
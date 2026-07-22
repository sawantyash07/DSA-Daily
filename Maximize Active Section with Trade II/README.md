# 3501. Maximize Active Section with Trade II

## Approach

Instead of simulating every possible trade, observe that removing a surrounded `1` block only serves one purpose:

It merges its two neighboring zero blocks into one larger zero block.

When that merged zero block is converted into `1`s, the removed `1`s are added back automatically.

Therefore, the removed `1` block contributes **0** to the final gain.

Hence,

Gain = Left Zero Block + Right Zero Block

So the problem reduces to finding the maximum sum of two adjacent zero groups inside each query.

---

## Preprocessing

1. Count total active sections (`1`s).
2. Compress all consecutive `0`s into zero groups.
3. Store for every index which zero group it belongs to.
4. Build

```
merge[i] = zeroGroup[i] + zeroGroup[i+1]
```

5. Build a Sparse Table over `merge[]` for Range Maximum Query.

---

## Query Processing

For every query:

- Compute the partial zero group on the left boundary.
- Compute the partial zero group on the right boundary.
- Query the Sparse Table for complete zero-group merges.
- Check all boundary combinations.
- Add the best gain to the original number of ones.

---

## Correctness

Removing a surrounded one-block merges two neighboring zero groups.

The removed ones disappear in the first operation but are immediately restored during the second operation.

Thus the only net increase equals the total size of the merged zero block, which is exactly:

```
leftZero + rightZero
```

The algorithm checks every possible merged zero block that can exist inside the query, including boundary partial groups, guaranteeing the optimal answer.

---

## Complexity

### Preprocessing

- Build zero groups: **O(n)**
- Merge array: **O(n)**
- Sparse Table: **O(n log n)**

### Per Query

- Constant-time computations
- Sparse Table RMQ: **O(1)**

### Total

```
O(n log n + q)
```

Space Complexity:

```
O(n log n)
```

---

## Data Structures Used

- Array
- Zero Group Compression
- Sparse Table (Range Maximum Query)
- Prefix-style boundary calculations

---

## Key Insight

The size of the removed `1` block never affects the final answer.

Only the sizes of the two adjacent zero groups matter.
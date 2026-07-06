# 1288. Remove Covered Intervals

## Idea

An interval `[a, b]` is covered by `[c, d]` if

```
c <= a
b <= d
```

Instead of comparing every interval with every other interval, sort the intervals so covered intervals appear immediately after the interval that covers them.

---

## Sorting

Sort by

1. Start in ascending order
2. If starts are equal, end in descending order

Example

Input

```
[1,4]
[1,8]
[2,5]
```

After sorting

```
[1,8]
[1,4]
[2,5]
```

The larger interval comes first, making covered intervals easy to detect.

---

## Algorithm

1. Sort the intervals.
2. Keep the largest ending point seen so far (`maxEnd`).
3. Traverse the intervals:
   - If current end is greater than `maxEnd`, it is not covered.
   - Otherwise, it is covered.
4. Return the count of uncovered intervals.

---

## Example

Input

```
[[1,4],[3,6],[2,8]]
```

Sorted

```
[1,4]
[2,8]
[3,6]
```

Traversal

```
maxEnd = 4

[2,8]
8 > 4
count = 2
maxEnd = 8

[3,6]
6 <= 8
Covered
```

Answer

```
2
```

---

## Correctness

After sorting:

- Every future interval has a start greater than or equal to previous intervals.
- Therefore, if its end is less than or equal to `maxEnd`, some previous interval completely contains it.

Thus checking only the ending point is sufficient.

---

## Complexity

- Sorting: **O(n log n)**
- Traversal: **O(n)**

Overall:

```
O(n log n)
```

Space:

```
O(1)
```
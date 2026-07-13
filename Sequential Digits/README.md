# 1291. Sequential Digits

## Problem

An integer has **sequential digits** if every digit is exactly one greater than the previous digit.

Return all sequential digit numbers within the range `[low, high]` in sorted order.

---

## Approach

Instead of checking every number between `low` and `high`, generate only valid sequential numbers.

Use the string:

```
123456789
```

Every sequential digit number is simply a substring of this string.

Examples:

Length 2

```
12
23
34
45
56
67
78
89
```

Length 3

```
123
234
345
456
567
678
789
```

Continue until length 9.

Convert every substring into an integer.

If the number lies in the range `[low, high]`, add it to the answer.

Since numbers are generated in increasing order, the final list is already sorted.

---

## Algorithm

1. Create the string `"123456789"`.
2. Generate substrings of lengths **2 to 9**.
3. Convert each substring to an integer.
4. If it lies between `low` and `high`, add it to the answer.
5. Return the answer.

---

## Dry Run

### Input

```
low = 100
high = 300
```

Generated numbers

```
12
23
34
45
56
67
78
89
123 ✓
234 ✓
345 ✗
...
```

Output

```
[123,234]
```

---

## Complexity Analysis

- Time Complexity: **O(1)**
- Space Complexity: **O(1)**

At most **36** sequential numbers are generated regardless of input size.


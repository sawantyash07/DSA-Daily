# 1967. Number of Strings That Appear as Substrings in Word

## Problem Statement

Given an array of strings `patterns` and a string `word`, return the number of strings in `patterns` that appear as a **substring** in `word`.

A substring is a contiguous sequence of characters within a string.

---

## Approach

Since the constraints are very small (`patterns.length <= 100` and `word.length <= 100`), we can simply check each pattern individually.

For every string in `patterns`:

1. Check whether it exists in `word` using Java's built-in `contains()` method.
2. If it exists, increment the answer.
3. Return the final count.

This approach is simple, efficient, and sufficient for the given constraints.

---

## Algorithm

1. Initialize `count = 0`.
2. Iterate through every string in `patterns`.
3. If `word.contains(pattern)` returns `true`, increment `count`.
4. Return `count`.

---

## Dry Run

### Input

```text
patterns = ["a","abc","bc","d"]
word = "abc"
```

### Execution

| Pattern | Exists in `word`? | Count |
|---------|-------------------|-------|
| "a" | Yes | 1 |
| "abc" | Yes | 2 |
| "bc" | Yes | 3 |
| "d" | No | 3 |

### Output

```text
3
```

---
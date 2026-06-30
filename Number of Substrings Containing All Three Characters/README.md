# 1358. Number of Substrings Containing All Three Characters

## Problem Statement

Given a string `s` consisting only of characters `'a'`, `'b'`, and `'c'`, return the number of substrings that contain **at least one occurrence of all three characters**.

---

## Approach: Sliding Window (Two Pointers)

### Intuition

Instead of checking every possible substring (which takes **O(n²)** time), we use a **sliding window**.

The idea is to maintain a window `[left, right]` that expands until it contains all three characters (`a`, `b`, and `c`).

Once the current window is valid:

- Every substring obtained by extending the window to the right is also valid.
- Therefore, instead of counting each substring individually, we can count them all at once.

---

## Key Observation

Suppose the string is:

```text
abcabc
012345
```

Current window:

```text
abc
```

- `left = 0`
- `right = 2`

The window already contains:

- ✅ a
- ✅ b
- ✅ c

Now all these substrings are also valid:

```text
abc
abca
abcab
abcabc
```

There are **4** valid substrings.

This is equal to:

```text
n - right
= 6 - 2
= 4
```

So whenever the window becomes valid:

```java
answer += n - right;
```

---

## Why `n - right`?

Once the current window contains all three characters, adding more characters to the right **cannot remove** any existing character.

If

```text
abc
```

is valid,

then

```text
abca
abcab
abcabc
```

are also valid.

Hence, all ending positions from `right` to `n-1` are valid.

Number of such endings:

```text
n - right
```

---

## Algorithm

1. Initialize two pointers:
   - `left = 0`
   - `right = 0`

2. Maintain the frequency of:
   - `a`
   - `b`
   - `c`

3. Expand the window by moving `right`.

4. Whenever all three frequencies become greater than zero:
   - Add `n - right` to the answer.
   - Shrink the window from the left.
   - Continue shrinking while the window remains valid.

5. Return the final answer.

---

## Dry Run

Input:

```text
s = "abcabc"
```

### Step 1

Window:

```text
abc
```

Valid

```
Answer += 6 - 2 = 4
```

Remove `'a'`

Window:

```text
bc
```

Invalid

---

### Step 2

Move right

Window:

```text
bca
```

Valid

```
Answer += 6 - 3 = 3
```

Current answer:

```
4 + 3 = 7
```

Remove `'b'`

Window becomes invalid.

---

### Step 3

Window:

```text
cab
```

Valid

```
Answer += 6 - 4 = 2
```

Current answer:

```
9
```

---

### Step 4

Window:

```text
abc
```

Valid

```
Answer += 6 - 5 = 1
```

Final answer:

```
10
```

---
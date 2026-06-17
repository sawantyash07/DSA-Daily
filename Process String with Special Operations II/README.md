# 3614. Process String with Special Operations II

## Problem Statement
Given a string `s` consisting of lowercase English letters and special characters `*`, `#`, and `%`, process the string from left to right:

- Lowercase letter → Append to result.
- `*` → Remove the last character from result if it exists.
- `#` → Duplicate the current result and append it to itself.
- `%` → Reverse the current result.

Return the `k`th character of the final string. If `k` is out of bounds, return `'.'`.

---

## Approach

Building the final string is impossible because its length can grow up to `10^15`.

Instead:

### Step 1: Track Lengths
Store the length of the resulting string after every operation.

- Letter → `len + 1`
- `*` → `max(0, len - 1)`
- `#` → `len * 2`
- `%` → Length remains unchanged

### Step 2: Reverse Simulation
Starting from index `k`, traverse the operations backward and determine where the character originated.

#### Operations in Reverse

- **Letter**
  - If `pos == previousLength`, this letter is the answer.

- **`*`**
  - Position remains unchanged.

- **`#`**
  - The string was duplicated.
  - Map position back using:
    ```java
    pos %= previousLength;
    ```

- **`%`**
  - Reverse operation.
  - Map position back using:
    ```java
    pos = length - 1 - pos;
    ```

---

## Complexity Analysis

- Time Complexity: **O(n)**
- Space Complexity: **O(n)**

where `n` is the length of the input string.

---

## Topics

- Strings
- Simulation
- Reverse Processing
- Length Tracking
- Hard LeetCode
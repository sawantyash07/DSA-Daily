# 3014. Minimum Number of Pushes to Type Word I

## Problem Statement

You are given a string `word` containing **distinct lowercase English letters**.

A telephone keypad has **8 usable keys (2–9)**. Each key can be assigned any number of letters, but each letter must belong to exactly one key.

- The **first letter** on a key requires **1 push**.
- The **second letter** on the same key requires **2 pushes**.
- The **third letter** requires **3 pushes**, and so on.

Your task is to remap the letters to the keys such that the **total number of key presses** required to type the given word is minimized.

---

## Approach

Since there are **8 keys**, at most **8 letters** can occupy the **first position** and therefore cost **1 push**.

After filling these positions:

- The next **8 letters** must occupy the **second position**, costing **2 pushes** each.
- The next **8 letters** cost **3 pushes** each.
- Any remaining letters cost **4 pushes** each.

Because every character in the word is **distinct** and appears **exactly once**, the actual letters do not matter—only the **number of letters** matters.

For every character at index `i`:

- Cost = `(i / 8) + 1`

---

## Algorithm

1. Let `n` be the length of the word.
2. Initialize `pushes = 0`.
3. Iterate through all characters.
4. Add `(i / 8) + 1` to the answer.
5. Return the total pushes.

---

## Correctness

- There are only **8 first positions**, so assigning more than 8 letters with cost 1 is impossible.
- Assigning letters to the cheapest available positions always minimizes the total cost.
- Since all letters are unique and occur once, every assignment with the same cost distribution gives the same answer.

Thus, the algorithm always returns the minimum number of pushes.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

where `n` is the length of the word.
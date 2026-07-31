# 3016. Minimum Number of Pushes to Type Word II

## Problem Statement

You are given a string `word` consisting of lowercase English letters.

A telephone keypad has **8 usable keys (2–9)**, and each key can be mapped to any number of distinct letters. Every letter must belong to exactly one key.

The cost of typing a letter depends on its position on the assigned key:

- First letter on a key → **1 push**
- Second letter → **2 pushes**
- Third letter → **3 pushes**
- ...

The keypad can be remapped in any way.

Return the **minimum number of key presses** required to type the given word.

---

## Intuition

Since the keypad can be rearranged freely, the most frequently used letters should require the fewest key presses.

Therefore:

- Letters with the highest frequency should occupy the first positions on the keys.
- Less frequent letters should occupy later positions.

There are only **8 keys**, so:

- First **8** most frequent letters cost **1 push**
- Next **8** letters cost **2 pushes**
- Next **8** letters cost **3 pushes**
- Remaining **2** letters cost **4 pushes**

---

## Approach

1. Count the frequency of every character.
2. Sort the frequencies in descending order.
3. Assign push costs greedily:
   - Index `0–7` → cost = 1
   - Index `8–15` → cost = 2
   - Index `16–23` → cost = 3
   - Index `24–25` → cost = 4
4. Multiply each frequency by its assigned cost.
5. Return the total.

---

## Dry Run

### Input

```
word = "aabbccddeeffgghhiiiiii"
```

### Frequency

```
i : 6
a : 2
b : 2
c : 2
d : 2
e : 2
f : 2
g : 2
h : 2
```

### Sorted Frequencies

```
6 2 2 2 2 2 2 2 2
```

### Assignment

| Letter Rank | Push Cost |
|-------------|-----------|
| 1st         | 1 |
| 2nd         | 1 |
| 3rd         | 1 |
| 4th         | 1 |
| 5th         | 1 |
| 6th         | 1 |
| 7th         | 1 |
| 8th         | 1 |
| 9th         | 2 |

### Total Cost

```
6×1 + 2×7×1 + 2×2 = 24
```

Answer = **24**

---

## Algorithm

```
Count frequency of each letter

Sort frequencies in descending order

index = 0
answer = 0

For each non-zero frequency:
    pushes = (index / 8) + 1
    answer += frequency × pushes
    index++

Return answer
```

---

## Correctness Proof

The objective is to minimize:

```
Σ (frequency × push_cost)
```

Since higher frequencies contribute more to the total cost, assigning them the smallest possible push cost always minimizes the sum.

This follows the **Greedy Strategy**:

- Highest frequency → Lowest cost
- Lowest frequency → Highest cost

Therefore, the algorithm always produces the minimum number of key presses.

---

## Complexity Analysis

### Time Complexity

- Count frequencies: **O(n)**
- Sort 26 frequencies: **O(26 log 26) ≈ O(1)**
- Traverse frequencies: **O(26)**

Overall:

```
O(n)
```

---

### Space Complexity

Only a frequency array of size 26 is used.

```
O(1)
```
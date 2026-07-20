# 1260. Shift 2D Grid

## Problem

Given an `m × n` matrix `grid`, shift all elements to the right `k` times.

Each shift performs:

- `grid[i][j] → grid[i][j+1]`
- Last element of a row moves to the first column of the next row.
- Last element of the grid moves to `grid[0][0]`.

Return the final grid.

---

## Idea

Instead of performing one shift at a time, treat the matrix as a single 1D array.

For any cell:

```
index = row × n + col
```

After shifting:

```
newIndex = (index + k) % (m × n)
```

Convert the new index back:

```
newRow = newIndex / n
newCol = newIndex % n
```

Place every element directly into its final position.

---

## Algorithm

1. Compute total elements = `m × n`.
2. Reduce shifts:
   ```
   k %= total
   ```
3. Traverse every cell.
4. Compute its 1D index.
5. Compute shifted index.
6. Convert back to 2D coordinates.
7. Store in the answer matrix.
8. Convert the matrix into `List<List<Integer>>`.

---

## Correctness

Each element has exactly one unique 1D index.

The formula

```
(index + k) % total
```

moves it exactly `k` positions to the right while wrapping around the grid.

Since every element maps to a unique destination, all values are placed correctly.

---

## Complexity

- **Time:** `O(m × n)`
- **Space:** `O(m × n)`

---

## Example

Input

```
grid =
1 2 3
4 5 6
7 8 9

k = 1
```

Output

```
9 1 2
3 4 5
6 7 8
```

---

## Key Learning

- Converting between **2D and 1D indexing** is a common technique.
- Circular shift problems are often solved efficiently using **modulo arithmetic** instead of simulating each shift.
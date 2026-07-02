# 3286. Find a Safe Walk Through a Grid

## Approach

This problem can be modeled as a **Shortest Path** problem.

Instead of tracking remaining health directly, we compute the minimum number of unsafe cells (`1`s) encountered along any path.

### Key Observation

- Entering a safe cell (`0`) costs **0** health.
- Entering an unsafe cell (`1`) costs **1** health.
- The starting cell also contributes to the health loss if it is unsafe.
- A path is valid only if the remaining health after reaching the destination is at least **1**.

Therefore,

```
remainingHealth = health - totalUnsafeCells
```

The destination is reachable if

```
remainingHealth >= 1
```

which is equivalent to

```
totalUnsafeCells < health
```

Hence, the objective becomes finding the minimum number of unsafe cells required to reach the destination.

---

## Algorithm

1. Create a `dist` matrix where `dist[i][j]` stores the minimum unsafe cells required to reach each cell.
2. Initialize all values to infinity.
3. Set

   ```
   dist[0][0] = grid[0][0]
   ```

4. Use Dijkstra's algorithm with a priority queue storing:

   ```
   (cost, row, column)
   ```

5. For each neighboring cell:

   ```
   newCost = currentCost + grid[newRow][newCol]
   ```

6. If a smaller cost is found, update the distance and push it into the priority queue.

7. As soon as the destination is popped from the queue:

   - Return `true` if

     ```
     cost < health
     ```

   - Otherwise return `false`.

---

## Correctness

Dijkstra's algorithm guarantees that the first time a cell is removed from the priority queue, it has the minimum possible cost (minimum unsafe cells visited).

Since the destination is processed in increasing order of unsafe-cell count, the first time it is reached gives the optimal answer.

If this minimum cost is less than the available health, a safe path exists; otherwise it does not.

---

## Complexity Analysis

### Time Complexity

```
O(m × n × log(m × n))
```

Each cell may enter the priority queue, and every queue operation costs `log(m × n)`.

### Space Complexity

```
O(m × n)
```

For the distance matrix and priority queue.

---

## Data Structures Used

- Priority Queue (Min Heap)
- 2D Distance Array

---

## Key Idea

Convert the health constraint into a shortest path problem:

```
Unsafe Cell -> Cost 1
Safe Cell   -> Cost 0
```

Find the path with the minimum total cost using Dijkstra's algorithm, then verify whether:

```
minimumCost < health
```

If true, reaching the destination while keeping health at least `1` is possible.
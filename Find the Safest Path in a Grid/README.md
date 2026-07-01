# 2812. Find the Safest Path in a Grid

## Problem Statement

Given an `n × n` grid where:

- `1` represents a thief.
- `0` represents an empty cell.

You start from the top-left corner `(0,0)` and need to reach the bottom-right corner `(n-1,n-1)` by moving in four directions (up, down, left, right).

The **safeness factor** of a path is defined as the **minimum Manhattan distance between any cell in the path and the nearest thief**.

Return the **maximum possible safeness factor** among all valid paths.

---

## Intuition

The problem can be divided into two independent parts:

1. Compute the **minimum distance of every cell from the nearest thief**.
2. Find a path that **maximizes the minimum distance** encountered along the path.

Instead of calculating the distance to the nearest thief repeatedly, we precompute it once for every cell using **Multi-Source BFS**. After that, the grid becomes a weighted graph where each cell contains its safeness value.

The task then becomes finding a path whose minimum value is as large as possible, also known as the **Maximum Bottleneck Path** problem.

---

## Approach

### Phase 1: Multi-Source BFS

All thief cells are inserted into a queue initially.

Perform BFS simultaneously from every thief.

For every cell, store its shortest distance from the nearest thief.

Example:

**Input Grid**

```text
0 0 1
0 0 0
0 0 0
```

**Distance Matrix**

```text
2 1 0
3 2 1
4 3 2
```

Now every cell represents its safeness value.

---

### Phase 2: Modified Dijkstra (Maximum Bottleneck Path)

Use a **Max Heap (Priority Queue)**.

Each heap node stores:

```
(currentSafeness, row, column)
```

Initially:

```
(dist[0][0], 0, 0)
```

Whenever we move to a neighbouring cell,

```
newSafeness = min(currentSafeness, dist[nextCell])
```

This ensures that the path's safeness is always the minimum value encountered so far.

Since the priority queue always processes the path with the highest safeness first, the first time we reach the destination, we are guaranteed to have found the optimal answer.

---

## Algorithm

1. Initialize a distance matrix.
2. Push all thief cells into a queue.
3. Run Multi-Source BFS to compute the nearest thief distance for every cell.
4. Create a Max Heap.
5. Insert the starting cell.
6. Repeatedly pop the safest path available.
7. Visit neighbouring cells and update their path safeness using:

```
min(currentSafeness, neighbourDistance)
```

8. Return the safeness when the destination is removed from the heap.

---

## Complexity Analysis

### Multi-Source BFS

- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(n²)`

### Modified Dijkstra

- **Time Complexity:** `O(n² log n)`
- **Space Complexity:** `O(n²)`

### Overall Complexity

| Complexity | Value |
|------------|-------|
| Time | **O(n² log n)** |
| Space | **O(n²)** |

---

## Data Structures Used

- Queue (Multi-Source BFS)
- Priority Queue / Max Heap
- Distance Matrix
- Visited Matrix

---

## Key Concepts

- Multi-Source BFS
- Manhattan Distance
- Graph Traversal
- Priority Queue
- Modified Dijkstra Algorithm
- Maximum Bottleneck Path

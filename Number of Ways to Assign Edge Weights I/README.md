# 3558. Number of Ways to Assign Edge Weights I

## Problem Statement

Given an undirected tree rooted at node `1`, each edge can be assigned a weight of either `1` or `2`.

Choose any node at the maximum depth and consider only the path from the root (`1`) to that node. Count the number of ways to assign weights to the edges on this path such that the total path cost is **odd**.

Return the answer modulo `10^9 + 7`.

---

## Approach

### Key Observation

Let the maximum depth of the tree be `L`.

- The root-to-deepest-node path contains exactly `L` edges.
- Each edge has 2 choices: `{1, 2}`.
- Total possible assignments = `2^L`.

Since assigning weight `1` contributes odd parity and weight `2` contributes even parity:

- Exactly half of all assignments produce an odd sum.
- Exactly half produce an even sum.

Therefore:

Answer = `2^(L-1)`.

The problem reduces to finding the maximum depth of the tree.

---

## Algorithm

1. Build an adjacency list.
2. Perform BFS from node `1`.
3. Find the maximum depth `L`.
4. Compute `2^(L-1) mod (10^9 + 7)` using fast exponentiation.

---

## Complexity Analysis

### Time Complexity
- BFS Traversal: `O(n)`
- Fast Exponentiation: `O(log n)`

Overall: `O(n)`

### Space Complexity
- Adjacency List: `O(n)`
- Queue + Visited Array: `O(n)`

Overall: `O(n)`
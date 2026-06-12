# 3559. Number of Ways to Assign Edge Weights II

## Problem Statement

Given an undirected tree rooted at node 1, each edge can be assigned a weight of either 1 or 2.

For every query `(u, v)`, consider only the edges on the path between `u` and `v`. Count the number of ways to assign weights such that the total path cost is odd.

Return the answer for each query modulo `10^9 + 7`.

---

## Key Insight

For a path containing `L` edges:

- Each edge has 2 choices: `1` or `2`
- Total possible assignments = `2^L`
- The path cost is odd when an odd number of edges are assigned weight `1`
- Exactly half of all assignments produce an odd sum

Therefore:

- If `L = 0`, answer = `0`
- Otherwise, answer = `2^(L-1)`

The problem reduces to finding the number of edges on the path between two nodes.

---

## Approach

### 1. Preprocessing
- Build the tree using an adjacency list.
- Compute depth of each node.
- Precompute Binary Lifting table for LCA (Lowest Common Ancestor).

### 2. Query Processing
For every query `(u, v)`:

- Find `lca(u, v)`
- Compute path length:

```text
L = depth[u] + depth[v] - 2 * depth[lca]
Idea

We need to maximize the minimum edge cost on a path while ensuring:

every intermediate node is online
total path cost ≤ k

This is solved using Binary Search on the answer.

Key Observation

If a minimum edge value X is achievable, then every value smaller than X is also achievable.

Therefore, the answer is monotonic and binary search can be applied.

Feasibility Check

For a guessed minimum edge value mid:

Ignore every edge with cost < mid.
Ignore any path passing through offline intermediate nodes.
Compute the minimum total path cost from node 0 to node n-1.

Since the graph is a Directed Acyclic Graph (DAG), shortest paths can be computed efficiently using Topological Order + Dynamic Programming.

If

minimum total cost ≤ k

then mid is feasible.

Algorithm
Build the graph.
Compute one topological ordering.
Binary search on the minimum edge value.
During each binary-search iteration:
Keep only edges with cost ≥ mid.
Run DP over the topological order to compute the minimum total cost.
Check whether the destination can be reached within budget k.
Return the largest feasible value.
Complexity
Topological Sort: O(V + E)
Each feasibility check: O(V + E)
Binary Search: O(log(MaxEdge)) ≈ 31

Overall:

O((V + E) × log(MaxEdge))

Space Complexity:

O(V + E)
Concepts Used
Binary Search on Answer
Directed Acyclic Graph (DAG)
Topological Sorting (Kahn's Algorithm)
Dynamic Programming on DAG
Shortest Path in DAG
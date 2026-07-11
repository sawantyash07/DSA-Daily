Idea

A connected component is complete when every vertex is connected to every other vertex.

Instead of checking every pair of vertices, use the mathematical property of a complete graph.

If a component has k vertices, then it must contain exactly

k * (k - 1) / 2

edges.

Algorithm
Build an adjacency list.
Perform DFS/BFS to find each connected component.
For every component:
Count the number of vertices.
Sum the degrees of all vertices.
Compute the number of edges as degreeSum / 2.
If
edges == vertices * (vertices - 1) / 2

then the component is complete.
5. Count all such components.

Why Degree Sum?

Every undirected edge contributes to the degree of both its endpoints.

So,

Sum of degrees = 2 × Number of edges

Therefore,

edges = degreeSum / 2
Correctness
DFS visits exactly one connected component.
nodes stores the number of vertices in that component.
degreeSum / 2 gives the exact number of edges.
A component is complete iff it contains exactly k(k−1)/2 edges.
Hence every complete component is counted exactly once.
Complexity
Time: O(V + E)
Space: O(V + E)
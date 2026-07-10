Key Idea
Sort nodes by their values.
The graph becomes an interval graph.
Nodes separated by a gap larger than maxDiff belong to different connected components.
For every node, compute the farthest node reachable in one step using a sliding window.
The shortest path is obtained by repeatedly taking the farthest possible jump (greedy).
Use Binary Lifting to perform multiple greedy jumps in O(log n) per query.
Algorithms Used
Sorting
Two Pointers / Sliding Window
Connected Components
Binary Lifting
Time Complexity
Preprocessing: O(n log n)
Each Query: O(log n)
Total: O((n + q) log n)
Space Complexity
Binary Lifting Table: O(n log n)
Other Arrays: O(n)
Overall: O(n log n)
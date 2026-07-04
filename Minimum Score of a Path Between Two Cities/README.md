Idea
The score of a path is the minimum edge weight on that path, not the total distance.
Since revisiting cities and roads is allowed, we can traverse any road inside the connected component containing city 1 before reaching city n.
Therefore, the minimum possible score is simply the smallest edge weight in the connected component containing city 1.
Approach
Build an adjacency list.
Perform DFS/BFS starting from city 1.
While traversing, keep updating the minimum edge weight encountered.
Return that minimum value.
Correctness

Every path from city 1 to city n must stay within the connected component containing city 1. Because revisiting nodes and edges is allowed, any edge in this component can be included in a valid path from 1 to n. Hence, the smallest edge in this component is the minimum achievable path score.

Complexity
Time: O(V + E)
Space: O(V + E)
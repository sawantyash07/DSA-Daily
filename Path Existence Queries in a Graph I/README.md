Intuition

Since nums is sorted, the graph connectivity depends only on the gaps between consecutive elements. If the difference between two adjacent numbers is greater than maxDiff, no path can cross that gap because every later number is even larger. Thus, such a gap splits the graph into different connected components.

Approach
Traverse the sorted array once.
Assign a component ID to every index.
Whenever nums[i] - nums[i-1] > maxDiff, start a new component.
For each query [u, v], return true if both indices belong to the same component; otherwise return false.
Why It Works
Adjacent elements with difference <= maxDiff are directly connected.
A chain of such adjacent connections forms a path between any two nodes in the same segment.
A gap larger than maxDiff cannot be bypassed because all subsequent values are even larger, making every cross-gap edge invalid.
Therefore, connected components are exactly the contiguous segments separated by large adjacent gaps.
Complexity
Building components: O(n)
Processing queries: O(q)
Total: O(n + q)
Extra Space: O(n)
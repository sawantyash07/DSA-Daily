2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
Problem

Given a singly linked list, a critical point is a node that is either:

A local maximum: its value is strictly greater than both its previous and next nodes.
A local minimum: its value is strictly smaller than both its previous and next nodes.

The first and last nodes cannot be critical points because they do not have both a previous and next node.

Return an array:

[minDistance, maxDistance]

where:

minDistance is the minimum distance between any two critical points.
maxDistance is the maximum distance between any two critical points.
If there are fewer than two critical points, return [-1, -1].
Example
Input
head = [5,3,1,2,5,1,2]

Critical points are at positions:

3, 5, 6

Distances:

3 → 5 = 2
5 → 6 = 1

Therefore:

Output: [1,3]
Approach

Traverse the linked list while keeping track of the current node, previous node, and next node.

For every node:

Check whether it is a local maximum or local minimum.
If it is the first critical point, store its position in first.
For every subsequent critical point:
Calculate the distance from the previous critical point.
Update minDistance.
Store the current critical point as prevCritical.
Update last to the current critical point.

After traversal:

maxDistance = last - first

If there are fewer than two critical points, return:

[-1, -1]
Algorithm
Initialize:
first = -1
prevCritical = -1
last = -1
minDistance = Integer.MAX_VALUE
Start traversing from the second node.

For every node, check:

(curr > prev && curr > next)
OR
(curr < prev && curr < next)
If the node is critical:
Set first if it is the first critical point.
Otherwise calculate the distance from prevCritical.
Update prevCritical and last.
If fewer than two critical points exist, return [-1, -1].

Calculate:

maxDistance = last - first
Return [minDistance, maxDistance].
Complexity
Time Complexity: O(n)
Space Complexity: O(1)

Only a single traversal of the linked list is required, and no extra data structure is used.
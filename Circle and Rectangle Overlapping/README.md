Problem

You are given a circle represented by its radius, xCenter, and yCenter, and an axis-aligned rectangle represented by (x1, y1) and (x2, y2).

Return true if the circle and rectangle have at least one point in common. Otherwise, return false.

Approach

The easiest way to solve this problem is to find the closest point inside the rectangle to the center of the circle.

Steps
Find the closest x coordinate in the rectangle to xCenter.
Find the closest y coordinate in the rectangle to yCenter.
This gives the point in the rectangle closest to the circle's center.
Calculate the squared distance between the circle's center and this point.
If the squared distance is less than or equal to radius², the circle and rectangle overlap.
Finding the Closest Point

For the x-coordinate:

closestX = max(x1, min(xCenter, x2))

For the y-coordinate:

closestY = max(y1, min(yCenter, y2))

This works because:

If the center is inside the rectangle's range, the center itself is selected.
If the center is outside the range, the nearest boundary is selected.
Example
radius = 1
xCenter = 0
yCenter = 0

Rectangle:
(x1, y1) = (1, -1)
(x2, y2) = (3, 1)

The closest point in the rectangle to (0, 0) is (1, 0).

distance² = (0 - 1)² + (0 - 0)²
          = 1

radius² = 1

Since:

distance² <= radius²
1 <= 1

The circle and rectangle overlap.

Complexity
Time Complexity: O(1)
Space Complexity: O(1)
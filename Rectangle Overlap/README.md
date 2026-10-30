Problem

An axis-aligned rectangle is represented as:

[x1, y1, x2, y2]

where:

(x1, y1) is the bottom-left corner.
(x2, y2) is the top-right corner.

Given two rectangles rec1 and rec2, determine whether they overlap with a positive area.

Rectangles that only touch at an edge or corner are not considered overlapping.

Approach

Two rectangles overlap if their projections on both the X-axis and Y-axis overlap with positive length.

For two rectangles:

rec1 = [x1, y1, x2, y2]
rec2 = [a1, b1, a2, b2]

The rectangles overlap when:

x1 < a2
a1 < x2
y1 < b2
b1 < y2

All four conditions must be true.

If any condition is false, the rectangles either:

Do not overlap, or
Only touch at an edge/corner.
Java Solution
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] &&
               rec2[0] < rec1[2] &&
               rec1[1] < rec2[3] &&
               rec2[1] < rec1[3];
    }
}
Example
Input
rec1 = [0,0,2,2]
rec2 = [1,1,3,3]
Output
true

The rectangles overlap in the region from (1,1) to (2,2), which has a positive area.

Example 2
rec1 = [0,0,1,1]
rec2 = [1,0,2,1]

Output:

false

The rectangles only touch at the edge x = 1, so their intersection has zero area.

Complexity
Time Complexity: O(1)
Space Complexity: O(1)
Key Takeaway

For axis-aligned rectangles, simply check whether their intervals overlap on both X and Y axes. Strict < comparisons ensure that rectangles touching only at edges or corners return false.
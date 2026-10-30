Problem

You are given two binary square matrices img1 and img2 of size n x n.

You can translate one image by moving all its 1s:

Left
Right
Up
Down
Or any combination of these directions

Rotation is not allowed.

After translating, calculate the number of positions where both images contain 1.

Return the maximum possible overlap.

Example
Input
img1 = [
    [1,1,0],
    [0,1,0],
    [0,1,0]
]

img2 = [
    [0,0,0],
    [0,1,1],
    [0,0,1]
]
Output
3
Explanation

By translating img1 one position to the right and one position downward, three 1s overlap.

Approach

Instead of trying every translation and checking every cell, we use the coordinates of the 1s.

For every 1 in img1 and every 1 in img2, calculate the translation required to make them overlap.

For two coordinates:

img1 = (x1, y1)
img2 = (x2, y2)

The required translation is:

dx = x1 - x2
dy = y1 - y2

If the same translation occurs multiple times, it means multiple 1s can overlap using that translation.

Therefore, we store the frequency of every (dx, dy) pair.

The highest frequency is the maximum possible overlap.

Algorithm
Store the coordinates of all 1s in img1.
Store the coordinates of all 1s in img2.
For every pair of coordinates:
Calculate dx.
Calculate dy.
Store the frequency of this translation.
Keep track of the maximum frequency.
Return the maximum frequency.
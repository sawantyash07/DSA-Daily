Problem Statement

Given three integers n, l, and r, count the number of ZigZag arrays of length n such that:

Every element belongs to the range [l, r].
No two adjacent elements are equal.
No three consecutive elements are strictly increasing.
No three consecutive elements are strictly decreasing.

Return the answer modulo 10⁹ + 7.

Approach
Key Observation

Since adjacent elements cannot be equal, for every consecutive pair we only have two possible relations:

UP → a[i] > a[i-1]
DOWN → a[i] < a[i-1]

The conditions:

No three consecutive elements are strictly increasing.
No three consecutive elements are strictly decreasing.

imply that we cannot have:

UP → UP
DOWN → DOWN

Therefore, the direction must alternate:

UP, DOWN, UP, DOWN, ...
or
DOWN, UP, DOWN, UP, ...

Thus, a valid ZigZag array is an array whose comparison signs alternate.

Dynamic Programming

Let:

m = r - l + 1

Since only relative ordering matters, values can be compressed to:

1 ... m
DP States
up[x] = number of valid arrays ending at value x
where the last comparison is UP.
down[x] = number of valid arrays ending at value x
where the last comparison is DOWN.
Initialization (Length = 2)

For a fixed ending value x:

up[x] = number of smaller values before x
      = x - 1

down[x] = number of larger values before x
        = m - x
Transitions

To end with an UP move:

previous direction must be DOWN
previous value must be smaller than x

Formula:

newUp[x] = Σ down[y] where y < x

To end with a DOWN move:

previous direction must be UP
previous value must be greater than x

Formula:

newDown[x] = Σ up[y] where y > x
Prefix Sum Optimization

Direct computation requires O(m²) per layer.

Using prefix sums:

newUp[x] = prefixDown[x - 1]

newDown[x] = totalUp - prefixUp[x]

This reduces each layer to O(m).

Algorithm
Compute m = r - l + 1.
Initialize up and down for arrays of length 2.
For lengths 3 to n:
Build prefix sums.
Compute new DP arrays.
Sum all values in up and down.
Return answer modulo 10⁹ + 7.
Complexity Analysis
Time Complexity
O(n × m)

where:

m = r - l + 1

Maximum:

2000 × 2000 = 4 × 10⁶
Space Complexity
O(m)

Only two DP arrays and prefix sums are maintained.
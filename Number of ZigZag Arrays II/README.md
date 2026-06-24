3700. Number of ZigZag Arrays II
Problem Statement

You are given three integers:

n → length of the array
l → minimum value allowed
r → maximum value allowed

A ZigZag array must satisfy:

Every element lies in the range [l, r].
No two adjacent elements are equal.
No three consecutive elements form a strictly increasing sequence.
No three consecutive elements form a strictly decreasing sequence.

Return the total number of valid ZigZag arrays modulo 10⁹ + 7.

Key Observation

For any adjacent pair:

a[i] < a[i+1] → UP
a[i] > a[i+1] → DOWN

Since adjacent elements cannot be equal, every adjacent pair has either an UP or DOWN relation.

The condition:

No three consecutive elements are strictly increasing
No three consecutive elements are strictly decreasing

means:

UP → UP is forbidden
DOWN → DOWN is forbidden

Therefore, the comparison signs must alternate:

UP DOWN UP DOWN ...
or
DOWN UP DOWN UP ...

So every valid array is determined by alternating directions.

Dynamic Programming State

Let:

m = r - l + 1

Define:

up[x] = number of valid sequences ending at value x whose last move was UP.
down[x] = number of valid sequences ending at value x whose last move was DOWN.

Transitions:

up'[x]   = Σ down[y]   where y < x
down'[x] = Σ up[y]     where y > x

These transitions are linear and can be represented using matrix multiplication.

Matrix Exponentiation

Since:

3 ≤ n ≤ 10^9

a normal DP is impossible.

The transition matrix size is:

2m × 2m

where:

m ≤ 75

We use binary exponentiation on the transition matrix to compute:

T^(n-2)

efficiently.

Algorithm
Compute m = r - l + 1.
Build the initial state for arrays of length 2.
Construct the transition matrix.
Apply matrix exponentiation to raise the matrix to (n - 2).
Multiply the resulting matrix with the initial state.
Sum all states modulo 10^9 + 7.
Correctness
Lemma 1

Every valid ZigZag array must have alternating comparison signs.

Proof

If two consecutive signs are both UP:

a[i] < a[i+1] < a[i+2]

which forms a strictly increasing triplet.

Similarly, two consecutive DOWN signs form a strictly decreasing triplet.

Therefore signs must alternate.

Lemma 2

The DP transitions generate exactly all valid ZigZag arrays.

Proof

An UP transition can only follow a DOWN transition.
A DOWN transition can only follow an UP transition.
The value constraints (< and >) ensure correctness.

Thus every generated sequence is valid and every valid sequence is counted.

Lemma 3

Matrix exponentiation correctly applies the transition for n-2 additional positions.

Proof

The transition is linear.

Repeated DP transitions correspond to repeated multiplication by the transition matrix.

Therefore:

State(n) = T^(n-2) × State(2)

which counts all valid arrays of length n.

Complexity Analysis

Let:

m = r - l + 1

Maximum:

m ≤ 75
states = 2m ≤ 150
Time Complexity
O((2m)^3 log n)
Space Complexity
O((2m)^2)
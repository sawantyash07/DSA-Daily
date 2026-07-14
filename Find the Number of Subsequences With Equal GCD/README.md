Approach: Dynamic Programming on GCD States
Idea

Each element has exactly three choices:

Skip it.
Add it to the first subsequence.
Add it to the second subsequence.

Since every element is processed once, the two subsequences are always disjoint.

Instead of storing the entire subsequences, only their current GCDs are needed because

newGCD = gcd(currentGCD, newValue)

This significantly reduces the state space.

DP State
dp[g1][g2]
g1 = current GCD of the first subsequence.
g2 = current GCD of the second subsequence.

0 denotes an empty subsequence.

Initialization:

dp[0][0] = 1
Transitions

For each number x:

Ignore it
(g1,g2) → (g1,g2)
Add to first subsequence
(g1,g2) → (gcd(g1,x), g2)

If g1 == 0, the new GCD becomes x.

Add to second subsequence
(g1,g2) → (g1, gcd(g2,x))

If g2 == 0, the new GCD becomes x.

Final Answer

Sum all states where both subsequences are non-empty and have equal GCD.

Σ dp[g][g]  for g ≥ 1
Complexity
Time: O(n × M²)
Space: O(M²)

where M is the maximum element in nums (at most 200). This is efficient enough for the problem constraints.
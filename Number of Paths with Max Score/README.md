Intuition

The allowed moves are from S → E (up, left, diagonal), which makes dependencies awkward for DP. Instead, reverse the direction and compute DP from E → S using down, right, and down-right.

For each cell, store:

the maximum score achievable to reach that cell,
the number of ways to achieve that maximum score.

Whenever multiple previous cells provide the same maximum score, add their path counts.

Algorithm
Create two DP tables:
score[i][j] → maximum score to reach (i,j)
ways[i][j] → number of maximum-score paths.
Initialize:
score[0][0] = 0
ways[0][0] = 1
Traverse the board from top-left to bottom-right.
Ignore obstacle cells.
For each cell, examine:
top
left
top-left diagonal
Choose the largest parent score.
Add the current cell's digit (0 for E and S).
Sum path counts of all parents having the best score.
If the destination is unreachable, return [0,0].
Correctness
Every path reaching a cell must come from one of its three predecessor cells.
score[i][j] always stores the maximum score among all valid paths.
ways[i][j] counts exactly those paths whose score equals the maximum.
Therefore, the destination stores both the optimal score and the number of optimal paths.
Complexity Analysis
Time: O(n²)
Space: O(n²)
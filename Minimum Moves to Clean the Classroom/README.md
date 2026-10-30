3568. Minimum Moves to Clean the Classroom
Problem

You are given an m x n classroom grid containing:

S → Starting position of the student
L → Litter that must be collected
R → Reset area that restores energy to maximum
X → Obstacle that cannot be crossed
. → Empty cell

The student starts with a given amount of energy.

Moving to an adjacent cell costs 1 energy.

If the student reaches an R cell, their energy is restored to the maximum value.

The goal is to find the minimum number of moves required to collect all litter.

If it is impossible, return -1.

Approach

We use Breadth-First Search (BFS) because every movement costs exactly 1, so BFS finds the minimum number of moves.

A state is represented as:

(row, column, remainingEnergy, litterMask)
1. Bitmask for Litter

There can be at most 10 litter cells.

We assign every litter cell an ID:

L1 → 0
L2 → 1
L3 → 2
...

We use an integer bitmask to remember which litter has been collected.

For example:

00000 → no litter collected
00101 → litter 0 and litter 2 collected
11111 → all litter collected

The target mask is:

int fullMask = (1 << litterCount) - 1;
2. BFS

From every state, we try moving in four directions:

Up
Down
Left
Right

For every valid move:

Decrease energy by 1.
If the new cell is L, mark that litter as collected.
If the new cell is R, restore energy to maximum.
Ignore cells containing X.

If all litter is collected, return the current number of moves.

Optimization

A simple BFS storing every state in a HashSet can use a large amount of memory and may cause TLE.

Instead, we maintain:

bestEnergy[row][column][mask]

This stores the maximum energy with which we have reached a particular:

position + collected litter set

If we reach the same position with the same litter mask but with less or equal energy, we do not need to process that state again.

if (newEnergy > bestEnergy[nr][nc][newMask])

This significantly reduces the number of states explored.

Algorithm
Find the starting position S.
Assign IDs to all L cells.
Create the target bitmask containing all litter.
Initialize BFS with:
Starting position
Maximum energy
Litter mask 0
For every BFS state:
Try all four directions.
Skip invalid cells and obstacles.
Decrease energy by 1.
Collect litter using the bitmask.
Reset energy when entering R.
Store the state only if it reaches the position with more energy than before.
Return the number of moves when all litter is collected.
If BFS finishes without collecting all litter, return -1.
Complexity

Let:

m = number of rows
n = number of columns
E = maximum energy
L = number of litter cells, where L <= 10

There are at most:

m × n × 2^L

important position/mask states.

Time Complexity
O(m × n × 2^L × 4)

Since each state has at most 4 possible moves:

O(m × n × 2^L)
Space Complexity
O(m × n × 2^L)

The bestEnergy array stores the maximum energy for every position and litter mask.

Example
Input
classroom = ["S.", "XL"]
energy = 2
Movement
S .
X L

The student moves:

S → .
    ↓
    L

Total moves:

2
Output
2
Key Concepts
Breadth-First Search (BFS)
Bitmask
State-space search
Dynamic state pruning
Energy management
Shortest path
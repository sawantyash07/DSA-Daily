# 3161. Block Placement Queries

## Problem
There exists an infinite number line, with its origin at 0 and extending towards the positive x-axis.

Two types of queries are given:

1. `[1, x]` → Place an obstacle at position `x`.
2. `[2, x, sz]` → Determine whether a block of length `sz` can be placed completely inside `[0, x]` without intersecting any obstacle.

Return a boolean array containing answers for all type-2 queries.

## Approach

### Offline Processing
Instead of handling insertions directly, process queries in reverse.

- First insert all obstacles.
- Reverse type-1 queries become obstacle removals.
- Maintain obstacle positions using a TreeSet.

### Segment Tree
Store for every obstacle:
- Distance from its previous obstacle.

The segment tree maintains:
- Maximum gap among obstacles.

For a query `[2, x, sz]`:
- Find the largest complete obstacle gap before `x`.
- Find the free tail segment from the last obstacle before `x` to `x`.
- If the maximum available segment length is at least `sz`, return `true`.

## Complexity

- Time: `O(Q log M)`
- Space: `O(M)`

where:
- `Q` = number of queries
- `M` = maximum coordinate (`50000`)

## Tags

Segment Tree, TreeSet, Offline Queries, Ordered Set, Hard
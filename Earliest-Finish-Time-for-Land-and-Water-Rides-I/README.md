# 3633. Earliest Finish Time for Land and Water Rides I

## Problem
A tourist must take exactly one land ride and one water ride in any order.

- `landStartTime[i]` = earliest start time of the ith land ride
- `landDuration[i]` = duration of the ith land ride
- `waterStartTime[j]` = earliest start time of the jth water ride
- `waterDuration[j]` = duration of the jth water ride

A ride can start at its opening time or later. After finishing one ride, the tourist can immediately take the other ride if it is open, otherwise they must wait.

Return the earliest possible time to finish both rides.

## Approach

For every pair of land and water rides:

1. Try **Land → Water**
   - Finish land ride.
   - Start water ride at `max(finishLand, waterStartTime[j])`.
   - Compute total finish time.

2. Try **Water → Land**
   - Finish water ride.
   - Start land ride at `max(finishWater, landStartTime[i])`.
   - Compute total finish time.

Keep the minimum finish time among all possibilities.

## Complexity Analysis

- Time Complexity: **O(n × m)**
- Space Complexity: **O(1)**
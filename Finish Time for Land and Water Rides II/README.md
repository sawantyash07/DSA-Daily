# LeetCode 3635 - Earliest Finish Time for Land and Water Rides II

## Problem Statement
A tourist must take exactly one land ride and one water ride in any order.

Each ride has:
- Opening time (`startTime`)
- Duration (`duration`)

A ride can start at its opening time or later. After finishing the first ride, the tourist can immediately take the second ride if it is open, otherwise wait until it opens.

Find the earliest possible time to finish both rides.

## Approach

For a ride that finishes at time `t`, the finish time of the second ride is:

max(t, startTime) + duration

To efficiently find the minimum value across all rides:

1. Sort rides by opening time.
2. Build:
   - Prefix minimum of durations.
   - Suffix minimum of `(startTime + duration)`.
3. For each finish time `t`:
   - If `startTime <= t`, answer is `t + duration`.
   - Otherwise answer is `startTime + duration`.
4. Use binary search to split rides into these two groups.

We evaluate:
- Land → Water
- Water → Land

and return the minimum result.

## Complexity

- Time: **O(n log n + m log m)**
- Space: **O(n + m)**

## Topics

- Binary Search
- Sorting
- Prefix Minimum
- Suffix Minimum
- Arrays

## LeetCode

Problem: 3635. Earliest Finish Time for Land and Water Rides II
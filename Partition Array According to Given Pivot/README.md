# 2161. Partition Array According to Given Pivot

## Problem Statement
Given an integer array `nums` and an integer `pivot`, rearrange the array such that:

- All elements smaller than `pivot` appear before elements greater than `pivot`.
- All elements equal to `pivot` appear between them.
- The relative order of elements smaller than `pivot` and greater than `pivot` is preserved.

## Approach
Use a stable partitioning technique:

1. Traverse the array and store all elements less than `pivot`.
2. Traverse again and store all elements equal to `pivot`.
3. Traverse once more and store all elements greater than `pivot`.
4. Return the resulting array.

This preserves the relative order of elements in each group.

## Algorithm
```text
Create result array

Add all elements < pivot
Add all elements == pivot
Add all elements > pivot

Return result array
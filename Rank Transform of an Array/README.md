Problem Statement

Given an integer array arr, replace each element with its rank.

The rank represents the position of the element in the sorted list of unique values.

Rules
Rank starts from 1.
Larger values have larger ranks.
Equal values receive the same rank.
Ranks should be as small as possible.
Example
Input
arr = [40, 10, 20, 30]
Output
[4, 1, 2, 3]
Explanation

Sorted unique elements:

[10, 20, 30, 40]

Ranks:

10 → 1
20 → 2
30 → 3
40 → 4

Result:

[4, 1, 2, 3]
Approach
Create a copy of the original array.
Sort the copied array.
Store only the unique elements in another array.
For every element in the original array:
Find its position in the unique sorted array.
Assign the rank as (position + 1).
Return the transformed array.
Algorithm
Copy the input array.
Sort the copied array.
Traverse the sorted array and store unique values.
Traverse the original array.
For each element, search its index in the unique array.
Store (index + 1) as its rank.
Return the answer array.
Complexity Analysis
Time Complexity
Sorting: O(n log n)
Creating unique array: O(n)
Searching rank for each element: O(n²) (using linear search)

Overall: O(n²)

Space Complexity
Copy array: O(n)
Unique array: O(n)
Result array: O(n)

Overall: O(n)
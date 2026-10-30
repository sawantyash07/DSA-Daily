2091. Removing Minimum and Maximum From Array
Problem

You are given a 0-indexed array of distinct integers nums.

The array contains:

One element with the minimum value
One element with the maximum value

In one deletion, you can remove an element from either:

The front of the array, or
The back of the array

The goal is to remove both the minimum and maximum elements using the minimum possible number of deletions.

Example
Example 1

Input:

nums = [2,10,7,5,4,1,8,6]

The minimum element is 1 at index 5.

The maximum element is 10 at index 1.

Possible strategies:

Remove both from front:
6 deletions

Remove both from back:
7 deletions

Remove minimum from front and maximum from back:
2 + 3 = 5 deletions

Output:

5
Example 2

Input:

nums = [0,-4,19,1,8,-2,-3,5]

Minimum = -4 at index 1
Maximum = 19 at index 2

Removing the first 3 elements removes both.

Output:

3
Example 3

Input:

nums = [101]

The only element is both the minimum and maximum.

Output:

1
Approach

First, find the indices of the minimum and maximum elements.

Let:

left  = min(minIndex, maxIndex)
right = max(minIndex, maxIndex)

There are three possible ways to remove both elements.

1. Remove both from the front

We need to remove elements up to the right index.

deletions = right + 1
2. Remove both from the back

We need to remove all elements from right to the end.

deletions = n - right
3. Remove one from the front and one from the back

Remove elements up to left from the front and elements from right to the end from the back.

deletions = (left + 1) + (n - right)

Finally, return the minimum of these three possibilities.

Algorithm
Initialize minIndex and maxIndex to 0.
Traverse the array and find the indices of the minimum and maximum values.

Calculate:

left = min(minIndex, maxIndex)
right = max(minIndex, maxIndex)
Calculate the three possible deletion counts:
right + 1
n - right
(left + 1) + (n - right)
Return the minimum value.
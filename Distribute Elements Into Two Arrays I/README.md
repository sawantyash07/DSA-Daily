Problem

Given an array nums of distinct integers, we need to distribute its elements into two arrays, arr1 and arr2.

The rules are:

Put the first element nums[0] into arr1.
Put the second element nums[1] into arr2.
For every remaining element:
If the last element of arr1 is greater than the last element of arr2, add the current element to arr1.
Otherwise, add it to arr2.
Return the concatenation of arr1 followed by arr2.
Example
Input
nums = [5, 4, 3, 8]
Process
arr1 = [5]
arr2 = [4]


3:
5 > 4 → add 3 to arr1
arr1 = [5, 3]


8:
3 > 4 → false → add 8 to arr2
arr2 = [4, 8]
Output
[5, 3, 4, 8]
Approach

Use two ArrayList<Integer> objects.

Initialize arr1 with nums[0].
Initialize arr2 with nums[1].
Iterate from index 2 to the end.
Compare the last elements using:
arr1.get(arr1.size() - 1)
arr2.get(arr2.size() - 1)
Finally, copy both arrays into the result array.
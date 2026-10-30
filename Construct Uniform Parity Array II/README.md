3876. Construct Uniform Parity Array II
Problem Description

You are given an array nums1 containing n distinct integers.

You need to construct another array nums2 of the same length such that all elements of nums2 have the same parity — either all are odd or all are even.

For each element nums1[i], you can either:

Keep the element unchanged:
nums2[i] = nums1[i]

Subtract another element:
nums2[i] = nums1[i] - nums1[j]

where j != i and nums1[i] - nums1[j] >= 1.

Return true if it is possible to construct such an array; otherwise, return false.

Approach

The key observation is that only the minimum element matters.

Let the minimum value of the array be minVal.

Case 1: Minimum element is odd

If the minimum element is odd, we can make the entire array odd.

For any even number x, subtract the minimum odd value:

x - minVal

Even - Odd = Odd.

Odd elements can simply remain unchanged.

Therefore, if the minimum value is odd, the answer is true.

Case 2: All elements are even

If there are no odd elements, we can keep every element unchanged.

All elements are already even, so the answer is true.

Case 3: Minimum element is even and there is an odd element

The minimum even element cannot subtract a smaller positive odd number because no smaller element exists.

Therefore, it cannot be changed from even to odd.

At the same time, an odd element cannot simply become even using a smaller element in a way that solves the entire array.

Hence, the answer is false.

Algorithm
Find the minimum value minVal.
Check whether the array contains at least one odd number.
Return:
true if minVal is odd.
true if there are no odd numbers.
Otherwise, return false.
Formula
answer = (minimum value is odd) OR (there are no odd elements)
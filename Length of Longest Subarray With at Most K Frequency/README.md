Longest Subarray With At Most K Frequency

Problem Statement

Given an integer array nums and an integer k, find the length of the longest subarray in which every element appears at most k times.

Example

Input:

nums = [1, 2, 2, 3, 1, 2]
k = 2

Output:

5

Explanation:

The longest valid subarray is:

[1, 2, 2, 3, 1]

The frequencies are:

1 → 2 times
2 → 2 times
3 → 1 time

No element appears more than k = 2 times.

Approach

Use the Sliding Window technique with a HashMap.

Maintain two pointers: left and right.

Move right through the array and increase the frequency of nums[right].

If the frequency becomes greater than k, move left forward until the window becomes valid.

Calculate the current window length using right - left + 1.

Keep track of the maximum length.

Algorithm

Initialize an empty frequency map
left = 0
maxLength = 0

For right from 0 to n - 1:
    Increase frequency of nums[right]

    While frequency of nums[right] > k:
        Decrease frequency of nums[left]
        Move left forward

    maxLength = max(maxLength, right - left + 1)

Return maxLength

Java 21 Solution

import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

Dry Run

For:

nums = [1, 2, 2, 3, 1, 2]
k = 2

The window expands to:

[1]
[1, 2]
[1, 2, 2]
[1, 2, 2, 3]
[1, 2, 2, 3, 1]

The frequencies are:

1 → 2
2 → 2
3 → 1

The window is valid, so the maximum length is 5.

When another 2 is added, its frequency becomes 3, which violates the condition. The left side of the window is then moved forward until the frequency constraint is satisfied again.

Complexity Analysis

Time Complexity

O(n)

Each element enters and leaves the sliding window at most once.

Space Complexity

O(n)

The HashMap may contain up to n distinct elements.

Key Concepts

Sliding Window

Two Pointers

HashMap

Frequency Counting

Array Traversal

Pattern to Remember

Expand window
      ↓
Check frequency constraint
      ↓
If invalid → Shrink from left
      ↓
Update maximum length

This is a common Sliding Window + Frequency Map pattern for longest/shortest subarray problems.
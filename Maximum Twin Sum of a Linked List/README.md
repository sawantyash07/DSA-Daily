# 2130. Maximum Twin Sum of a Linked List

## Problem Statement
Given the head of a linked list with even length, return the maximum twin sum of the linked list.

A node's twin is the node at position `(n - 1 - i)` where `i` is the current node's index.

## Approach
1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the linked list.
3. Traverse both halves simultaneously.
4. Compute twin sums and keep track of the maximum.

## Algorithm
- Use slow and fast pointers to locate the middle.
- Reverse the second half in-place.
- Compare corresponding nodes from the first half and reversed second half.
- Return the maximum twin sum found.

## Complexity Analysis
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)
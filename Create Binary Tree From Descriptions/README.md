# 2196. Create Binary Tree From Descriptions

## Problem Statement
You are given a 2D integer array `descriptions` where:

- `descriptions[i] = [parenti, childi, isLefti]`
- `parenti` is the parent of `childi`
- `isLefti = 1` → child is the left child
- `isLefti = 0` → child is the right child

Construct the binary tree and return its root.

LeetCode Link: https://leetcode.com/problems/create-binary-tree-from-descriptions/

---

## Approach

### Key Observations
1. Each value in the tree is unique.
2. A child node can never be the root.
3. The root is the only node that never appears as a child.

### Algorithm
1. Use a HashMap to store and create TreeNode objects.
2. Use a HashSet to track all child nodes.
3. Build parent-child relationships.
4. Find the node that is not present in the child set.
5. Return that node as the root.

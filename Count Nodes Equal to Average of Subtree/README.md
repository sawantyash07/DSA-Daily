2265. Count Nodes Equal to Average of Subtree
Problem

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

The average is calculated as:

average = sum of values / number of nodes

The result is rounded down to the nearest integer.

Approach

Use Postorder Traversal.

For every node:

Recursively calculate the sum and number of nodes in the left subtree.
Recursively calculate the sum and number of nodes in the right subtree.
Calculate the sum and number of nodes for the current subtree.
Check whether:
node.val == sum / count
If true, increment the answer.
Return the sum and node count to the parent.

Postorder traversal is useful because we need information from both children before processing the current node.

Example

Input:

root = [4,8,5,0,1,null,6]

For node 5:

Subtree values = [5, 6]
Sum = 11
Number of nodes = 2

Average = 11 / 2 = 5

Since the node value is 5, it satisfies the condition.

Output:

5
Complexity
Time Complexity: O(n)
Space Complexity: O(h)

Where:

n = number of nodes in the tree
h = height of the tree
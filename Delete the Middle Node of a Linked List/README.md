# 2095. Delete the Middle Node of a Linked List

## Problem Statement
Given the head of a singly linked list, delete the middle node and return the modified linked list.

The middle node is defined as the ⌊n / 2⌋th node using 0-based indexing.

## Example

Input:
[1,3,4,7,1,2,6]

Output:
[1,3,4,1,2,6]

Explanation:
The middle node (7) is removed from the linked list.

---

## Approach

### Fast and Slow Pointer

- Use two pointers:
  - `slow` moves one step at a time.
  - `fast` moves two steps at a time.
- Keep a `prev` pointer to track the node before `slow`.
- When `fast` reaches the end:
  - `slow` points to the middle node.
  - `prev` points to the node before the middle.
- Remove the middle node by updating:
  ```java
  prev.next = slow.next;
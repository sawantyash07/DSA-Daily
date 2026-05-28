# Longest Common Suffix Queries

## Problem
Find the index of the string in `wordsContainer` that shares the longest common suffix with each query string.

If multiple strings qualify:
- Choose the shortest string.
- If still tied, choose the earliest index.

---

## Approach
- Use Trie data structure.
- Insert reversed strings into Trie.
- Suffix matching becomes prefix matching after reversing.
- Store best index at every Trie node.

---

## Time Complexity
O(total characters)

## Space Complexity
O(total characters in Trie)

---

## Language
Java
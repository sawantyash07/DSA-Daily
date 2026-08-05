Problem Statement

You are given n methods numbered from 0 to n - 1 and a list of method invocations.

A known bug exists in method k. Every method that is reachable from k (directly or indirectly) is considered suspicious.

The suspicious methods can only be removed if no non-suspicious method invokes any suspicious method. Otherwise, none of the methods can be removed.

Return the list of remaining methods after applying the above rule.

Approach

The solution is implemented in two phases:

Identify Suspicious Methods
Build a directed graph using the invocation list.
Perform a DFS (using a stack) starting from method k.
Mark every reachable method as suspicious.
Validate Removal
Traverse every invocation.
If there exists an edge from a non-suspicious method to a suspicious method, removal is not allowed.
In this case, return all methods.
Return Remaining Methods
If removal is valid, return only the methods that are not suspicious.
Algorithm
Create an adjacency list from the invocation pairs.
Perform DFS from method k.
Mark all reachable methods as suspicious.
Check every invocation:
If source is not suspicious and destination is suspicious, return all methods.
Otherwise, return only the non-suspicious methods.
Complexity Analysis
Time Complexity: O(n + m)
n = Number of methods
m = Number of invocations
Space Complexity: O(n + m)
Adjacency list
Visited (suspicious) array
DFS stack
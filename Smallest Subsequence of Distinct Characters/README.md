Intuition
We want every distinct character exactly once.
If a smaller character appears, we should remove larger characters before it only if those larger characters can be picked again later.
Key Insight
Keep the answer in a monotonic increasing stack.
Use the last occurrence array to know whether it's safe to remove a character.
Use a visited array to avoid duplicate characters in the stack.
Data Structures Used
int[] last → last index of each character.
boolean[] visited → whether a character is already in the stack.
Deque<Character> → acts as a stack.
Complexity
Time: O(n)
Space: O(26) (constant for lowercase letters)
Intuition

The GCD is required only for the smallest and largest numbers in the array. Therefore, instead of considering every element for the GCD, we first identify the minimum and maximum values and then compute their GCD.

Algorithm
Initialize min and max.
Traverse the array:
Update min.
Update max.
Use the Euclidean Algorithm to calculate the GCD of min and max.
Return the result.
Correctness Proof
After one traversal:
min is the smallest element in the array.
max is the largest element in the array.
The problem explicitly asks for the GCD of these two numbers.
The Euclidean Algorithm is mathematically proven to return the greatest common divisor of two integers.
Therefore, the algorithm always returns the correct answer.
Complexity
Time: O(n)
Space: O(1)
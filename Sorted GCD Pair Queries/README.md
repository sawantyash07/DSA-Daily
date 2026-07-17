Intuition

Generating all n × (n - 1) / 2 pairs is impossible for n = 10^5. Instead of constructing the sorted GCD array directly, count how many pairs have each possible GCD using number theory.

Algorithm
Count the frequency of every value.
For every divisor d, count how many numbers are divisible by d.
Compute the number of pairs divisible by d as C(cnt, 2).
Use Inclusion-Exclusion (reverse sieve) to obtain the number of pairs whose GCD is exactly d.
Build a prefix sum over the exact counts.
For each query k, binary search the prefix array to find the smallest GCD whose cumulative pair count exceeds k.
Correctness
Every pair whose GCD is a multiple of d contributes to pairsDivisible[d].
Processing divisors from largest to smallest ensures that subtracting the counts of larger multiples leaves only pairs with GCD exactly d.
The prefix array represents the virtual sorted gcdPairs array, so binary search returns the correct GCD for every query.
Complexity
Building frequencies: O(n)
Counting divisible elements: O(M log M)
Inclusion-Exclusion: O(M log M)
Answering queries: O(q log M)

Overall Complexity:

Time: O(n + M log M + q log M)
Space: O(M)
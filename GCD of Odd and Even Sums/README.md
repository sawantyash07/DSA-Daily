Instead of calculating the sums explicitly, use the mathematical formulas:

Sum of the first n odd numbers:
sumOdd = n²
Sum of the first n even numbers:
sumEven = n(n + 1)

Now compute:

GCD(n², n(n + 1))

Factor out n:

= n × GCD(n, n + 1)

Since two consecutive integers are always coprime:

GCD(n, n + 1) = 1

Therefore,

GCD(sumOdd, sumEven) = n

So the answer is simply:

return n;
Algorithm
Read the input integer n.
Return n.
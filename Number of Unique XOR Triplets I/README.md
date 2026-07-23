# 3513. Number of Unique XOR Triplets I

## Intuition

Since the array is a permutation of `1...n`, only the values matter.

A triplet XOR can be of three types:

- `a ^ a ^ a = a`
- `a ^ a ^ b = b`
- `a ^ b ^ b = a`
- `a ^ b ^ c` (all distinct)

The first three cases never create a new value—they only reproduce an existing number.

Therefore, the only new XOR values come from choosing three distinct numbers.

A mathematical property of the set `{1,2,...,n}` is:

- For `n = 1`, only one value exists.
- For `n = 2`, only the original two values exist.
- For `n >= 3`, every value in the range

    0 ... (2^k - 1)

  can be formed, where `k` is the number of bits required to represent `n`.

Thus the number of unique XOR values is simply:

- `1` if `n = 1`
- `2` if `n = 2`
- `2^k` otherwise


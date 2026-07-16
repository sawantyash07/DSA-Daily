# 3867. Sum of GCD of Formed Pairs

## Approach

### Step 1: Construct prefixGcd

Maintain the maximum value seen so far while traversing the array.

For every index:

- mx = maximum of nums[0...i]
- prefixGcd[i] = gcd(nums[i], mx)

---

### Step 2: Sort

Sort the prefixGcd array in non-decreasing order.

---

### Step 3: Form pairs

Use two pointers.

- Left pointer starts from the beginning.
- Right pointer starts from the end.

For every pair:

answer += gcd(prefixGcd[left], prefixGcd[right])

Move both pointers toward the center.

If the array length is odd, the middle element remains unpaired automatically.

---

## Correctness

The running maximum correctly computes every prefix maximum.

Each prefixGcd value is computed exactly as required.

Sorting produces the required order.

The two-pointer technique always pairs the smallest remaining element with the largest remaining element, matching the problem statement.

Thus every required pair contributes exactly one gcd to the final answer.

---

## Complexity

- Building prefixGcd: **O(n)**
- Sorting: **O(n log n)**
- Pairing: **O(n)**

Overall Time Complexity:

O(n log n)

Space Complexity:

O(n)
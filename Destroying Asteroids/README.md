# LeetCode 2126 - Destroying Asteroids

## Problem Statement

You are given an integer `mass`, which represents the original mass of a planet, and an integer array `asteroids`, where `asteroids[i]` is the mass of the ith asteroid.

You can arrange the asteroids in any order. If the planet's mass is greater than or equal to an asteroid's mass, the asteroid is destroyed and the planet gains that mass. Otherwise, the planet is destroyed.

Return `true` if all asteroids can be destroyed; otherwise, return `false`.

---

## Approach

### Greedy + Sorting

To maximize the planet's growth, always collide with the smallest asteroid available first.

1. Sort the asteroid masses in ascending order.
2. Traverse the sorted array.
3. If the current planet mass is less than an asteroid's mass, return `false`.
4. Otherwise, destroy the asteroid and add its mass to the planet.
5. If all asteroids are destroyed, return `true`.

---

## Java Solution

```java
import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currMass = mass;

        for (int asteroid : asteroids) {
            if (currMass < asteroid) {
                return false;
            }
            currMass += asteroid;
        }

        return true;
    }
}
```

## Complexity Analysis

- Time Complexity: O(n log n)
  - Sorting takes O(n log n)
  - Traversal takes O(n)

- Space Complexity: O(1)
  - Ignoring the space used by the sorting algorithm

---

## Example

### Input

```text
mass = 10
asteroids = [3,9,19,5,21]
```

### Output

```text
true
```

### Explanation

Sorted asteroids:

```text
[3,5,9,19,21]
```

Planet mass progression:

```text
10 -> 13 -> 18 -> 27 -> 46 -> 67
```

All asteroids are destroyed successfully.

---

## Tags

- Greedy
- Sorting
- Arrays

## LeetCode Link


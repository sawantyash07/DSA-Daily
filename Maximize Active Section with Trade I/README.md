Intuition

A valid trade consists of two operations:

Convert a contiguous block of 1s surrounded by 0s into 0s.
Convert a contiguous block of 0s surrounded by 1s into 1s.

Instead of simulating every possible trade, observe that removing a surrounded 1 block merges the adjacent left and right zero blocks into one larger zero block. Flipping this merged zero block to 1s increases the number of active sections by only the sizes of the two neighboring zero blocks.

Approach
Count the total number of active sections (1s) in the original string.

Augment the string as:

t = "1" + s + "1"

This simplifies checking whether a block is surrounded.

Perform Run-Length Encoding (RLE) on the augmented string, storing:
Character of each run
Length of each run
Traverse all runs.

Whenever a run is:

0-run | 1-run | 0-run

it represents a removable 1 block.

The resulting active sections become:

totalOnes + leftZeroLength + rightZeroLength
Return the maximum value obtained.
Why It Works

Suppose the pattern is:

0...0 111...111 0...0

Removing the middle 1s changes it to:

0...0 000...000 0...0

The three zero blocks merge into one large zero block.

Flipping this merged block back to 1s converts:

leftZeros + removedOnes + rightZeros

into active sections.

Since the removed 1s were already counted initially, they cancel out, leaving a net gain of only:

leftZeroLength + rightZeroLength

Therefore, checking every surrounded 1 block is sufficient to find the optimal trade.

Complexity Analysis
Time Complexity: O(n)
Space Complexity: O(n)
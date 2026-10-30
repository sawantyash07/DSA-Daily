3871. Count Commas in Range II
Problem

You are given an integer n.

Return the total number of commas used when writing all integers from 1 to n in standard number formatting.

A comma is inserted after every three digits from the right.

For example:

999 → 999 → 0 commas
1,000 → 1 comma
1,000,000 → 2 commas
Approach

Instead of checking every number individually, count how many numbers contribute a comma at each digit-group level.

First comma

Every number from 1000 onwards contains at least one comma.

So, for n >= 1000:

n - 1000 + 1

numbers contribute one comma.

Additional commas

Every number from 1,000,000 onwards contains a second comma.

Similarly, every number from 1,000,000,000 onwards contains a third comma.

Therefore, for every power of 1000:

1000, 1,000,000, 1,000,000,000, ...

we add:

n - p + 1

if p <= n.

Algorithm
Initialize ans = 0.
Start with p = 1000.
While p <= n:
Add n - p + 1 to ans.
Multiply p by 1000.
Return ans.
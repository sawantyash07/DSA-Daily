Problem

You are given a cinema with n rows. Each row contains 10 seats numbered from 1 to 10.

Some seats are already reserved.

A family of 4 people must sit together in the same row. They can occupy only one of these seat blocks:

Seats 2, 3, 4, 5
Seats 4, 5, 6, 7
Seats 6, 7, 8, 9

The goal is to find the maximum number of families that can be seated.

Example
Input
n = 3
reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
Output
4
Explanation
Row 1 → One family can sit in seats 4,5,6,7
Row 2 → One family can sit in seats 2,3,4,5
Row 3 → Two families can sit in seats 2,3,4,5 and 6,7,8,9

Therefore:

1 + 1 + 2 = 4
Approach

The important observation is that a completely empty row can always accommodate 2 families:

Seats:   1 2 3 4 5 6 7 8 9 10
           [2 3 4 5] [6 7 8 9]
              Family    Family

Since n can be as large as 10^9, we cannot iterate through every row.

Instead, we only process rows that contain reserved seats.

Bitmask

For every row, we store its reserved seats using an integer bitmask.

For example, seat 2 is represented by:

1 << (2 - 1)

Seat 5 is:

1 << (5 - 1)

The three possible family blocks are also represented using bitmasks.

int left = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);
int middle = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6);
int right = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);

We can check whether a block is free using:

(mask & left) == 0

If the result is true, none of the seats in that block are reserved.

Algorithm
Create a HashMap where:
Key = row number
Value = bitmask of reserved seats in that row.
Assume every row without reservations can accommodate 2 families.
answer = (n - reserved.size()) * 2;
For every row containing reservations:
Check whether the left block is available.
Check whether the middle block is available.
Check whether the right block is available.
If both the left and right blocks are available, add 2.
Otherwise, if any one of the three blocks is available, add 1.
Return the final answer.
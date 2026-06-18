# 1344. Angle Between Hands of a Clock

## Problem Statement
Given two numbers, `hour` and `minutes`, return the smaller angle (in degrees) formed between the hour and the minute hand of an analog clock.

---

## Approach

1. Calculate the angle of the minute hand:
   - Minute hand moves `6°` per minute.
   - `minuteAngle = minutes * 6`

2. Calculate the angle of the hour hand:
   - Hour hand moves `30°` per hour.
   - It also moves `0.5°` per minute.
   - `hourAngle = (hour % 12) * 30 + minutes * 0.5`

3. Find the absolute difference between the two angles:
   - `diff = |hourAngle - minuteAngle|`

4. Return the smaller angle:
   - `min(diff, 360 - diff)`
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        
        // Group the stones by their value modulo 3
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // Scenario 1: Even number of multiples of 3
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        } 
        // Scenario 2: Odd number of multiples of 3
        else {
            return Math.abs(count[1] - count[2]) > 2;
        }
    }
}
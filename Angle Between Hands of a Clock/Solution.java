class Solution {
    public double angleClock(int hour, int minutes) { 
        double minangle=minutes*6;
        double hrangle=(hour%12)*30+minutes*0.5;
        double diff=Math.abs(hrangle-minangle);
        return Math.min(diff,360-diff);
    }
}
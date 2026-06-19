class Solution {
    public int largestAltitude(int[] gain) {
       int ca=0,ma=0;
       for(int i=0;i<gain.length;i++)
       {
            ca=ca+gain[i];
            ma=Math.max(ma,ca);
       }
       return ma;
    }
}
class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            int reverse='z'-s.charAt(i)+1;
            int position=i+1;
            sum=sum+reverse*position;
        }
        return sum;
    }
}
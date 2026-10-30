class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        int i=1;
        while(i<nums.length && nums[i]==nums[i-1]+1)
        {
            sum=sum+nums[i];
            i++;
        }

        boolean[] present=new boolean[101];
        for(int num:nums)
        {
            present[num]=true;
        }

        while(sum<=100 && present[sum])
        {
            sum++;
        }

        return sum;
    }
}
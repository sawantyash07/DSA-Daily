class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long minvalue=nums[0];
        long maxvalue=nums[0];

        for(int num:nums)
        {
            minvalue=Math.min(minvalue,num);
            maxvalue=Math.max(maxvalue,num);
        }
        return (maxvalue-minvalue)*k;
    }
}
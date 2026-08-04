import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:nums)
        {
            set.add(num);
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        
        for(int i=min;i<=max;i++)
        {
            if(!set.contains(i))
            {
                list.add(i);
            }
        }
        return list;        
    }
}
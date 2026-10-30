class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] len=new int[n];
        int INF=n+1;
        for(int i=0;i<n;i++)
        {
            len[i]=INF;
        }

        int left=0,sum=0;

        int shortest=INF,answer=INF;
        for(int right=0;right<n;right++)
        {
            sum=sum+arr[right];
            while(sum>target)
            {
                sum=sum-arr[left];
                left++;
            }
            if(sum==target)
            {
                int currentLength=right-left+1;
                if(left>0)
                {
                    answer=Math.min(answer,currentLength+len[left-1]);
                }
                shortest=Math.min(shortest,currentLength);
            }
            if(right==0)
            {
                len[right]=shortest;
            }
            else
            {
                len[right]=Math.min(len[right-1],shortest);
            }
        }
        return answer==INF?-1:answer;
    }
}
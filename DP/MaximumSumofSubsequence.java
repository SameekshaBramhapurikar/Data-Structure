class Solution {
    private static int f(int index,int[] nums,int[] dp)
    {
        int n=nums.length;
        if(index==0)
        {
            return nums[index];
        }
        if(index < 0)
        {
            return 0;
        }
        if(dp[index] != -1)
        {
            return dp[index];
        }
        int pick = nums[index] + f(index-2,nums,dp);
        int notpick = 0 + f(index-1,nums,dp);

        dp[index]=Math.max(pick,notpick);

        return dp[index];
    }
    public int nonAdjacent(int[] nums) {
        int n=nums.length;
        int prev =nums[0];
        int prev2 = 0;
        for (int i=1; i<n ;i++)
        {
            int take= nums[i];
            if(i > 1)
            {
                take += prev2;
            }
            int nottake=0 + prev;

            int curi= Math.max(take,nottake);
            prev2=prev;
            prev=curi;
        }
       

        return prev;
    }
}

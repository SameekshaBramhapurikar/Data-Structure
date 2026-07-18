class Solution {
    private static int f(int index,int height[],int dp[])
    {
        
        
        if(index == 0)
            return 0;
            
        if(dp[index] != -1)
            return dp[index];
        
        int left=f(index-1,height,dp)+Math.abs(height[index]-height[index-1]);
        
        int right = Integer.MAX_VALUE;
        if(index > 1)
        {
            right = f(index-2,height,dp) + Math.abs(height[index]-height[index-2]);
        }
        dp[index]=Math.min(left,right);
        
        return dp[index];
    }
  //tabulisation
    int minCost(int[] height) 
    {
        int n= height.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
            int fs = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int ss=Integer.MAX_VALUE;
            if(i > 1)
            {
                    ss= dp[i-2] + Math.abs(height[i] - height[i-2] );
            }
            dp[i]=Math.min(fs,ss);
        }
        return dp[n-1];
    }
}

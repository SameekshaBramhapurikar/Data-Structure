class Solution {
    private int f(int idx,int w,int[] val,int[] wt,int[][] dp)
    {
        if(idx==0)
        {
            if(wt[0] <= w)
            {
                return val[0];
            }
            return 0;
        }
        if(dp[idx][w] != -1)
        {
            return dp[idx][w];
        }
        
        int take=Integer.MIN_VALUE;
        int notTake=0 + f(idx-1, w, val,wt,dp);
        
        if(wt[idx] <= w)
        {
            take=val[idx] + f(idx-1,w-wt[idx],val,wt,dp);
        }
        
        dp[idx][w]= Math.max(notTake,take);
        
        return dp[idx][w];
    }
    public int knapsack(int W, int val[], int wt[]) {
        int n=val.length;
        int[] prev= new int[W+1];
        Arrays.fill(prev,0);
        for(int i = wt[0]; i<=W;i++)
        {
            prev[i]=val[0];
        }
        for(int ind=1;ind<n;ind++)
        {
            int[] cur = new int[W + 1];
            for(int i=0;i<= W;i++)
            {
                int take=Integer.MIN_VALUE;
                int notTake=0 + prev[i];
                
                if(wt[ind] <= i)
                {
                    take=val[ind] + prev[i-wt[ind]];
                }
                
                cur[i]= Math.max(notTake,take);
            }
            prev=cur;
        }
        return prev[W];
        
    }
}

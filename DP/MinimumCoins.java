class Solution {
    private int f(int ind,int target,int[] coins,int[][]dp)
    {
        if(ind == 0)
        {
            if(target % coins[0]==0)
            {
                return target/coins[0];
            }
            return (int)1e9;
        }
        if(dp[ind][target] != -1)
        {
            return dp[ind][target];
        }
        int take=(int)1e9;
        int notTake=0+f(ind-1,target,coins,dp);
        if(coins[ind] <= target)
        {
            take=1+f(ind,target-coins[ind],coins,dp);
        }
        dp[ind][target]=Math.min(notTake,take);
        return dp[ind][target];
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int T=0;T<=amount;T++)
        {
            if(T % coins[0]==0)
                dp[0][T]=T/coins[0];
            else 
                dp[0][T]=(int)1e9;
        }
        for(int ind=1;ind < n;ind++)
        {
            for(int T=0;T<=amount;T++)
            {
                int take=(int)1e9;
                int notTake= 0 + dp[ind-1][T];
                if(coins[ind] <= T)
                {
                    take= 1 + dp[ind][T-coins[ind]];
                }
                dp[ind][T]=Math.min(notTake,take);
                
            }
        }

        int ans= dp[n-1][amount];
        if(ans >= (int)1e9) return -1;
        return ans;
    }
}

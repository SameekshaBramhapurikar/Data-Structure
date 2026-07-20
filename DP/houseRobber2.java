class Solution {
    private static int nonAdjacent(int[] nums) {
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
    public int rob(int[] nums) {
        int n=nums.length;
        int[] temp1= new int[n];
        int[] temp2= new int[n];
        int idx=0;
        int idx2=0;
        if(n==1)
            return nums[0];
        for(int i=0;i<n;i++)
        {
            if(i != 0)
                temp1[idx++]=nums[i];

            if(i != n-1)
                temp2[idx2++]=nums[i];
        }
        return Math.max(nonAdjacent(temp1),nonAdjacent(temp2));
    }
}

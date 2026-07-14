
class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];

            if(sum > maxi)
            {
                maxi=sum;
            }
            if(sum < 0)
            {
                sum=0;
            }
        }

        return maxi;
    }
}
// including empty sets 
class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        int ansStart=-1;
        int ansEnd=-1;
        int start=0;

        for(int i=0;i<nums.length;i++)
        {
            if(sum ==0)
            {
                start =i;
            }
            sum=sum+nums[i];

            if(sum > maxi)
            {
                maxi=sum;
                ansStart = start;
                ansEnd=i;
            }
            if(sum < 0)
            {
                sum=0;
            }
        }

        return maxi;
    }
}

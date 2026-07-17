class Solution {
    private void recurPermute(int index ,List<List<Integer>> ans, int nums[])
    {
        int n=nums.length;
        if(index == n)
        {
            ArrayList<Integer> ds= new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<n;i++)
        {
           swap(i,index,nums);
           recurPermute(index+1,ans,nums);
           swap(i,index,nums);
        }
    }
    private void swap(int i, int j, int[] nums)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        recurPermute(0,ans,nums);    
        return ans;    
    }

}

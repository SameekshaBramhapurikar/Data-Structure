class Solution {
    private void func(int ind,int[] nums,List<List<Integer>> arr,List<Integer> ds)
    {
        arr.add(new ArrayList(ds));
        for(int i=ind;i<nums.length;i++)
        {
            if(i != ind && nums[i]== nums[i-1])
                continue;
            
            ds.add(nums[i]);
            func(i+1,nums,arr,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList=new ArrayList<>();
        func(0,nums,ansList,new ArrayList<>());
        return ansList;
    }
}

class Solution {
    private void func(int ind,int sum,int[] arr,int N, ArrayList<Integer> ds)
    {
        if(ind == N)
        {
            ds.add(sum);
            return;
        }
        //pick 
        func(ind+1,sum+arr[ind],arr,N,ds);

        //not pick
        func(ind+1,sum,arr,N,ds);
    }
    public List<Integer> subsetSums(int[] nums) {
        int N=nums.length;
        ArrayList<Integer> SumSubset=new ArrayList<>();
        func(0,0,nums,N,SumSubset);
        Arrays.sort(nums);
        return SumSubset;
    }
}

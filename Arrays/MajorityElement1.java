// better 
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i])+1);
            }
            else 
            {
                 map.put(nums[i], 1);
            }
            for(Map.Entry<Integer,Integer> entry: map.entrySet())
            {
                if(entry.getValue() > (n/2))
                {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }
}

//optimal
class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int el=0;
        for(int i=0;i< nums.length;i++)
        {
            if(cnt==0)
            {
                cnt=1;
                el=nums[i];
            }
            else if(nums[i]==el)
            {
                cnt++;
            }
            else 
            {
                cnt--;
            }
        }
        return el;
    }
}

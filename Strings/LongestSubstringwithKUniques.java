//TC=O(n)+O(n)

class Solution {
    public int longestKSubstr(String s, int k) {
        int n=s.length();
        int maxlen=0;
        int r=0;
        int l=0;
        Map<Character,Integer> map= new HashMap<>();
        
        while(r < n)
        {
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(map.size() > k)
            {
                char left=s.charAt(l);
                map.put(left,map.get(left)-1);
                if(map.get(left) == 0)
                    map.remove(left);
                l=l+1;
            }
           
            if(map.size() == k)
            {
                maxlen=Math.max(maxlen,r-l+1);
            }
              r=r+1;
        }
        return maxlen;
    }
}

//TC=O(n)
class Solution {
    public int longestKSubstr(String s, int k) {
        int n=s.length();
        int maxlen=0;
        int r=0;
        int l=0;
        Map<Character,Integer> map= new HashMap<>();
        
        while(r < n)
        {
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            if(map.size() > k)
            {
                char left=s.charAt(l);
                map.put(left,map.get(left)-1);
                if(map.get(left) == 0)
                    map.remove(left);
                l=l+1;
            }
           
            if(map.size() == k)
            {
                maxlen=Math.max(maxlen,r-l+1);
            }
              r=r+1;
        }
        return maxlen;
    }
}

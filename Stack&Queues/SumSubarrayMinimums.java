//brute 
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int sum=0;
        int n=arr.length;
        int mini=0;
        int mod=(int)(1e9+7);

        for(int i=0;i<n;i++)
        {
            mini=arr[i];
            for(int j=i;j<n;j++)
            {
                mini=Math.min(mini,arr[j]);
                sum=(sum+mini)%mod;
            }
        }
    return (int)sum;
    }
}
//optimal 
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=(int)(1e9+7);

        int[] nse=nextSmallerElement(arr,n);
        int[] psee=previousSmallerElement(arr,n);
       
   

    int total=0;
    for(int i=0;i<n;i++)
    {
        int left=i-psee[i];
        int right=nse[i]-i;
        total=(total + (right*left%mod)*arr[i] % mod) % mod;
    }
    return (int) total;
    }
     private int[] nextSmallerElement (int[] arr,int n){
        int[] nse=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                int idx=st.pop();
                nse[idx]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nse[st.pop()]=n;
        }
    return nse;
    }
     private int[] previousSmallerElement(int[] arr,int n){
        int[] psee=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
                psee[i]=-1;
            else 
                psee[i]=st.peek();
            
            st.push(i);
        }
    return psee;
    }
}

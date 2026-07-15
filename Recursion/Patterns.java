import java.util.ArrayList;
class Main {
    
    static void printS(int ind,ArrayList<Integer> ds,int s,int sum,int arr[],int n)
    {
        if(ind==n)
        {
            if(s==sum)
            {
                for(int it: ds)
                {
                    System.out.print(it);
                }
                System.out.println();
            }
            return;
        }
        
        ds.add(arr[ind]);
        s+=arr[ind];
        
        printS(ind+1,ds,s,sum,arr,n);
        
        s-=arr[ind];
        ds.remove(ds.size()-1);
        
        printS(ind+1,ds,s,sum,arr,n);
    }
    
    
    public static void main(String[] args) {
     int arr[]={1,2,1};
     int n=3;
     int sum=2;
     ArrayList<Integer> ds=new ArrayList<>();
     printS(0,ds,0,sum,arr,n);
     
     return;
    }
}

//print one subsequence with sum K
import java.util.ArrayList;
class Main {
    
    static boolean printS(int ind,ArrayList<Integer> ds,int s,int sum,int arr[],int n)
    {
        if(ind==n)
        {
            if(s==sum)
            {
                for(int it: ds)
                    System.out.print(it);
                System.out.println();
                return true;
            }
            return false;
        }
        
        ds.add(arr[ind]);
        s+=arr[ind];
        
        if(printS(ind+1,ds,s,sum,arr,n)==true)
            return true;
        
        s-=arr[ind];
        ds.remove(ds.size()-1);
        
        if(printS(ind+1,ds,s,sum,arr,n)==true)
            return true;
            
        return false;
    }
    
    
    public static void main(String[] args) {
     int arr[]={1,2,1};
     int n=3;
     int sum=2;
     ArrayList<Integer> ds=new ArrayList<>();
     printS(0,ds,0,sum,arr,n);
     
     return;
    }
}

//cnt of the subsequences 
import java.util.ArrayList;
class Main {
    
    static int printS(int ind,int s,int sum,int arr[],int n)
    {
        if(ind==n)
        {
            if(s==sum)
                return 1;
            else 
                return 0;
        }
        
        s+=arr[ind];
        
        int l=printS(ind+1,s,sum,arr,n);
        
        s-=arr[ind];
       
        
        int r=printS(ind+1,s,sum,arr,n);
            
        return l+r;
    }
    
    
    public static void main(String[] args) {
     int arr[]={1,2,1};
     int n=3;
     int sum=2;
     System.out.println(printS(0,0,sum,arr,n));
     
     return;
    }
}

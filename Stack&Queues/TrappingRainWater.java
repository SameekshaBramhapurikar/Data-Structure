//TC=O(N)
//SC=O(1)
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lMax=0;
        int rMax=0;
        int total=0;
        int l=0;
        int r=n-1;

        while(l < r)
        {
            if(height[l] <= height[r])
            {
                if(lMax > height[l])
                {
                    total+=lMax - height[l];
                }
                else 
                {
                    lMax=height[l];
                }
                l=l+1;
            }
            else 
            {
                if(rMax > height[r])
                {
                    total += rMax - height[r];
                }
                else
                {
                    rMax=height[r];
                }
                rMax=r-1;
            }
        }
        return total;
    }
}

//TC=O(N)
//SC=O(N)
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int [n];
        int[] rightMax=new int[n];
        int total=0;
        int waterlevel=0;

        leftMax[0]=height[0];
        for(int i=1;i<n;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }

        rightMax[n-1]=height[n-1];
        for(int i=n-2; i >= 0;i--)
        {
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }

        for(int i=1;i<n;i++)
        {
            
            waterlevel=Math.min(leftMax[i],rightMax[i]);
            total+=waterlevel-height[i];
        }

    return total;
    }
}

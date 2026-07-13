class Solution {
    public boolean canFinish(int N, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=arr.length;
        for(int i=0;i<m;i++)
        {
            adj.get(arr[i][0]).add(arr[i][1]);
        }
        int indegree[]= new int[N];
        for(int i=0;i<N;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        ArrayList<Integer> topo= new ArrayList<>();
        int i=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            topo.add(node);

            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        if(topo.size()==N)
            return true;
        
        return false;
    }
}

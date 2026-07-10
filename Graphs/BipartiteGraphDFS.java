class Solution {
    private boolean dfs(int node, int col,List<List<Integer>> edges, int color[])
    { 
        color[node]=col;

        for(int it:edges.get(node))
        {
            if(color[it]==-1)
            {
                if(dfs(it,1-col,edges,color)==false)
                {
                    return false;
                }
            }
            else if(color[it]== col)
            {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, List<List<Integer>> edges) {
      
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Convert edge list -> adjacency list
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
      int color[]=new int[V];
     
      for(int i=0;i<V;i++)
      {
        color[i]=-1;
      }
      for(int i=0;i<V;i++)
      {
        if(color[i]==-1)
        {
            if(dfs(i,0,adj,color)==false)
            {
                return false;
            }
        }
      }
      return true;
    }
}

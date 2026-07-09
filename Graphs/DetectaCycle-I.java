class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}



class Solution {

    public boolean CheckforCycle(int src,int V, List<Integer>[] adj, boolean vis[])
    {
         vis[src]=true;
         Queue<Pair> q= new LinkedList<>();
         q.add(new Pair (src,-1));
         while(!q.isEmpty())
         {
            Pair current=q.poll();
            int node=current.first;
            int parent=current.second;

            for(int adjacentNode: adj[node])
            {
                if(vis[adjacentNode]==false)
                {
                    vis[adjacentNode]=true;
                    q.add(new Pair(adjacentNode,node));
                }
                else if(parent != adjacentNode)
                {
                    return true;
                }
            }
         }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean vis[]= new boolean[V];
        for(int i=0; i<V; i++)
        {
            vis[i] = false;
        }
        for(int i=0;i<V; i++)
        {
            if(vis[i]==false)
            {
                if(CheckforCycle(i,V,adj,vis))
                    return true;
            }
        } 
        return false;
    }
}
 

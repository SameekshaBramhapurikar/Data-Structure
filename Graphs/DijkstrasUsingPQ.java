class Pair
{
    int first;
    int second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}


class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int v=edges[i][0];
            int u=edges[i][1];
            int wt=edges[i][2];
            
            //undirected graph 
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((x,y) -> x.first - y.first);
        
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9);
        for(int i=0;i<V;i++)
        {
            dist[i]= (int)1e9;
            
        }
        
        dist[src]=0;
        pq.add(new Pair(0,src));
        
        while(!pq.isEmpty())
        {
            int dis=pq.peek().first;
            int node=pq.peek().second;
            pq.remove();
            
            if (dis > dist[node])
                continue;
            
            for(int i=0;i<adj.get(node).size();i++)
            {
                //Pair it= adj.get(node).get(i);
                int adjNode=adj.get(node).get(i).first;
                int edgeWeight=adj.get(node).get(i).second;
                
                if(dis + edgeWeight < dist[adjNode])
                {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        
        return dist;
    }
}

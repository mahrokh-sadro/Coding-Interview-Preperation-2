// here is an undirected graph with n nodes.
// There is also an edges array, where 
// edges[i] = [a, b] means that there is
// an edge between node a and node b in
// the graph.

// The nodes are numbered from 0 to n - 1.

// Return the total number of connected
// components in that graph.

// 1 <= n <= 100
// 0 <= edges.length <= n * (n - 1) / 2

class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edg:edges){
            graph.get(edg[0]).add(edg[1]);
            graph.get(edg[1]).add(edg[0]);
        }

        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
           if(!visited[i]){
             dfs(graph,i,visited);
             count++;
           }
        }
        return count;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited){
        if(visited[node]){
            return ;
        }

        visited[node]=true;
        for(var neighbor:graph.get(node)){
            dfs(graph,neighbor,visited);
        }
    }
}


// Time: O(n + e)
// Space: O(n + e)



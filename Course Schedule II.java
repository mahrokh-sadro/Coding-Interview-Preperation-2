// There are a total of numCourses 
// courses you have to take, labeled 
// from 0 to numCourses - 1. You are
// given an array prerequisites where 
// prerequisites[i] = [ai, bi] indicates
// that you must take course bi first if
// you want to take course ai.
// For example, the pair [0, 1], 
// indicates that to take course 0
// you have to first take course 1.
// Return the ordering of courses you should
// take to finish all courses. If there are
// many valid answers, return any of them. 
// If it is impossible to finish all courses,
// return an empty array.

// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= numCourses * (numCourses - 1)
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// ai != bi
// All the pairs [ai, bi] are distinct.
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(graph,i,visited)){
                return new int[0];
            }
        }

        int[] array=new int[list.size()];
        int j=0;
        for(int k=list.size()-1;k>=0;k--){
            array[j++]=list.get(k);
        }

        return array;
    }

    List<Integer> list=new ArrayList<>();

    private boolean dfs(List<List<Integer>> graph, int node, int[] visited){
        if(visited[node]==1){
            return true;
        }

        if(visited[node]==2){
            return false;
        }

        visited[node]=1;
        for(var neighbor:graph.get(node)){
            if(dfs(graph,neighbor,visited)){
                return true;
            }
        }
        list.add(node);
        visited[node]=2;
        return false;
    }
}

// Time: O(n + m) because each node
//and edge is processed once
// Space: O(n + m) due to graph 
//storage and DFS recursion
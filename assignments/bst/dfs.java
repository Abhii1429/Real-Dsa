package assignments.bst;

import java.util.List;

public class dfs {
    public class DFS {
        public static void dfs(List<List<Integer>> adj, int node,
                           boolean[] visited, List<Integer> order) {
          visited[node] = true;
          order.add(node);
          for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                  dfs(adj, nei, visited, order);   // go deep immediately
                }
            }
        // returning here = backtracking
        }
         // call: dfs(adj, 0, new boolean[6], order) -> [0,1,3,4,5,2] -> A B D E F C
   }
}

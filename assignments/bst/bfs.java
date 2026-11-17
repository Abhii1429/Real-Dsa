package assignments.bst;
    import java.util.*;

class BFS {
    public static List<Integer> bfs(List<List<Integer>> adj, int start) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;          // mark when enqueuing
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();     // oldest first (FIFO)
            order.add(node);
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }
        return order;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[][] edges = {{10,11},};

        for (int[] e : edges) {           // undirected: add both ways
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        System.out.println(bfs(adj, 0));  // [0, 1, 2, 3, 4, 5] -> A B C D E F
    }
}


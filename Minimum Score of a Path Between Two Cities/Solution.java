import java.util.*;

class Solution {

    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    int minScore = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        // Create adjacency list
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, visited);

        return minScore;
    }

    private void dfs(int node, List<List<Pair>> graph, boolean[] visited) {

        visited[node] = true;

        for (Pair neighbor : graph.get(node)) {

            minScore = Math.min(minScore, neighbor.weight);

            if (!visited[neighbor.node]) {
                dfs(neighbor.node, graph, visited);
            }
        }
    }

    // Driver Code (for VS Code)
    public static void main(String[] args) {

        Solution obj = new Solution();

        int n1 = 4;
        int[][] roads1 = {
                {1, 2, 9},
                {2, 3, 6},
                {2, 4, 5},
                {1, 4, 7}
        };

        System.out.println(obj.minScore(n1, roads1)); // Output: 5

        Solution obj2 = new Solution();

        int n2 = 4;
        int[][] roads2 = {
                {1, 2, 2},
                {1, 3, 4},
                {3, 4, 7}
        };

        System.out.println(obj2.minScore(n2, roads2)); // Output: 2
    }
}
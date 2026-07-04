class Solution {

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, visited);

        return ans;
    }

    private void dfs(int node, List<List<Pair>> graph, boolean[] visited) {

        visited[node] = true;

        for (Pair next : graph.get(node)) {

            ans = Math.min(ans, next.dist);

            if (!visited[next.node]) {
                dfs(next.node, graph, visited);
            }
        }
    }
}
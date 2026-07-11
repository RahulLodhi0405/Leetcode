class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] res = dfs(i, graph, vis);
                int nodes = res[0];
                int degreeSum = res[1];

                int edgeCount = degreeSum / 2;
                if (edgeCount == nodes * (nodes - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private int[] dfs(int node, ArrayList<Integer>[] graph, boolean[] vis) {
        vis[node] = true;

        int nodes = 1;
        int degreeSum = graph[node].size();

        for (int nei : graph[node]) {
            if (!vis[nei]) {
                int[] temp = dfs(nei, graph, vis);
                nodes += temp[0];
                degreeSum += temp[1];
            }
        }

        return new int[]{nodes, degreeSum};
    }
}
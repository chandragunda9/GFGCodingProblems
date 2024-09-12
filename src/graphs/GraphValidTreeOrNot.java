package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GraphValidTreeOrNot {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        if (m != n - 1)
            return false;
        //building adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (hasCycle(i, -1, vis, adj))
                    return false;
            }
        }
        return true;
    }

    boolean hasCycle(int u, int p, boolean[] vis, List<List<Integer>> adj) {
        vis[u] = true;
        List<Integer> conn = adj.get(u);
        for (int v : conn) {
            if (!vis[v]) {
                if (hasCycle(v, u, vis, adj))
                    return true;
            } else if (v != p) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 30, m = 3;
        int[][] edges = {{27, 14}, {21, 27}, {23, 9}};
        ArrayList<ArrayList<Integer>> al = Arrays.stream(edges).map(a ->
                        Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        GraphValidTreeOrNot obj = new GraphValidTreeOrNot();
        System.out.println(obj.isTree(n, m, al));
    }
}

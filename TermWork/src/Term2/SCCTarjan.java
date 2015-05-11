package Term2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ilgiz on 27.04.2015.
 */


public class SCCTarjan {

    private Graph graph;
    private Components components;
    private boolean[] visited;
    private Stack<Integer> stack;
    private int time;
    private int[] lowlink;


    public Components scc(Graph graph) {
        int n = graph.length();
        this.graph = graph;
        visited = new boolean[n];
        stack = new Stack<>();
        time = 0;
        lowlink = new int[n];
        components = new Components(new ArrayList<>());

        for (int u = 0; u < n; u++)
            if (!visited[u])
                dfs(u);

        return components;
    }

    private void dfs(int u) {
        lowlink[u] = time++;
        visited[u] = true;
        stack.add(u);
        boolean isComponentRoot = true;
        Iterator it = graph.iterator(u);
        while (it.hasNext()){
            int v = (int) it.next();
            if (!visited[v])
                dfs(v);
            if (lowlink[u] > lowlink[v]) {
                lowlink[u] = lowlink[v];
                isComponentRoot = false;
            }
        }

        if (isComponentRoot) {
            List<Integer> component = new ArrayList<>();
            while (true) {
                int x = stack.pop();
                component.add(x);
                lowlink[x] = Integer.MAX_VALUE;
                if (x == u)
                    break;
            }
            components.add(component);
        }
    }

    // Usage example
    public static void main(String[] args) {
        Graph g = new Graph(new List[8]);
        g.add(0, 1);
        g.add(1, 2);
        g.add(1, 3);
        g.add(1, 5);
        g.add(2, 0);
        g.add(2, 3);
        g.add(3, 4);
        g.add(4, 3);
        g.add(5, 4);
        g.add(5, 6);
        g.add(6, 5);
        g.add(6, 7);
        g.add(7, 6);
        g.add(7, 4);

        Components components = new SCCTarjan().scc(g);
        System.out.println(components);
    }
}


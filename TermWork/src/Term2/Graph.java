package Term2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ilgiz on 27.04.2015.
 */
public class Graph implements GraphInterface{
    private List<Integer>[] graph;

    public int length(){
        return graph != null ? graph.length : 0;
    }

    public Graph(List<Integer>[] graph) {
        this.graph = graph;
        for (int i = 0; i < length(); i++)
            graph[i] = new ArrayList<>();
    }
    public Iterator iterator(int i){
        return graph[i].iterator();
    }
    public void add(int i, int j){
        graph[i].add(j);
    }

    public Graph(int n) {
        this.graph = new List[n];
    }
}

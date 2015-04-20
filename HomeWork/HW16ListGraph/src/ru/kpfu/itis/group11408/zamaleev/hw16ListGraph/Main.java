package ru.kpfu.itis.group11408.zamaleev.hw16ListGraph;

/**
 * Created by Ilgiz on 20.04.2015.
 */
public class Main {

    public static void main(String[] args){
        Graph g = new Graph();
        for (int i = 0; i < 10; i++) {
            Vertex<String> v = new Vertex(String.valueOf(i));
            g.addVertex(v);
        }
        for (int i = 0; i < 10; i++) {
            g.link(new Vertex<String>("1"), new Vertex<String>(String.valueOf(i)));
        }
        System.out.println();
        if (g.hasLink(new Vertex<String>("1"), new Vertex<String>("0")))
            g.unlink(new Vertex<String>("1"), new Vertex<String>("0"));
        g.removeVertex(new Vertex<String>("1"));
    }
}

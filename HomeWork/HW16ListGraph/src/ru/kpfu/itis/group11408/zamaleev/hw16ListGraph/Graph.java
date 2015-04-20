package ru.kpfu.itis.group11408.zamaleev.hw16ListGraph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Ilgiz on 20.04.2015.
 */
public class Graph {
    private LinkedList adj;

    public Graph() {
        this.adj = new LinkedList();
    }

    public void addVertex(Vertex v){
        try{
            Iterator it = adj.iterator();
            while (it.hasNext()){
                LinkedList vertexList = (LinkedList)it.next();
                if (vertexList.peek().equals(v)){
                    throw new GraphException("Vertex has been previously added!");
                }
            }
            LinkedList vertexList = new LinkedList();
            vertexList.add(v);
            adj.add(vertexList);
        } catch (GraphException exception ){
            exception.printStackTrace();
        }
    }

    public void link(Vertex v, Vertex u){
        try{
            Iterator it = adj.iterator();
            boolean hasV = false;
            boolean hasU = false;
            while (it.hasNext() && !(hasU && hasV)){
                LinkedList vertexList = (LinkedList)it.next();
                Vertex v1 = (Vertex)(vertexList.peek());
                if (v.getData().equals(v1.getData())){
                    hasV = true;
                }
                if (u.getData().equals(v1.getData())){
                    hasU = true;
                }
            }
            if (!hasV){
                throw new GraphException("First vertex not found!");
            } else if (!hasU){
                throw new GraphException("Second vertex not found!");
            }
            it = adj.iterator();
            while (it.hasNext()){
                LinkedList vertexList = (LinkedList)it.next();
                Vertex v1 = (Vertex)(vertexList.peek());
                if (v.getData().equals(v1.getData())){
                    hasU = false;
                    it = vertexList.iterator();
                    it.next();
                    while (it.hasNext()){
                        v1 = (Vertex)it.next();
                        if (v1.getData().equals(u.getData())){
                            hasU = true;
                            break;
                        }
                    }
                    if (!hasU){
                        adj.remove(vertexList);
                        vertexList.add(u);
                        adj.add(vertexList);
                        break;
                    } else {
                        throw new GraphException("Vertexs has been previously linked!");
                    }
                }
            }
        } catch (GraphException exception ){
            exception.printStackTrace();
        }
    }

    public void removeVertex(Vertex v){
        try{
            boolean hasV = false;
            Iterator it = adj.iterator();
            while (it.hasNext()){
                LinkedList vertexList = (LinkedList)it.next();
                Vertex v1 = (Vertex)(vertexList.peek());
                if (v.getData().equals(v1.getData())){
                    hasV = true;
                    it.remove();
                    break;
                }
            }
            if (!hasV){
                throw new GraphException("First vertex not found!");
            }
        } catch (GraphException exception){
            exception.printStackTrace();
        }
    }

    public void unlink(Vertex v, Vertex u){
        try{
            Iterator it = adj.iterator();
            boolean hasV = false;
            boolean hasU = false;
            while (it.hasNext() && !(hasU && hasV)){
                LinkedList vertexList = (LinkedList)it.next();
                Vertex v1 = (Vertex)(vertexList.peek());
                if (v.getData().equals(v1.getData())){
                    hasV = true;
                }
                if (u.getData().equals(v1.getData())){
                    hasU = true;
                }
            }
            if (!hasV){
                throw new GraphException("First vertex not found!");
            } else if (!hasU){
                throw new GraphException("Second vertex not found!");
            }
            it = adj.iterator();
            while (it.hasNext()){
                LinkedList vertexList = (LinkedList)it.next();
                Vertex v1 = (Vertex)(vertexList.peek());
                if (v.getData().equals(v1.getData())){
                    hasU = false;
                    it = vertexList.iterator();
                    it.next();
                    while (it.hasNext()){
                        v1 = (Vertex)it.next();
                        if (v1.getData().equals(u.getData())){
                            hasU = true;
                            it.remove();
                            break;
                        }
                    }
                    if (!hasU){
                        throw new GraphException("Link not found!");
                    }
                    break;
                }
            }
        } catch (GraphException exception){
            exception.printStackTrace();
        }
    }

    public boolean hasLink(Vertex v, Vertex u){
        boolean result = true;
        try{
            Iterator it = adj.iterator();
            boolean hasV = false;
            boolean hasU = false;
            while (it.hasNext() && !(hasU && hasV)){
                LinkedList vertexList = (LinkedList)it.next();
                Vertex v1 = (Vertex)(vertexList.peek());
                if (v.getData().equals(v1.getData())){
                    hasV = true;
                }
                if (u.getData().equals(v1.getData())){
                    hasU = true;
                }
            }
            if (!hasV){
                throw new GraphException("First vertex not found!");
            } else if (!hasU){
                throw new GraphException("Second vertex not found!");
            }
            it = adj.iterator();
            while (it.hasNext()){
                LinkedList vertexList = (LinkedList)it.next();
                Vertex v1 = (Vertex)(vertexList.peek());
                if (v.getData().equals(v1.getData())){
                    hasU = false;
                    it = vertexList.iterator();
                    it.next();
                    while (it.hasNext()){
                        v1 = (Vertex)it.next();
                        if (v1.getData().equals(u.getData())){
                            hasU = true;
                            break;
                        }
                    }
                    result = hasU;
                    break;
                }
            }
        } catch (GraphException exception){
            exception.printStackTrace();
        }
        return result;
    }
}

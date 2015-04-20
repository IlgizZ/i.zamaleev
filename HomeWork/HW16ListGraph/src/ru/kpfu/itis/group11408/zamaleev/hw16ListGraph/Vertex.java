package ru.kpfu.itis.group11408.zamaleev.hw16ListGraph;

/**
 * Created by Ilgiz on 20.04.2015.
 */
public class Vertex<T> {
    private T data;

    public Vertex(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

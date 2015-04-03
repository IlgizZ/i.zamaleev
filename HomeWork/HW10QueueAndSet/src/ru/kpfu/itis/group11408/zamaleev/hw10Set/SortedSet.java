package ru.kpfu.itis.group11408.zamaleev.hw10Set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Ilgiz on 23.03.2015.
 */
public class SortedSet <T extends Comparable> implements Iterable<T> {
    private LinkedList<T> list;

    SortedSet(){
        this.list = new LinkedList<T>();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }
    public void remove(T t){
        Iterator it = list.iterator();
        int i = 0;
        int j = 0;
        while (it.hasNext() && ((j = t.compareTo(it.next())) >= 1)){
            i++;
        }
        if (j == 0){
            list.remove(i);
        }
    }

    public void add(T t){
        Iterator it = list.iterator();
        int i = 0;
        int j = 1;
        while (it.hasNext() && ((j = t.compareTo(it.next())) >= 1)){
            i++;
        }
        if (j != 0){
            list.add(i, t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        if (list != null){
            return list.iterator();
        }
        return null;
    }
}

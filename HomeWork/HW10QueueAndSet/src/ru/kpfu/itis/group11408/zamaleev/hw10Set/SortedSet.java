package ru.kpfu.itis.group11408.zamaleev.hw10Set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Ilgiz on 23.03.2015.
 */
public class SortedSet <T extends Comparable> implements Iterable<T> {
    LinkedList<T> list;

    SortedSet(){
        this.list = new LinkedList<T>();
    }

    class MyIterator implements Iterator<T>{
        int i = 0;
        @Override
        public boolean hasNext() {
            if (list.isEmpty()) return false;
            else {
                if (i + 1 < list.size()){
                    i++;
                    return true;
                }
                return false;
            }
        }

        @Override
        public T next() {
            if (!list.isEmpty()){
                return list.peek();
            }
            return null;
        }

    }

    @Override
    public MyIterator iterator() {
        return new MyIterator();
    }
}

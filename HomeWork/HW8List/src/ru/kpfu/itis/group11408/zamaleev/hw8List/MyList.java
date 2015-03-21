package ru.kpfu.itis.group11408.zamaleev.hw8List;

import java.util.*;

public class MyList<E> implements List<E> {

    private Item<E> head;
    private Item<E> last;
    private int size;
    private int nextIndex;

    class Item<E>{
        private Item<E> next;
        private E data;

        public void setNext(Item<E> t){
            this.next = t;
        }

        public Item<E> getNext(){
            return this.next;
        }

        Item (Item<E> itm, E data){
            this.next = itm;
            this.data = data;
        }

    }

    class MyIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            if (isEmpty()) return false;
            else {
                if (nextIndex < size()){
                    return true;
                }
                return false;
            }
        }

        @Override
        public E next() {
            if (!isEmpty() && hasNext()){
                Item<E> x = head;
                for (int i = 0; i < nextIndex; i++) {
                    x = x.getNext();
                }
                return x.data;
            }
            System.out.println("List hasn't this element");
            return null;
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        nextIndex = 0;
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Item<E> x = head; x != null; x = x.next)
            result[i++] = x.data;
        return result;
    }

    @Override
    //not need
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(E e) {
        size++;
        Item<E> newItem = new Item<E>(null, e);
        last.next = newItem;
        last = newItem;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (o == null) {
            for (Item<E> x = head; x != null; x = x.next) {
                if (x.data == null) {
                    x = x.next;
                    return true;
                }
            }
        } else {
            if (head == null){
                System.out.println("List is empty!!");
                return false;
            }
            for (Item<E> x = head; x != null; x = x.next) {
                if (o.equals(x.data)) {
                    x = x.next;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        for (Item<E> x = head; x != null; ) {
            Item<E> next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        head = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < size){
            Item<E> result = null;
            for (Item<E> x = head; index > 0; x = x.next) {
                index--;
                result = x;
            }
            return result.data;
        }
        System.out.println("Element not found! Index > Size");
        return null;
    }

    @Override
    public E set(int index, E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(int index, E element) {
        // TODO Auto-generated method stub

    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Item<E> x = head; x != null; x = x.next) {
                if (x.data == null)
                    return index;
                index++;
            }
        } else {
            for (Item<E> x = head; x != null; x = x.next) {
                if (o.equals(x.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

}

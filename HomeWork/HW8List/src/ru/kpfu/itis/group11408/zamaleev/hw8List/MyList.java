package ru.kpfu.itis.group11408.zamaleev.hw8List;

import java.util.*;

public class MyList<E> implements List<E> {

    private Item<E> head;
    private Item<E> last;
    private int size = 0;

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
        private int nextIndex = 0;
        @Override
        public boolean hasNext() {
            return nextIndex != size;
        }

        @Override
        public E next() {
            if (hasNext()){
                Item<E> x = head;
                for (int i = 0; i < nextIndex; i++) {
                    x = x.getNext();
                }
                nextIndex++;
                return x.data;
            }
            System.out.println("List hasn't next element");
            return null;
        }

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
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
        Item<E> newItem = new Item<E>(null, e);
        if (size == 0){
            head = newItem;
            last = newItem;
            size ++;
            return true;
        }
        size++;
        last.next = newItem;
        last = newItem;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (o == null) {
            Item<E> previous = head;
            for (Item<E> x = previous.next; x != null; x = x.next) {
                if (x.data == null) {
                    previous.next = x.next;
                    size--;
                    return true;
                }

            }
        } else {
            if (head == null){
                System.out.println("List is empty!!");
                return false;
            }
            Item<E> previous = head;
            for (Item<E> x = previous.next; x != null; x = x.next) {
                if (o.equals(x.data)) {
                    previous.next = x.next;
                    size--;
                    return true;
                }
                previous = x;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> it = c.iterator();
        for (Item<E> x = head; (x != null) && (it.hasNext()); x = x.next) {
            if (!it.next().equals(x.data)) {
                return false;
            }
        }
        return !it.hasNext();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Iterator<?> it = c.iterator();
        while (it.hasNext()){
            add((E) it.next());
        }
        it = c.iterator();
        return it.hasNext();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Iterator collectionIt = iterator();
        if (!collectionIt.hasNext())
            return false;
        Iterator it = iterator();
        Item<E> x = head;
        while (index > 1 && (it.hasNext())){
            it.next();
            index--;
            x = x.next;
        }
        if (!it.hasNext())
                return false;
        Item<E> collectionHead = new Item<>(null, (E)collectionIt.next());
        size++;
        Item<E> collectionItem = collectionHead;
        while(collectionIt.hasNext()){
            collectionItem.next = new Item<>(null, (E)collectionIt.next());
            collectionItem = collectionItem.next;
            size++;
        }
        collectionItem.next = x.next;
        x.next = collectionHead;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator it = c.iterator();
        while (it.hasNext()){
            Object o = it.next();
            if (contains(o)){
                remove(o);
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator it = iterator();
        while (it.hasNext()){
            Object o = it.next();
            if (c.contains(o)){
                remove(o);
                it = iterator();
            }
        }
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
        Iterator it = iterator();
        Item<E> x = head;
        int i = index;
        while (it.hasNext() && i > 1){
            x = x.next;
            i--;
        }
        if (!it.hasNext()){
            return null;
        }
        size++;
        x.next = new Item<>(x.next, element);
        return x.next.next.data;
    }

    @Override
    public void add(int index, E element) {
       set(index, element);
    }

    @Override
    public E remove(int index) {
        Iterator it = iterator();
        Item<E> x = head;
        while (it.hasNext() && index > 1){
            x = x.next;
            it.next();
            index--;
        }
        if (index > 1){
            return null;
        }
        size--;
        Item<E> tmp = x;
        x = x.next;
        return tmp.data;
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
        // how do this in List without array??
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        // how do this in List without array??
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // how do this in List without array??
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size){
            System.out.println("Incorrect fromIndex or toIndex.");
            return null;
        }
        MyList list = new MyList();
        Iterator it = iterator();
        int i = fromIndex;
        while(i > 1){
            it.next();
            i--;
        }
        for (int j = fromIndex; j < toIndex; j++) {
            list.add(it.next());
        }
        return list;
    }

}

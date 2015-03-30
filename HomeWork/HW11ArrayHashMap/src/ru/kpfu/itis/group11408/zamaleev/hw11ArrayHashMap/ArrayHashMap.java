package ru.kpfu.itis.group11408.zamaleev.hw11ArrayHashMap;

import java.util.*;

public class ArrayHashMap<K, V> implements Map<K, V>{
	private List<Entry<K, V>>[] arr;
	private int size;
	
	private class MyEntry<K,V> implements Entry<K, V>{
		private K key;
		private V value;

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			V tmpV = this.value;
			this.value = value;
			return tmpV;
		}
		
	}
	
	public ArrayHashMap(int n) {
		arr = (List<java.util.Map.Entry<K, V>>[]) new ArrayList<?>[n];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size > 0;
	}

	@Override
	public boolean containsKey(Object key) {
		int i = key.hashCode() % arr.length;
		return !arr[i].isEmpty();
	}

	@Override
	public boolean containsValue(Object value) {
		boolean found = false;
		int i = 0;
		while (!found && (i < arr.length)) {
			found = arr[i].contains(value);
			i++;
		}
		return found;
	}

	@Override
	public V get(Object key) {
        if (containsKey(key)){
            int i = key.hashCode() % arr.length;
            return arr[i].get(0).getValue();
        }
        return null;
	}

	@Override
	public V put(K key, V value) {
        int i = key.hashCode() % arr.length;
        if (containsKey(key)){
            arr[i].add(new MyEntry<K, V>());
            return arr[i].get(0).getValue();
        }
        arr[i].add(new MyEntry<K, V>());
		return null;
	}

	@Override
	public V remove(Object key) {
        int i = key.hashCode() % arr.length;
        int last = -1;
        Iterator it = arr[i].iterator();
        while (it.hasNext()){
            last++;
            it.next();
        }
        arr[i].remove(last);
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		//как обращаться к элементам Map???
	}

	@Override
	public void clear() {
        for (int i = 0; i < arr.length; i++) {
            while (!arr[i].isEmpty()){
                arr[i].remove(0);
            }
        }
    }

	@Override
	public Set<K> keySet() {
		//создавать внутренний класс Set<K>???
		return null;
	}

	@Override
	public Collection<V> values() {
		//создавать
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
        //создавать внутренний класс Set<java.util.Map.Entry<K, V>>???
		return null;
	}

}

package ru.kpfu.itis.group11408.zamaleev.hw7Generik;

public class Pair <T extends Comparable<T>, E extends Comparable<E>>{
	
	private T first;
	
	private E second;

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public E getSecond() {
		return second;
	}

	public void setSecond(E second) {
		this.second = second;
	}
	
	public void doSome() {
		first.compareTo(first);
	}
	
	public <S extends Comparable> S getMax(S[] array) {
		return null;
	}
	
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>();
		pair.setFirst("Hello");
		pair.setSecond(9);
	}
	

}

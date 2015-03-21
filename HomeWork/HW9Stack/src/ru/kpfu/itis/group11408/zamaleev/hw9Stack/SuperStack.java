package ru.kpfu.itis.group11408.zamaleev.hw9Stack;

public interface SuperStack <T> extends Iterable<T> {
	
	T pop();
	
	T peek();
	
	void push(T t);
	
	int size();
	
	boolean isEmpty();

}

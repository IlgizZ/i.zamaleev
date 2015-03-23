package ru.kpfu.itis.group11408.zamaleev.hw10Queue;

public interface MyQueue <T> {
	
	void offer(T t);
	
	T peek();
	
	T poll();
	
	int size();
	
	boolean isEmpty();
}

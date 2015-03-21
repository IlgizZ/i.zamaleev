package ru.kpfu.itis.group11408.zamaleev.hw9Stack;

import java.util.Iterator;

public class ArrayStack<T> implements SuperStack<T> {
	private final int MAX_LENGTH = 20;
	private Object[] stack = new Object [MAX_LENGTH]; 
	private int length, i = 0;
		
	class MyIterator implements Iterator<T>{
		
		@Override
		public boolean hasNext() {
			if (isEmpty()) return false;
			else {
				if ((i < MAX_LENGTH) && (stack[i] != null)){
					i++;
					return true;
				}
				return false;				
			}
		}

		@Override
		public T next() { 
			if (!isEmpty()){
				return (T) stack[i -1];
			}
			return null;
		}

	}
	
	@Override
	public MyIterator iterator() {
		i = 0;
		return new MyIterator();
	}
	
	@Override
	public int size() {
		return this.length;
	}

	@Override
	public boolean isEmpty() {		
		return stack[0] == null;
	}

	@Override
	public T pop() {
		if (isEmpty()){
			System.out.println("Nel'zya");
			return null;
		} else {
			length--;
			T t = (T) stack[this.length];
			stack[this.length] = null;
			return t;
		}
	}

	@Override
	public T peek() {
		if (this.isEmpty()){
			System.out.println("Nel'zya");
			return null;
		} else 	return (T) stack[this.length - 1];
		
	}
	
	@Override
	public void push(T t) {
		if (length + 1 <= MAX_LENGTH){
			stack[length] = t;
			length++;
		} else {
			System.out.println("Nel'zya");
		}
	}
}

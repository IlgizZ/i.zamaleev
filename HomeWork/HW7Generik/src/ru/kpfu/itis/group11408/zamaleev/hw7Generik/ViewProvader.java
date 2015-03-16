package ru.kpfu.itis.group11408.zamaleev.hw7Generik;

public interface ViewProvader<T> {
	
	int getColumnCount();
	String getLabel(T o1, int n);
	String getHeader(int n);
}

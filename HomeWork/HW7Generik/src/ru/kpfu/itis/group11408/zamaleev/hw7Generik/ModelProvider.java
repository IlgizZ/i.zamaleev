package ru.kpfu.itis.group11408.zamaleev.hw7Generik;

import java.util.Comparator;

public interface ModelProvider <T>{
	
	Comparator <T> getComparator();
	T[] getElements();

}

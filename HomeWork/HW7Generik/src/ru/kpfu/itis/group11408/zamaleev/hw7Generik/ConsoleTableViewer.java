package ru.kpfu.itis.group11408.zamaleev.hw7Generik;

import java.util.Arrays;
import java.util.Formatter;

public class ConsoleTableViewer <T>{
	
	private ModelProvider<T> model;
	
	private ViewProvader<T> view;
	
	public void show(){
		T[] elements = model.getElements();
		Arrays.sort(elements, model.getComparator());
		int columnCount = view.getColumnCount();
		Formatter f = new Formatter();
		for (int i = 0; i < columnCount; i++) {
            f = new Formatter();
			f.format("%-10.10s", "----------");
			System.out.print(f);
		}
		System.out.println();
		for (int i = 0; i < columnCount; i++) {
            f = new Formatter();
			f.format("%-10.10s", "|" + view.getHeader(i));
			System.out.print(f);
		}
		System.out.println("|");
		for (int i = 0; i < columnCount; i++) {
            f = new Formatter();
			f.format("%-10.10s", "----------");
			System.out.print(f);
		}
		System.out.println();
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < columnCount; j++) {
                f = new Formatter();
				f.format("%-10.10s","|" + view.getLabel(elements[i], j));
				System.out.print(f);
			}
            System.out.println();
			for (int j = 0; j < columnCount; j++) {
                f = new Formatter();
				f.format("%-10.10s", "----------");
				System.out.print(f);
			}
			System.out.println();
		}		
	}
	
	public ConsoleTableViewer(ModelProvider<T> model, ViewProvader<T> view) {
		super();
		this.model = model;
		this.view = view;
	}
	
}

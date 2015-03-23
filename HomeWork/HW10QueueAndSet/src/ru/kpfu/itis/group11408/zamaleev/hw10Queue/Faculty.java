package ru.kpfu.itis.group11408.zamaleev.hw10Queue;

public class Faculty {
	private Student[] array;
	
	Faculty(int length, String facultyName){
		this.array = new Student[length];
		for (int i = 0; i < array.length; i++) {
			int grade = 1 + (int)(Math.random() * 100);
			int year = 1995 + (int)(Math.random() * 3.0);
			String name = "Student " + i + " from " + facultyName;
			array[i] = new Student(grade, year, name, facultyName);			
		}
	}
	
	Student getIllStudent(){
		int i = (int)(Math.random() * array.length);
		while (array[i].isIll()){
			i = (int)(Math.random() * array.length);
		}
		array[i].setIll(true);
		System.out.println(array[i] + " is ill and go to Medicine queue!");
		return array[i];
	}
}

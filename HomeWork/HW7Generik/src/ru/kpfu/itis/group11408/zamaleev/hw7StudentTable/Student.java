package ru.kpfu.itis.group11408.zamaleev.hw7StudentTable;

public class Student {
	private String name;
	private int year;
	private double grade;
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public double getGrade() {
		return grade;
	}

    public Student(String name, int year, double grade) {
		super();
		this.name = name;
		this.year = year;
		this.grade = grade;
	}
}

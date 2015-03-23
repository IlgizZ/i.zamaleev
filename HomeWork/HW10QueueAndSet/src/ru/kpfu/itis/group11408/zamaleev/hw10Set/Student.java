package ru.kpfu.itis.group11408.zamaleev.hw10Set;

public class    Student {
	private int grade;
	private int year;
	private String name;
	private String facultyName;
	private boolean isIll;
	
	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Student(int grade, int year, String name, String facultyName) {
		this.grade = grade;
		this.year = year;
		this.name = name;
		this.facultyName = facultyName;
		this.isIll = false;
	}
	
	
	
	/*public static void main(String[] args){
		Student[] student11408 = new Student[32];
		for (int i = 0; i < student11408.length; i++){
			int grade = 1 + (int)(Math.random() * 100);
			int year = 1994 + (int)(Math.random() * 3.0);
			String name = "Student " + i;
			student11408[i] = new Student(grade, year, name);
		}
		student11408[30] = new Student(1,0,null);
		StudentHelper helper = new StudentHelper();
		mySort(student11408, helper.getNameComparated());
		System.out.println(Arrays.toString(student11408));
		mySort(student11408, helper.getGradeComparated());
		System.out.println(Arrays.toString(student11408));
		mySort(student11408, helper.getYearComparated());
		System.out.println(Arrays.toString(student11408));
	}*/

	public boolean isIll() {
		return isIll;
	}

	public void setIll(boolean isIll) {
		this.isIll = isIll;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", year=" + year + ", grade=" + grade
				 + "]";
	}
	
	/*public static void mySort(Object[] o, Comparator c){
		for (int i = 0; i < o.length; i ++){
			for (int j = 1; j < o.length - i; j++){
				if (c.compare(o[j - 1], o[j]) > 0){
					Object tmp = o[j - 1];
					o[j - 1] = o[j];
					o[j] = tmp;					
				}
			}
		}
	}*/
}

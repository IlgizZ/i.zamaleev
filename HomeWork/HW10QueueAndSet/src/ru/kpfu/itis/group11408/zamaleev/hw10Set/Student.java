package ru.kpfu.itis.group11408.zamaleev.hw10Set;

public class    Student implements Comparable{

	private String name;
	private String facultyName;
	private int grade;
	private int year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Student(String name, String facultyName, int grade, int year) {
		this.name = name;
		this.facultyName = facultyName;
		this.grade = grade;
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Student student = (Student) o;

		if (grade != student.grade) return false;
		if (year != student.year) return false;
		if (!name.equals(student.name)) return false;
		return facultyName.equals(student.facultyName);

	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + facultyName.hashCode();
		result = 31 * result + grade;
		result = 31 * result + year;
		return result;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", facultyName='" + facultyName + '\'' +
				", grade=" + grade +
				", year=" + year +
				'}';
	}

	@Override
	public int compareTo(Object o) {
		if (equals(o)){
			return 0;
		} else if (o instanceof Student){
			return getGrade() - ((Student) o).getGrade();
		}
		return 1;
	}
}

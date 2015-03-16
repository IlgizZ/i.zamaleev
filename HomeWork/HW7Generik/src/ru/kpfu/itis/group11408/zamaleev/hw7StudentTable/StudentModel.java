package ru.kpfu.itis.group11408.zamaleev.hw7StudentTable;

import java.util.Comparator;

import ru.kpfu.itis.group11408.zamaleev.hw7Generik.ModelProvider;

public class StudentModel implements ModelProvider<Student> {

	@Override
	public Comparator<Student> getComparator() {
		return new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if ((o1 != null) && (o2 != null)) {
					return o1.getName().compareTo(o2.getName());
				} else if ((o1 == null) && (o2 == null)){
					return 0;
				} else if (o1 == null) return 0;
				return 0;
			}
		};
	}

	@Override
	public Student[] getElements() {
		int r = (int) (Math.random() * 20 + 11);
		Student[] result = new Student[r];
		for (int i = 0; i < result.length; i++) {
			result[i] = new Student("Student" + i, (int)(Math.random() * 3 + 1995), 
					(int)(Math.random() * 45 + 56 ));
		}
		return result;
	}

}

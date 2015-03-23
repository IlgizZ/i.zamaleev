package ru.kpfu.itis.group11408.zamaleev.hw10Queue;

import java.util.Comparator;

public class StudentHelper {

	Comparator getGradeComparated(){
		return new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				if ((o1 instanceof Student) && (o2 instanceof Student)){
					if (((Student)o1).getGrade() > ((Student)o2).getGrade()){
						return (1);						
					} else if (((Student)o1).getGrade() < ((Student)o2).getGrade()){
						return (-1);						
					} else {
						return(0);
					}
				} else if (o1 instanceof Student){
					return 1;
				} else if (o2 instanceof Student){
					return -1;
				} else return 0;
			}
		};		
	}

	Comparator getYearComparated(){
		return new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if ((o1 instanceof Student) && (o2 instanceof Student)){
					if (((Student)o1).getYear() > ((Student)o2).getYear()){
						return (1);						
					} else if (((Student)o1).getYear() < ((Student)o2).getYear()){
						return (-1);						
					} else {
						return(0);
					}
				} else if (o1 instanceof Student){
					return 1;
				} else if (o2 instanceof Student){
					return -1;
				} else return 0;
			}
		};
		
	}
	Comparator getNameComparated(){
		return new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if ((o1 instanceof Student) && (o2 instanceof Student)){
					if (((Student)o1).getName() == null){
						if  (((Student)o2).getName() == null){
							return 0;
						} else return -1;
					} else if (((Student)o2).getName() == null){
						return 1;
					} else return ((Student)o1).getName().compareTo(((Student)o2).getName()); 	
				} else if (o1 instanceof Student){
					return 1;
				} else if (o2 instanceof Student){
					return -1;
				} else return 0;
			}
		};
	}
}

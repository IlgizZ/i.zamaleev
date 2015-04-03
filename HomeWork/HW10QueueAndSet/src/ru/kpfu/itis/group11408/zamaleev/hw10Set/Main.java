package ru.kpfu.itis.group11408.zamaleev.hw10Set;

import java.util.Iterator;

/**
 * Created by Ilgiz on 23.03.2015.
 */
public class Main {

    public static void main(String[] args){
        SortedSet<Student> set = new SortedSet<>();
        Student[] arr = new Student[10];
        for (int i = 0; i < 10; i++) {
            String name = "Student " + i;
            String facultyName = "ITIS";
            int grade = 1 + (int)(Math.random() * 100);
            int year = 1995 + (int)(Math.random() * 3.0);
            arr[i] = new Student(name, facultyName, grade, year);
            set.add(arr[i]);
        }
        for (Student s : set){
            System.out.println(s);
        }
        for (Student s : arr){
            if (s.getGrade() < 56){
                System.out.println("remove bad student (grade < 56) " + s);
                set.remove(s);
            }
        }
        for (Student s : set){
            System.out.println(s);
        }
    }
}

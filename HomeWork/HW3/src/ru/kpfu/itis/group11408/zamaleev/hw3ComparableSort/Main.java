package ru.kpfu.itis.group11408.zamaleev.hw3ComparableSort;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Electronic[] a = new Electronic[20];
        for (int i = 0; i < a.length; i++) {
            int r = (int) (Math.random() * 3.0);
            if (r == 0) {
                double cost = 3000 + Math.random() * 30000;
                int year = 2000 + (int) (Math.random() * 16.0);
                double grade = 1 + Math.random() * 5;
                double weight = 100 + Math.random() * 201;
                a[i] = new Phones(cost, year, grade, weight);
            } else if (r == 1) {
                double cost = 10000 + Math.random() * 30000;
                int year = 2000 + (int) (Math.random() * 16.0);
                double grade = 1 + Math.random() * 5;
                double weight = 2000 + Math.random() * 2010;
                int cpuSpeed = 2 + (int) (Math.random() * 16.0);
                int memory = 80 + (int) (Math.random() * 1001.0);
                a[i] = new Computers(cost, year, grade, weight, cpuSpeed, memory);
            } else {
                double cost = 10000 + Math.random() * 30000;
                int year = 2000 + (int) (Math.random() * 16.0);
                double grade = 1 + Math.random() * 5;
                double weight = 2000 + Math.random() * 2010;
                int diag = 10 + (int) (Math.random() * 45.0);
                a[i] = new TV(cost, year, grade, weight, diag);
            }
        }
        Arrays.sort(a);
        for (int i = a.length - 1; i > -1; i--) {
            System.out.println(a[i]);
        }
    }
}

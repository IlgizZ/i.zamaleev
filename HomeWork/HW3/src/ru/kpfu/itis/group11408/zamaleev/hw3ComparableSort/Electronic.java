package ru.kpfu.itis.group11408.zamaleev.hw3ComparableSort;

public class Electronic implements Comparable {
    private double cost;
    private int year;
    private double grade;
    private double weight;
    protected String name;

    public Electronic() {
        this(0, 0, 0, 0);
    }

    public Electronic(double cost, int year, double grade, double weight) {
        this.cost = cost;
        this.year = year;
        this.grade = grade;
        this.weight = weight;
        this.name = "electro";
    }

    protected double getRate() {
        return 100000000 / this.cost + this.year + this.grade * 1000 + 100 / this.weight;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Electronic) {
            if (this.getRate() < ((Electronic) o).getRate()) {
                return -1;
            } else if (this.getRate() > ((Electronic) o).getRate()) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.name + "\t" + (int) getRate();
    }
}

package ru.kpfu.itis.group11408.zamaleev.hw3ComparableSort;

public class Phones extends Electronic {

    public Phones() {
        super(0, 0, 0, 0);
    }

    public Phones(double cost, int year, double grade, double weight) {
        super(cost, year, grade, weight);
        this.name = "Phone   ";
    }

}

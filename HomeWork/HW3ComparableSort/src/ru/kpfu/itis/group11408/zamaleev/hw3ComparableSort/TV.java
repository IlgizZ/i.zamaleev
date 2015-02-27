package ru.kpfu.itis.group11408.zamaleev.hw3ComparableSort;

public class TV extends Electronic {
    int diag;

    public TV() {
        this(0, 0, 0, 0, 0);
    }

    public TV(double cost, int year, double grade, double weigh, int diag) {
        super(cost, year, grade, weigh);
        this.name = "TV      ";
        this.diag = diag;
    }

    @Override
    protected double getRate() {
        // TODO Auto-generated method stub
        return super.getRate() + this.diag * 50;
    }
}

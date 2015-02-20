package ru.kpfu.itis.group11408.zamaleev.hw3ComparableSort;

public class Computers extends Electronic {
    private int cpuSpeed;
    private int memory;

    @Override
    protected double getRate() {

        return super.getRate() + cpuSpeed * 1000 + memory * 10;
    }

    public Computers() {
        this(0, 0, 0, 0, 0, 0);
    }

    public Computers(double cost, int year, double grade, double weigh, int cpuSpeed, int memory) {
        super(cost, year, grade, weigh);
        this.name = "Computer";
        this.cpuSpeed = cpuSpeed;
        this.memory = memory;
    }
}

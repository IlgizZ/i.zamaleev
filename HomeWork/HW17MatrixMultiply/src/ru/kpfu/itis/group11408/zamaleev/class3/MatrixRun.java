package ru.kpfu.itis.group11408.zamaleev.class3;

/**
 * Created by Ильгиз on 26.04.2015.
 */
public class MatrixRun implements Runnable {
    private int from;
    private int to;

    public MatrixRun(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = from; i < to ; i++) {

        }
    }
}

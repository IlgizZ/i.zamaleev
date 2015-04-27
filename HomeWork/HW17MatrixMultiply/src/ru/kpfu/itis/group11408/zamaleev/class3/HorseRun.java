package ru.kpfu.itis.group11408.zamaleev.class3;

/**
 * Created by Ильгиз on 25.04.2015.
 */
public class HorseRun implements Runnable {
    private static final int FINISH = 100;
    private int dist;
    private String name;

    public HorseRun(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (dist < FINISH){
            System.out.println(name +" now run: " + dist);
            dist += 1 + (int)(Math.random() * 5);
            Thread.yield();
            try {
                Thread.sleep(500l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name +" has just finished run.");
    }
}

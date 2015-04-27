package ru.kpfu.itis.group11408.zamaleev.class3;

/**
 * Created by Ильгиз on 25.04.2015.
 */
public class Main {
    public static void main(String[] args){
        Thread horse1 = new Thread(new HorseRun("Horse 1"));
        Thread horse2 = new Thread(new HorseRun("Horse 2"));
        Thread horse3 = new Thread(new HorseRun("Horse 3"));
        Thread horse4 = new Thread(new HorseRun("Horse 4"));
        Thread horse5 = new Thread(new HorseRun("Horse 5"));
        horse1.start();
        horse2.start();
        horse3.start();
        horse4.start();
        horse5.start();
    }
}

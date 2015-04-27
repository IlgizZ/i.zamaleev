package ru.kpfu.itis.group11408.zamaleev.class2;

import java.io.FileNotFoundException;

/**
 * Created by Ilgiz on 14.04.2015.
 */
public class Main {

    public static void main(String[] args){
        try {
            EmailFinder ef = new EmailFinder("in.txt", "");
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}

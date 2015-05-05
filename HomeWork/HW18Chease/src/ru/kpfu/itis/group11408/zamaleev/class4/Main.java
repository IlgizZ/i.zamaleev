package ru.kpfu.itis.group11408.zamaleev.class4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Ilgiz on 04.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        int n = 0;
        Chease chease = null;
        if (args.length != 1) {
            System.out.println("Write correct input file.");
        } else{
            try (Scanner sc = new Scanner(new FileInputStream(args[0]))) {
                n = sc.nextInt();
                sc.nextLine();
                char[][] a = new char[n][n];
                for (int i = 0; i < n; i++) {
                    String s = sc.nextLine();
                    for (int j = 0; j < n; j++) {
                        a[i][j] = s.charAt(j);
                    }
                }
                chease = new Chease(n, a);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            chease.findWay();
        }
    }
}

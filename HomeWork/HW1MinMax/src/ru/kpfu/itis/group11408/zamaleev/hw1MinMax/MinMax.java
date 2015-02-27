package ru.kpfu.itis.group11408.zamaleev.hw1MinMax;

import java.util.Scanner;

/**
 * Created by on 09.02.2015.
 */
public class MinMax {
    public static void min(int [] m, int space){
        for (int i = 0; i < m.length; i +=  (2 * space)){
            if (m[i] > m[i + space]){
                m[i] ^= m[i + space];
                m[i + space] ^= m[i];
                m[i] ^= m[i + space];
            }
        }
        if (2 * space < m.length){
            space *= 2;
            min(m, space);
        }
    }
    public static void max(int [] m, int space){
        for (int i = m.length - 1; i > -1; i -=  (2 * space)){
            if (m[i] < m[i - space]) {
                m[i] ^= m[i - space];
                m[i - space] ^= m[i];
                m[i] ^= m[i - space];
            }
        }
        if (2 * space < m.length){
            space *= 2;
            max(m, space);
        }
    }
    public static int[] minMax(int [] m){
        int [] result = new int[2];
        min(m, 1);
        max(m, 2);
        result[0] = m[0];
        result[1] = m[m.length -1];
        return result;
    }
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        if (sc.hasNextInt()){
            n = sc.nextInt();
        } else {
            System.out.println("Reading error");
        }
        int [] a = new int [n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                a[i] = sc.nextInt();
            } else {
                System.out.println("Reading error");
            }
        }
        for(int i : minMax(a)){
            System.out.println(i);
        }
    }
}

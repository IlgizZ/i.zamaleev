package ru.kpfu.itis.group11408.zamaleev.hw1Palindrom;

import java.util.Scanner;

/**
 * Created by on 09.02.2015.
 */
public class Palindrom {
    boolean wordIsPalindrom = true;
    String s;
    public void check(int n){
        int size = this.s.length() - 1;
        if ((n * 2 <= size) && (this.s.charAt(n) == this.s.charAt(size - n))){
            this.check(n + 1);
        }else if (n * 2 <= size){
            this.wordIsPalindrom = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Palindrom palindrom = new Palindrom();
        palindrom.s = sc.nextLine();
        palindrom.check(0);
        if (palindrom.wordIsPalindrom){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
}

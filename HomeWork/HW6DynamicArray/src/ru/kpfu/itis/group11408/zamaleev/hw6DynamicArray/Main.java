package ru.kpfu.itis.group11408.zamaleev.hw6DynamicArray;

/**
 * Created by Ilgiz on 13.03.2015.
 */
public class Main {

    public static void main(String[] args){
        String[] s = new String[11];
        for (int i = 0; i < s.length; i++) {
            s[i] = "" + i;
        }
        DynamicArray d = new DynamicArray(s);
        d.addElement(s);
        String m = "MM";
        d.insertElement(m, 10);
        d.insertElement(m, 16);
        System.out.println((String) d.getElement(17));
        System.out.println((String) d.getElement(10));
        System.out.println(d.getSize());
        d.removeElement(m);
        System.out.println(d.getSize());
    }
}

package ru.kpfu.itis.group11408.zamaleev.hw3FastMultiply;

public class FastMultiply {

    public static void main(String args[]){

        Number x = new Number(2147483648l);
        Number y = new Number(2147483649l);
        long n = System.currentTimeMillis();
        //for (int i = 0; i < 100; i++) {
            System.out.println(x.fastMultiply(y));
        //}
        System.out.println(System.currentTimeMillis() - n);
    }
}

package ru.kpfu.itis.group11408.zamaleev.class1;

import java.io.*;

/**
 * Created by Ильгиз on 14.04.2015.
 */
public class Do512MbFile1 {

    public static void main(String[] args){
        /*try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("in.txt")))) {
            for (int i = 0; i < 2000; i++) {
                for (int j = 0; j < 100; j++) {
                    writer.write((int) (Math.random() * 101) + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        long start = System.currentTimeMillis();
//        boolean b = true;
//        for (int i = 0; i < 2000; i++) {
//            for (int j = 0; j < 100000; j++) {
//                if (b){
//                    b = !b;
//                } else {
//                    b = !b;
//                }
//            }
//        }
        int[] b = new int[101];
        int index = 0;
        try(FileInputStream fis = new FileInputStream("568MBIn.txt")){
            final int BUFFER_SIZE = 134217728;//128 MB
            byte[] buf = new byte[BUFFER_SIZE];
            int len;
            while ((len = fis.read(buf)) != -1){
                for (int i = 0; i < len; i++) {
                    if (buf[i] == 32){
                        b[index]++;
                        index = 0;
                    } else {
                        index = 10 * index + buf[i] - 48;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
        try (PrintWriter writer =  new PrintWriter(new FileOutputStream("out.txt"))) {
            for (int i = 0; i < b.length; i++) {
                if (b[i] > 0){
                    for (int j = 0; j < b[i]; j++) {
                        writer.print(i);
                        writer.print(" ");
                    }
                    writer.flush();
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("out.txt")))) {
            for (int i = 0; i < b.length; i++) {
                if (b[i] > 0){
                    for (int j = 0; j < b[i]; j++) {
                        writer.write(i + " ");
                        /*
                        writer.write(i);
                        writer.write(" ");
                         *//*
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}

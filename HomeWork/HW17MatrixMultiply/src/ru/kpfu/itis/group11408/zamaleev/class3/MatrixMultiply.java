package ru.kpfu.itis.group11408.zamaleev.class3;


import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by ������ on 25.04.2015.
 */
public class MatrixMultiply {
    private int n;
    private int[][] a;
    private int[][] b;
    private int[][] c;
    private static LinkedList<Boolean> aliveThreads;


    private class MatrixRan implements Runnable{
        private int from;
        private int to;
        private int threadNum;

        public MatrixRan(int from, int to, int threadNum) {
            this.from = from;
            this.to = to;
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            for (int j = from; j < to; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        c[j][k] += a[j][l] * b[l][k];
                    }
                }
            }
            aliveThreads.set(threadNum, new Boolean(false));
        }
    }

    public MatrixMultiply(int n, String m1, String m2) {
        this.n = n;
        try {
            if (m1 == null || m2 == null)
                throw new MatrixMultiplyException("File name haven't been set");
            File f1 = new File(m1);
            File f2 = new File(m2);
            if (!(f1.isFile() && f2.isFile()))
                throw new MatrixMultiplyException("File can't be found");
            a = new int[n][n];
            b = new int[n][n];
            try(Scanner sc = new Scanner(new FileInputStream(f1))) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sc.hasNextInt())
                            a[i][j] = sc.nextInt();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try(Scanner sc = new Scanner(new FileInputStream(f2))) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        b[i][j] = sc.nextInt();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MatrixMultiplyException e) {
            e.printStackTrace();
        }

    }

    public void printResult(String fileOut) throws MatrixMultiplyException {
        if (fileOut.equals(" ")){
            throw new MatrixMultiplyException("File name haven't been set");
        }
        try (PrintWriter writer =  new PrintWriter(new FileOutputStream(fileOut))) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    writer.print(c[i][j]);
                    writer.print(" ");
                }
                writer.print("\n");
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void threadMultiply(int m) throws MatrixMultiplyException {
        if (a == null || b == null){
            throw new MatrixMultiplyException("Matrix haven't been set");
        }
        c = new int[n][n];
        aliveThreads = new LinkedList<Boolean>();
        int step = n / m;
        long start = System.currentTimeMillis();
        for (int i = 0; i < m; i++) {
            int from = i * step;
            int to = (i + 1) * step;
            if (i == m - 1){
                to = n;
            }
            int threadNum = aliveThreads.size();
            aliveThreads.add(new Boolean(true));
            Thread thMult = new Thread(new MatrixRan(from, to, threadNum));
            thMult.start();
            while (thMult.isAlive()){

            }
        }
        while( aliveThreads.contains(new Boolean(true))){

        }
        start = System.currentTimeMillis() - start;
        System.out.println(m + " threads time: " + start);
    }

}

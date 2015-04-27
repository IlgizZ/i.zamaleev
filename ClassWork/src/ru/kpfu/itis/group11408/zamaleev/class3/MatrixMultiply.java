package ru.kpfu.itis.group11408.zamaleev.class3;


import java.io.*;
import java.util.Scanner;

/**
 * Created by ������ on 25.04.2015.
 */
public class MatrixMultiply {
    private int n;
    private int[][] a;
    private int[][] b;
    private int[][] c;
    private int from;
    private int to;

    public MatrixMultiply(int n, String m1, String m2) {
        this.n = n;
        try {
            if (m1 == null || m2 == null)
                throw new MatrixMultiplyException("File name haven't been set");
            File f1 = new File(m1);
            File f2 = new File(m2);
            if (!(f1.isFile() && f2.isFile()))
                throw new MatrixMultiplyException("File haven't been found");
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

    public void printResult(){
        try (PrintWriter writer =  new PrintWriter(new FileOutputStream("MatrixOut.txt"))) {
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
        int step = (int)(n / m);
        for (int i = 0; i < m; i++) {
            from = i * step;
            to = (i + 1) * step;
            if (i == m - 1){
                to = n;
            }
            Thread thMult = new Thread(new Runnable() {
                @Override
                public void run() {
                    int f = from;
                    int t = to;
                    for (int j = f; j < t; j++) {
                        for (int k = 0; k < n; k++) {
                            for (int l = 0; l < n; l++) {
                                c[j][k] += a[j][l] * b[l][k];
                            }
                        }
                    }
                }
            });
            thMult.start();
        }
    }
    public static void main(String[] args){
        MatrixMultiply m = new MatrixMultiply(3, "Matrix1.txt", "Matrix2.txt");
        try {
            m.threadMultiply(3);
            m.printResult();
        } catch (MatrixMultiplyException e) {
            e.printStackTrace();
        }

    }
}

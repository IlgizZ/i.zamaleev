package ru.kpfu.itis.group11408.zamaleev.class3;

/**
 * Created by Ильгиз on 25.04.2015.
 */
public class Main {
    public static void main(String[] args){
        try {
            if (args.length != 4)
                throw new MatrixMultiplyException("Incorrect input!!");
            int n = 0;
            int m = 0;
            try{
                n = Integer.valueOf(args[0]);
                m = Integer.valueOf(args[1]);
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
            String m1 = args[2];
            String m2 = args[3];
            MatrixMultiply matrixs = new MatrixMultiply(n, m1, m2);
            try {
                matrixs.threadMultiply(m);
                matrixs.printResult("MatrixOut.txt");
            } catch (MatrixMultiplyException e) {
                e.printStackTrace();
            }
        } catch (MatrixMultiplyException e) {
            e.printStackTrace();
        }
    }
}

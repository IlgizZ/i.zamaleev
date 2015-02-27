package ru.kpfu.itis.group11408.zamaleev.hw4ConvexPolygon;

/**
 * Created by Ilgiz on 27.02.2015.
 */
public class Main {
    public static void main(String[] args){
        double [] x = {0, -4, -5, -5, -2, 4, 6, -1};
        double [] y = {6, 5, 2, -1, -4, -3, 1, 1};
        Polygon p = new Polygon(x, y);
        System.out.println(p.isConvex());
    }
}

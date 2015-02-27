package ru.kpfu.itis.group11408.zamaleev.hw4ConvexPolygon;

/**
 * Created by Ilgiz on 27.02.2015.
 */
public class Polygon {
    double x[];
    double y[];

    Polygon(double[] x, double[] y){
        this.x = new double[x.length];
        this.y = new double[y.length];
        for (int i = 0; i < x.length; i++){
            this.x[i] = x[i];
        }
        for (int i = 0; i < y.length; i++){
            this.y[i] = y[i];
        }
    }

    boolean isConvex(){
        boolean result = true;
        double sign = Math.signum(x[x.length - 1] * y[0] - x[0] * y[x.length - 1]);
        for (int i = 1; i < x.length; i++){
            if (sign != Math.signum(x[i - 1] * y[i] - x[i] * y[i - 1])){
                return false;
            }
        }
        return result;
    }
}

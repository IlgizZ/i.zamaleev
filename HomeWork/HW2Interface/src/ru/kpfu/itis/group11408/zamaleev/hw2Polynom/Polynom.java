package ru.kpfu.itis.group11408.zamaleev.hw2Polynom;


public class Polynom {
    double [] coefficient;

    public Polynom(){
        this.coefficient = new double[0];
    }

    public Polynom(double[] a) {
        this.coefficient = new double[a.length];
        for (int i = 0; i < a.length; i++){
            this.coefficient[i] = a[i];
        }
       this.deleteNull();
    }

    public Polynom(String s) {
        for (int j = 0; j < s.length();){
            // i - value position start
            int i = j;
            while ((i < s.length()) && (s.charAt(i) != 'x')) {
                i++;
            }
            String value = s.substring(j, i);
            if (i == j){
                value = "1";
            };
            // i - degree position start
            i += 2;
            int end = i + 1;
            while ((end < s.length()) && (s.charAt(end) != '+')){
                end++;
            }
            String degree;
            if (end <= s.length()){
                degree = s.substring(i, end);
            } else {
                degree = "0";
            }
            int iDegree = Integer.parseInt(degree);
            double dValue = Double.parseDouble(value);
            if (j == 0){
                this.coefficient = new double[iDegree + 1];
            }
            this.coefficient[iDegree] = dValue;
            j = end + 1;
        }
        this.deleteNull();
    }

    public void add(Polynom a){
        this.doOneSize(a.coefficient);
        for (int i = 0; i < a.coefficient.length; i++){
            this.coefficient[i] += a.coefficient[i];
        }
        this.deleteNull();
    }

    public void minus(Polynom a){
        for (int i = 0; i < a.coefficient.length; i++){
            a.coefficient[i] *= -1;
        }
        this.add(a);
    }

    public void multiply(Polynom a){
        double[] tmp = new double[this.coefficient.length + a.coefficient.length];
        for (int i = 0; i < this.coefficient.length; i ++){
            for (int j = 0; j < a.coefficient.length; j++){
                tmp[i + j] += this.coefficient[i] * a.coefficient[j];
            }
        }
        this.coefficient = tmp;
    }

    private void deleteNull(){
        int newLength = this.coefficient.length - 1;
        while (this.coefficient[newLength] == 0){
            newLength--;
        }
        if (newLength < this.coefficient.length - 1 ){
            double [] tmp = new double[newLength + 1];
            for (int i = 0; i <= newLength; i++){
                tmp[i] = this.coefficient[i];
            }
            this.coefficient = new double[newLength + 1];
            for (int i = 0; i <= newLength; i++){
                this.coefficient[i] = tmp[i];
            }
        }
    }

    private void doOneSize(double [] m){
        if (this.coefficient.length < m.length){
            double [] tmp = new double[this.coefficient.length];
            for (int i = 0; i < this.coefficient.length; i++){
                tmp[i] = this.coefficient[i];
            }
            this.coefficient = new double[m.length];
            for (int i = 0; i < tmp.length; i++){
                this.coefficient[i] = tmp[i];
            }
        }

    }

    @Override
    public String toString() {
        String s = "";
        int length = this.coefficient.length - 1;
        // add first coefficient
        if (this.coefficient[length] != 0){
            s += this.coefficient[length] + "x^" + length;
        }
        // add mid coefficient
        for (int i = length - 1; i > 0; i --){
            if (this.coefficient[i] > 0){
                s += "+" + this.coefficient[i] + "x^" + i;
            } else if (this.coefficient[i] < 0){
                s += this.coefficient[i] + "x^" + i;
            }
        }
        // add last coefficient
        if (this.coefficient[0] > 0){
            s +=  "+" +  this.coefficient[0];
        } else if (this.coefficient[0] < 0){
            s +=  this.coefficient[0];
        }
        return s;
    }

    public static void main(String [] args){
        double [] m = {2, 0, 0, 0, 3, 4}; // 4х^5 + 3x^4 + 2
        Polynom a = new Polynom(m);
        double [] m1 = {-2, 0, 0, 0, 0, -4};
        Polynom b = new Polynom(m1);
        a.add(b);
        Polynom c = new Polynom("5x^5+x^2+15");
        Polynom d = new Polynom(new Polynom(new double[]{1,0,1}).toString());
        System.out.println(a.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        d.multiply(a);
        System.out.println("b: " + b.toString());
        System.out.println(d.toString());
    }
}

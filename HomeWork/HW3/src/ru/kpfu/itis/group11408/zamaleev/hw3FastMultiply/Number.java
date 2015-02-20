package ru.kpfu.itis.group11408.zamaleev.hw3FastMultiply;

public class Number {
    public long a;
    public long b;
    public long n;

    Number(){
        this(0);
    }

    Number(long x){
        long tmp = x;
        int length = 0;
        while (x > 0){
            length++;
            x >>= 1;
        }
        length >>= 1;
        this.n = length;
        this.a = tmp >> length;
        this.b = tmp & ((1l << length ) - 1);
    }

    public long fastMultiply(Number y){
        return (this.a * y.a * (1l << 2 * this.n) + (1l << this.n) * ((this.a - this.b) * (y.b - y.a) + this.a * y.a + this.b * y.b) + this.b * y.b);
    }
}

package ru.kpfu.itis.group11408.zamaleev.hw6DynamicArray;

/**
 * Created by Ilgiz on 13.03.2015.
 */
public class DynamicArray {
    private Object[] arr;
    private int length;

    public DynamicArray() {
        this.length = 0;
        this.arr = new Object[10];
    }

    public DynamicArray(Object[] arr) {
        this();
        for (int i = 0; i < arr.length; i++) {
            this.addElement(arr[i]);
        }
    }

    //- добавляет элемент в список

    public void addElement(Object o) {
        this.length++;
        if (this.length > this.arr.length){
            Object[] tmpArr = new Object[this.arr.length + 5];
            for (int i = 0; i < this.arr.length; i++) {
                tmpArr[i] = this.arr[i];
            }
            tmpArr[this.length - 1] = o;
            this.arr = tmpArr;
        } else {
            this.arr[this.length - 1] = o;
        }
    }

    // - добавляет элемент в список с нужным индексом

    public void insertElement(Object o, int n){
        if (n < 0){

        }
        this.length++;
        int k = this.arr.length + 5;
        if (n > arr.length){
            k = n + 5 - n % 5;
        }
        if (n > this.arr.length){
            n--;
            Object[] tmpArr = new Object[k];
            System.arraycopy(this.arr, 0, tmpArr, 0, n - 1);
            tmpArr[n] = o;
            System.arraycopy(this.arr, n, tmpArr, n + 1, this.arr.length - n);
            this.arr = tmpArr;
        } else {
            n--;
            for (int i = this.arr.length - 1 ; i > n ; i--) {
                this.arr[i] = this.arr[i - 1];
            }
            this.arr[n] = o;
        }
    }

    // - удаляет элемент из списка

    public void removeElement(Object o){
        int i = 0;
        while ((i < this.arr.length) && (!this.arr[i].equals(o)))
            i++;
        if (i == this.arr.length){
            System.out.println("This object not found");
        } else {
            this.arr[i] = null;
            this.length--;
            this.clearNull();
        }
    }

    private void clearNull() {
        int nullCount = 0;
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == null)
                nullCount++;
        }
        if (nullCount > 5){
            DynamicArray d = new DynamicArray();
            for (int i = 0; i < this.arr.length; i++) {
                if (this.arr[i] != null)
                    d.addElement(this.arr[i]);
            }
            this.arr = d.arr;
            this.length = d.length;
        }
    }


    //- возвращает элемент с данным индексом


    public Object getElement(int n){
        if ((n < this.arr.length) && (n >= 0) && (this.arr[n - 1] != null)) {
            return this.arr[n - 1];
        }
        System.out.println("This element not exist");
        return null;

    }

    //- возвращает размер списка

    public int getSize(){
        return this.length;
    }
}

package ru.kpfu.itis.group11408.zamaleev.hw8List;

import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        System.out.println("List empty:" + list.isEmpty());
        System.out.println("add 10 Strings:");
        for (int i = 0; i < 10; i++) {
            list.add("student" + i);
        }
        System.out.println("List empty:" + list.isEmpty());
        for(String s: list){
            System.out.println(s);
        }
        System.out.println();
        System.out.println("remove String: student5");
        list.remove("student5");
        for(String s: list){
            System.out.println(s);
        }
        System.out.println("List contain \"student5\":" + list.contains("student5"));
        System.out.println("List contain \"student0\":" + list.contains("student0"));
        System.out.println();
        System.out.println("get 5-th element:");
        System.out.println(list.get(5));
        System.out.println("List clear");
        list.clear();
        System.out.println("List empty:" + list.isEmpty());
    }

}

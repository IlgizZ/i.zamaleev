package ru.kpfu.itis.group11408.zamaleev.hw9Stack;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Ilgiz on 20.03.2015.
 */
public class BracketsChecker {

    public static void main(String[] args){
        ArrayStack<Character> brackets = new ArrayStack();
        System.out.println("Write string content less then 20 inserted brackets:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        boolean right = true;
        int i = 0;
        while (right && (i < s.length())){
            switch (s.charAt(i)){
                case '(': case '{': case '[':
                    brackets.push(s.charAt(i));
                    break;
                case ')':
                    if (brackets.isEmpty()){
                        right = false;
                        break;
                    }
                    if (brackets.peek() == '('){
                        brackets.pop();
                        break;
                    } else {
                        right = false;
                        break;
                    }
                case ']':
                    if (brackets.isEmpty()){
                        right = false;
                        break;
                    }
                    if (brackets.peek() == '['){
                        brackets.pop();
                        break;
                    } else {
                        right = false;
                        break;
                    }
                case '}':
                    if (brackets.isEmpty()){
                        right = false;
                        break;
                    }
                    if (brackets.peek() == '{'){
                        brackets.pop();
                        break;
                    } else {
                        right = false;
                        break;
                    }
                default:
                    right = false;
                    break;
            }
            i++;
        }
        if (right && (brackets.isEmpty())){
            System.out.println("Brackets are placed correct!");
        } else {
            System.out.println("Brackets aren't placed correct!");
        }
        /*String s = "{(())()()(())()()()}";

        for (int i = 0; i < 20; i++) {
            brackets.push(s.charAt(i));
        }
        for (Iterator<Character> itr = brackets.iterator(); itr.hasNext();){
            System.out.println(itr.next());
        }
        while (!brackets.isEmpty()){
            System.out.println(brackets.pop());
        }*/
    }
}

package ru.kpfu.itis.group11408.zamaleev.class2;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ильгиз on 14.04.2015.
 */
public class StringExample {

    public static void main(String[] args){
        String a = "Diana, Anvar, Ilgiz, Lenar";
        /*long begin = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            //a += i;
            //a += "\n";
            sb.append(i);
            sb.append("\n");
            sb.append(" String");
        }
        System.out.println(sb.toString());
        System.out.println("Run time: " + (System.currentTimeMillis() - begin));

        StringTokenizer tokenizer = new StringTokenizer(a, ", ");
        while (tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }*/

        String template = "(\\.)||a*";

        Pattern pattern = Pattern.compile(template);
        Matcher matcher = pattern.matcher("aaaaa");

        System.out.println(matcher.matches());
    }
}

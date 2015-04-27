package ru.kpfu.itis.group11408.zamaleev.class2;

import java.io.*;
import java.nio.Buffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ильгиз on 14.04.2015.
 */
public class EmailFinder {

    public EmailFinder(String inFileName, String outFileName) throws FileNotFoundException {
        if ((inFileName == null) || !(new File(inFileName).exists())){
            throw new FileNotFoundException("Input file not exist!!!");
        }
        if ((outFileName == null) || !(new File(outFileName).exists())){
            outFileName = "e-mails.txt";
            try {
                throw new Exception("Output file not exist!!! File be named by default");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String template2 = "(\\w)(\\w*_*-*\\.*)*(\\w)@(\\w)(\\w*_*)*(\\w)*(\\.)([a-z][a-z])";
        String template3 = "(\\w)(\\w*_*-*\\.*)*(\\w)@(\\w)(\\w*_*)*(\\w)*(\\.)([a-z][a-z][a-z])";

        Pattern pattern2 = Pattern.compile(template2);
        Pattern pattern3 = Pattern.compile(template3);

        try(BufferedReader bis = new BufferedReader(new FileReader(inFileName))){
            String s ="";
            StringBuffer sb = new StringBuffer();
            while((s = bis.readLine()) != null){
                Matcher matcher2 = pattern2.matcher(s);
                while (matcher2.find()){
                    sb.append(matcher2.group());
                    sb.append("; ");
                }
                Matcher matcher3 = pattern3.matcher(s);
                while (matcher3.find()){
                    sb.append(matcher3.group());
                    sb.append("; ");
                }
                sb.append("\n");
            }
            try(BufferedWriter bos = new BufferedWriter(new FileWriter(outFileName))){
                bos.write(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ru.kpfu.itis.group11408.zamaleev.hw5Searcher;

import java.io.File;

public class Main {

	public static void main(String[] args) {
        /*String dirPath = "c:/";
        String[] ar = {"-d", "3", "-v",  dirPath, "Program"};*/
        try {
            Search search = new Search(args);
            search.start();
        }catch (SearcherExceptions e){
            e.printStackTrace();
        }
	}

}

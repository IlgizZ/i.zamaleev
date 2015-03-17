package ru.kpfu.itis.group11408.zamaleev.hw5Searcher;

import java.io.File;

/**
 * Created by Ilgiz on 09.03.2015.
 */
public class Search {
    private boolean recursion;
    private int depth;
    private boolean view;
    private String directory;
    private String fileName;
    private String depthName;

    public Search(String[] arr){
        try {
            this.createSearch(arr);
        }catch (SearcherExceptions e){
            e.printStackTrace();
        }
    }

    public Search(boolean recursion, int depth, boolean view, String directory, String fileName, String depthName) {
        this.recursion = recursion;
        this.depth = depth;
        this.directory = directory;
        this.fileName = fileName;
        this.view = view;
        this.depthName = depthName;
    }

    private void createSearch(String[] arr) throws SearcherExceptions {
        if (arr == null){
            throw new SearcherExceptions(
                    "Can't begin searching: "
                            + "array of string can't be null");
        }
        if (arr.length == 0){
            throw new SearcherExceptions(
                    "Can't begin searching: "
                            + "array can't be empty");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null){
                throw new SearcherExceptions(
                        "Incorrect input: "
                                + "arrays argument can't be null");
            }
        }
        boolean recursion = false;
        int depthFolder = -1;
        boolean view = false;
        String[] stringsToSearch = new String[0];
        String depthName = "";
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.charAt(0) == '-') {
                switch (s.charAt(1)) {
                    case 'r':
                    case 'R':
                        if (s.length() == 2) {
                            recursion = true;
                        } else {
                            stringsToSearch = addString(stringsToSearch, s);
                        }
                        break;
                    case 'd':
                    case 'D':
                        if (s.length() == 2) {
                            try {
                                if (i + 1 == arr.length){
                                    throw new SearcherExceptions("Incorrect depths value, write depths value.");
                                }
                                depthFolder = Integer.parseInt(arr[i + 1]);
                                if (depthFolder < 0){
                                    throw new SearcherExceptions("Incorrect depths value, depths value must be positive.");
                                }
                                i++;
                            } catch (NumberFormatException e){
                                throw new SearcherExceptions("Incorrect depths value.", e);
                            }
                        } else {
                            stringsToSearch = addString(stringsToSearch, s);
                        }
                        break;
                    case 'v':
                    case 'V':
                        if (s.length() == 2) {
                            view = true;
                        } else {
                            stringsToSearch = addString(stringsToSearch, s);
                        }
                        break;
                    default: stringsToSearch = addString(stringsToSearch, s);
                }
            }else {
                stringsToSearch = addString(stringsToSearch, s);
            }
        }
        if (recursion && (depthFolder > 0)){
            throw new SearcherExceptions("Search can't be nested and recursive simultaneously.");
        }
        if (stringsToSearch.length != 2){
            String s;
            if (stringsToSearch.length < 2){
                s = "Write a string you want to search";
            } else s = "Incorrect input";
            throw new SearcherExceptions(s);
        }
        this.recursion = recursion;
        this.depth = depthFolder;
        this.directory = stringsToSearch[0];
        this.fileName = stringsToSearch[1];
        this.view = view;
        this.depthName = depthName;
    }

    public static String[] addString(String[] arr, String s){
        String[] tmp = new String[1];
        if (arr != null){
            tmp = new String[arr.length + 1];
        }
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        tmp[tmp.length - 1] = s;
        return tmp;
    }

    public void start() throws SearcherExceptions{
        if (!new File(this.directory).exists()){
            throw new SearcherExceptions("This directory not found.");
        }
        if (this.view){
            viewSearch();
        } else nonViewSearch();
    }

    private void nonViewSearch() throws SearcherExceptions{
    	File f = new File(this.directory);
    	String[] s = f.list();
    	String[] fileNames = new String [0];
    	String[] directoryNames = new String[0];
    	if (s != null){
    		fileNames = getFiles(s);
    		directoryNames = getDirectories(s);
    	}        
        for (int i = 0; i < fileNames.length; i++) {
            if (fileNames[i].indexOf(this.fileName) > -1){
                System.out.println(this.depthName + fileNames[i]);
            }
        }
        if (this.recursion){
            for (int i = 0; i < directoryNames.length; i++) {
                Search search = new Search(this.recursion, this.depth, this.view,
                        this.directory + "/" + directoryNames[i], this.fileName,
                        this.depthName + directoryNames[i] + "/");
                search.start();
            }
        } else if (this.depth > 0) {
            for (int i = 0; i < directoryNames.length; i++) {
                Search search = new Search(this.recursion, this.depth - 1, this.view,
                        this.directory + "/" + directoryNames[i], this.fileName,
                        this.depthName + directoryNames[i] + "/");
                search.start();
            }
        }
    }

    private void viewSearch() throws SearcherExceptions{
    	File f = new File(this.directory);
    	String[] s = f.list();
    	String[] fileNames = new String [0];
    	String[] directoryNames = new String[0];
    	if (s != null){
    		fileNames = getFiles(s);
    		directoryNames = getDirectories(s);
    	} 
    	for (int i = 0; i < directoryNames.length; i++) {
            if (directoryNames[i].indexOf(this.fileName) > -1){
                System.out.println(this.depthName + directoryNames[i]);
            }
        }
        for (int i = 0; i < fileNames.length; i++) {
            if (fileNames[i].indexOf(this.fileName) > -1){
                System.out.println(this.depthName + fileNames[i]);
            }
        }
        if (this.recursion){
            for (int i = 0; i < directoryNames.length; i++) {
                Search search = new Search(this.recursion, this.depth, this.view,
                        this.directory + "/" + directoryNames[i], this.fileName,
                                this.depthName + directoryNames[i] + "/");
                search.start();
            }
        } else if (this.depth > 0) {
            for (int i = 0; i < directoryNames.length; i++) {
                Search search = new Search(this.recursion, this.depth - 1, this.view,
                        this.directory + "/" + directoryNames[i], this.fileName,
                        this.depthName + directoryNames[i] + "/");
                search.start();
            }
        }
    }

    private String[] getDirectories(String[] list) {
        File f;
        String[] result = {};
        for (int i = 0; i < list.length; i++) {
            f = new File(this.directory + "/" + list[i]);
            if (f.exists() && f.isDirectory()){
                result = addString(result, list[i]);
            }
        }
        return result;
    }

    private String[] getFiles(String[] list) {
        File f;
        String[] result = {};
        for (int i = 0; i < list.length; i++) {
            f = new File(this.directory + "/" + list[i]);
            if (f.exists() && f.isFile()){
                result = addString(result, list[i]);
            }
        }
        return result;
    }
}

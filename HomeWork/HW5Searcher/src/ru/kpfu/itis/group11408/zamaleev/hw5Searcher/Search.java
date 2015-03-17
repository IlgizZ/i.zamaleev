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

    public Search(boolean recursion, int depth, boolean view, String directory, String fileName, String depthName) {
        this.recursion = recursion;
        this.depth = depth;
        this.directory = directory;
        this.fileName = fileName;
        this.view = view;
        this.depthName = depthName;
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
    		fileNames = getFiels(s);
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
    		fileNames = getFiels(s);
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
            if (f.isDirectory()){
                result = Main.addString(result, list[i]);
            }
        }
        return result;
    }

    private String[] getFiels(String[] list) {
        File f;
        String[] result = {};
        for (int i = 0; i < list.length; i++) {
            f = new File(this.directory + "/" + list[i]);
            if (f.isFile()){
                result = Main.addString(result, list[i]);
            }
        }
        return result;
    }
}

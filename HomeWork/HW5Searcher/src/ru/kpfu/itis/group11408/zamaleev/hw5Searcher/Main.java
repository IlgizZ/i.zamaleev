package ru.kpfu.itis.group11408.zamaleev.hw5Searcher;


import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
        //String dirPath = "c:/";
        //String[] ar = {"-d", "3", "-v",  dirPath, "Program"};
        try {
            Search search = createSerch(args);
            search.start();
        }catch (SearcherExceptions e){
            e.printStackTrace();
        }
	}
	
	private static Search createSerch(String[] arr) throws SearcherExceptions {
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
        return new Search(recursion, depthFolder, view, stringsToSearch[0], stringsToSearch[1], depthName);
	}

    public static String[] addString(String[] arr, String s){
        String[] tmp = new String[arr.length + 1];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        tmp[tmp.length - 1] = s;
        return tmp;
    }

}

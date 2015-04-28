package Term2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ilgiz on 27.04.2015.
 */
public interface GraphInterface{
    int length();
    Iterator iterator(int i);
    void add(int i, int j);
}

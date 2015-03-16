package ru.kpfu.itis.group11408.zamaleev.hw7StudentTable;

import ru.kpfu.itis.group11408.zamaleev.hw7Generik.ViewProvader;

/**
 * Created by Ilgiz on 16.03.2015.
 */
public class StudentView implements ViewProvader <Student> {
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getLabel(Student o1, int n) {
        switch (n) {
            case 0: return o1.getName();
            case 1: return Integer.toString(o1.getYear());
            case 2: return Double.toString(o1.getGrade());
        }
        return null;
    }

    @Override
    public String getHeader(int n) {
        switch (n) {
            case 0: return "Name";
            case 1: return "Year";
            case 2: return "Grade";
        }
        return null;
    }
}

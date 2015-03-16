package ru.kpfu.itis.group11408.zamaleev.hw7StudentTable;

import ru.kpfu.itis.group11408.zamaleev.hw7Generik.ConsoleTableViewer;
import ru.kpfu.itis.group11408.zamaleev.hw7Generik.ModelProvider;
import ru.kpfu.itis.group11408.zamaleev.hw7Generik.ViewProvader;

/**
 * Created by Ilgiz on 16.03.2015.
 */
public class StudentTable extends ConsoleTableViewer<Student> {

    public StudentTable(ModelProvider model, ViewProvader view) {
        super(model, view);
    }

    public static void main(String[] args){
        (new StudentTable(new StudentModel(), new StudentView())).show();
    }
}

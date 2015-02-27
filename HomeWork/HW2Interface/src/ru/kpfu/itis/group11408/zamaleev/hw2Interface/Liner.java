package ru.kpfu.itis.group11408.zamaleev.hw2Interface;

/**
 * Created by Ilgiz on 13.02.2015.
 */
public class Liner extends Ship implements MilitaryTypeProvider {
    @Override
    public int getMilitaryType() {
        return PEACE_CONST;
    }

    public static void main(String [] args){
        System.out.println(new Liner().getMilitaryType());
    }
}

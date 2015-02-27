package ru.kpfu.itis.group11408.zamaleev.hw2Interface;

public class Boing extends Plane implements MilitaryTypeProvider{

    @Override
    public int getMilitaryType() {
        return PEACE_CONST;
    }

    public static void main(String [] args){
        System.out.println(new Boing().getMilitaryType());
    }
}

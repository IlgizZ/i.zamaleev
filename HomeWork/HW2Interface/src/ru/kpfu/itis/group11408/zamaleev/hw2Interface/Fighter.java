package ru.kpfu.itis.group11408.zamaleev.hw2Interface;


public class Fighter extends Plane implements MilitaryTypeProvider{
    @Override
    public int getMilitaryType() {
        return MILITARY_CONST;
    }

    public static void main(String [] args){
        System.out.println(new Fighter().getMilitaryType());
    }
}

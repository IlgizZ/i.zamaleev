package ru.kpfu.itis.group11408.zamaleev.hw2Interface;


public class AircraftCarrier extends Ship implements MilitaryTypeProvider{
    @Override
    public int getMilitaryType() {
        return MILITARY_CONST;
    }

    public static void main(String [] args){
        System.out.println(new AircraftCarrier().getMilitaryType());
    }
}

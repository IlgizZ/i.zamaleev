package ru.kpfu.itis.group11408.zamaleev.hw2Interface;


public interface MilitaryTypeProvider {
    int MILITARY_CONST = - 100;
    int PEACE_CONST = 100;

    /**
     *
     * @Возвращает описание транспорта.
     */
    int getMilitaryType();
}

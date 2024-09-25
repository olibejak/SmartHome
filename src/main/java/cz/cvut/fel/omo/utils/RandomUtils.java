package cz.cvut.fel.omo.utils;

public class RandomUtils {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

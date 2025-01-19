package cz.cvut.fel.omo.utils;

public class RandomUtils {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static boolean isWithinPercentage(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100.");
        }
        int randomValue = getRandomNumber(1, 101); // Generate a number between 1 and 100
        return randomValue <= percentage;
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

}

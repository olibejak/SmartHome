package cz.cvut.fel.omo.utils;

import java.util.ArrayList;

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

    /**
     * Returns a random element from an ArrayList.
     * @param list the ArrayList of elements
     * @param <T> the type of elements in the list
     * @return a random element from the list
     * @throws IllegalArgumentException if the list is null or empty
     */
    public static <T> T getRandomElement(ArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty.");
        }
        int index = getRandomNumber(0, list.size());
        return list.get(index);
    }

}

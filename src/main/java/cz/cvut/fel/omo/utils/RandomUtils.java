package cz.cvut.fel.omo.utils;

import java.util.ArrayList;

/**
 * Utility class providing methods for generating random values and selections.
 */
public class RandomUtils {

    /**
     * Generates a random integer between the specified minimum and maximum values (inclusive).
     *
     * @param min The minimum value (inclusive).
     * @param max The maximum value (exclusive).
     * @return A random integer between min (inclusive) and max (exclusive).
     */
    public static int getRandomNumberInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Determines whether a randomly generated percentage falls within the given threshold.
     *
     * @param percentage The threshold percentage (0 to 100).
     * @return {@code true} if the generated random percentage is within the given range, {@code false} otherwise.
     * @throws IllegalArgumentException if the percentage is not between 0 and 100.
     */
    public static boolean isWithinPercentage(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100.");
        }
        int randomValue = getRandomNumberInRange(1, 101); // Generate a number between 1 and 100
        return randomValue <= percentage;
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
        int index = getRandomNumberInRange(0, list.size());
        return list.get(index);
    }

    public static boolean coinFLip() {
        return isWithinPercentage(50);
    }

}

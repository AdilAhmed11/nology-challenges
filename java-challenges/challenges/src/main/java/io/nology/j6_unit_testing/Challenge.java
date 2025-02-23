package io.nology.j6_unit_testing;

import java.util.List;

public class Challenge {

    private Challenge() {
    }

    /**
     * Checks if a number is even.
     *
     * @param number - The number to check
     * @return True if the number is even, false otherwise
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Concatenates a list of strings into a single string with spaces in between.
     *
     * @param words - The list of words to concatenate
     * @return A single string with all words concatenated with spaces
     */
    public String concatenateWords(List<String> words) {
        return String.join(" ", words);
    }

    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param n - The number to calculate the factorial of
     * @return The factorial of the number
     * @throws IllegalArgumentException if n is negative
     */
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}

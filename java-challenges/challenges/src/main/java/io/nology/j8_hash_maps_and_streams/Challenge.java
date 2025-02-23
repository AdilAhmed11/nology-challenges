package io.nology.j8_hash_maps_and_streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Challenge {

    public Challenge() {
    }

    /**
     * Counts the occurrences of each word in a given sentence and returns a HashMap
     * where the keys are words and the values are the number of occurrences.
     *
     * @param sentence - The sentence to analyse
     * @return A HashMap with words as keys and their occurrences as values
     */
    public HashMap<String, Integer> countWordOccurrences(String sentence) {
        return new HashMap<>();
    }

    /**
     * Merges two HashMaps containing student names and their scores. If a student
     * appears in both maps, the scores should be summed.
     *
     * @param map1 - The first HashMap of student scores
     * @param map2 - The second HashMap of student scores
     * @return A merged HashMap with summed scores for students appearing in both
     *         maps
     */
    public HashMap<String, Integer> mergeStudentScores(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        return new HashMap<>();
    }

    /**
     * Finds the most frequent character in a string and returns it. If there is a
     * tie,
     * return any one of the most frequent characters.
     *
     * @param input - The input string
     * @return The most frequent character
     * @throws IllegalArgumentException ("Input string must not be null or empty")
     *                                  if the input is empty
     */
    public char findMostFrequentCharacter(String input) {
        return 'a';
    }

    /**
     * Calculates the average length of words in a list using streams.
     *
     * @param words - The list of words
     * @return The average length of the words
     */
    public double calculateAverageWordLength(List<String> words) {
        return 1;
    }

    /**
     * Filters a list of integers to return only prime numbers using streams.
     * 
     * (write a "helper method" checking if a number isPrime)
     *
     * @param numbers - The list of integers
     * @return A list of prime numbers
     */
    public List<Integer> filterPrimes(List<Integer> numbers) {

        return new ArrayList<>();

    }

    boolean isPrime(int number) {

        return true;
    }

    /**
     * Concatenates a list of strings into a single string, separated by commas,
     * using streams.
     *
     * @param strings - The list of strings
     * @return A single concatenated string
     */
    public String concatenateWithCommas(List<String> strings) {
        return "";
    }

}

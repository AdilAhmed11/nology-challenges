package io.nology.j4_arrays_and_loops;

import java.util.Arrays;

public class Challenge {

    public Challenge() {
    }

    /**
     * A method to check if two strings are anagrams of each other.
     * <p>
     * Two strings are considered anagrams if they contain the same characters in
     * the same frequency, but possibly in a different order (reordered characters
     * of one string create the second string)
     *
     * @param str1 the first string
     * @param str2 the second string
     * @return true if the strings are anagrams, false otherwise
     */
    public boolean areAnagrams(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        String sortedStr1 = new String(char1);
        String sortedStr2 = new String(char2);

        if (sortedStr2.equals(sortedStr1)) {
            return true;
        }
        return false;
    }

    /**
     * A method to print characters between two given characters
     *
     * @param start the starting character (A)
     * @param end   the ending character (P)
     * @return returns all the characters between the start and end
     * (`ABCDEFGHIJKLMNOP`)
     */
    public void printCharactersBetween(char start, char end) {
        StringBuilder result = new StringBuilder();

        for (char i = start; i <= end; i++) {
            result.append(i);
        }
        System.out.print(result.toString());
    }

    /***
     * A method to find the middle item(s) in a given string array
     *
     * If the array has an odd number of items, return an array containing the
     * single middle item.
     * If the array has an even number of items, return an array containing the two
     * middle items.
     * If the array is empty, return an empty string array.
     *
     * @param array the input array of strings
     * @return an array containing the middle item(s)
     */
    public String[] findMiddleItems(String[] array) {
        if (array.length == 0) {
            return new String[]{};
        }
        int mid = array.length / 2;

        if (array.length % 2 != 0) {
            return new String[]{array[mid]};
        } else {
            return new String[]{array[mid-1], array[mid]};
        }
    }

    /***
     * A method to merge two sorted integer arrays into a single sorted array
     *
     * @param array1 the first sorted integer array
     * @param array2 the second sorted integer array
     * @return a new sorted integer array containing all elements from both input
     *         arrays
     */
    // https://javaconceptoftheday.com/merge-two-sorted-arrays-in-java/
    public int[] mergeSortedArrays(int[] array1, int[] array2) {
        int n1 = array1.length, n2 = array2.length;
        int[] mergedArray = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        // Merge both arrays while elements remain in both
        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }

        // Copy any remaining elements from array1
        while (i < n1) {
            mergedArray[k++] = array1[i++];
        }

        // Copy any remaining elements from array2
        while (j < n2) {
            mergedArray[k++] = array2[j++];
        }

        return mergedArray;
    }

    /***
     * A method to find the sum of all odd numbers in an array
     *
     * @param array the input array of integers
     * @return the sum of all odd numbers in the array
     */
    public int sumOfOddNumbers(int[] array) {
        int result = 0;

        for (int value : array) {
            if (value % 2 != 0) {
                result += value;
            }
        } return result;
    }

    /***
     * A method to find the maximum subarray sum in a given integer array
     *
     * Example:
     * Input: array = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
     * Output: 6 (The maximum subarray is [4, -1, 2, 1] with sum 6)
     *
     * Input: array = { -1, -2, -3, -4}
     * Output: -1
     *
     * @param array the input array of integers
     * @return the maximum subarray sum
     */
    public int maxSubarraySum(int[] array) {
        int result = array[0];
        // Outer loop for starting point of subarray
        for (int i = 0; i < array.length; i++) {
            int currSum = 0;

            // inner loop for ending point of subarray
            for (int j = i; j < array.length; j++) {
                currSum = currSum + array[j];

                result = Math.max(result, currSum);
            }
        }
        return result;
    }

    /**
     * A recursive method to calculate the factorial of a given positive integer
     *
     * @param n the positive integer
     * @return the factorial of the given integer
     * @throws IllegalArgumentException if n is negative
     */
    public int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        return n * calculateFactorial(n - 1);
    }

}

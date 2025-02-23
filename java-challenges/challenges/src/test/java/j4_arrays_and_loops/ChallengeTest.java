package j4_arrays_and_loops;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import io.nology.j4_arrays_and_loops.Challenge;

public class ChallengeTest {

    private Challenge challenge;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        challenge = new Challenge();
        System.setOut(new PrintStream(outputStream)); // Redirect System.out
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out); // Restore System.out
        outputStream.reset(); // Clear the output stream
    }

    // Testing areAnagrams

    @Test
    void areAnagrams_Anagrams_ShouldReturnTrue() {

        boolean result = challenge.areAnagrams("listen", "silent");

        assertTrue(result);
    }

    @Test
    void areAnagrams_NonAnagrams_ShouldReturnFalse() {

        boolean result = challenge.areAnagrams("hello", "world");

        assertFalse(result);
    }

    @Test
    void areAnagrams_IdenticalStrings_ShouldReturnTrue() {

        boolean result = challenge.areAnagrams("same", "same");

        assertTrue(result);
    }

    @Test
    void areAnagrams_OneEmptyString_ShouldReturnFalse() {

        boolean result = challenge.areAnagrams("", "notempty");

        assertFalse(result);
    }

    @Test
    void areAnagrams_EmptyStrings_ShouldReturnTrue() {

        boolean result = challenge.areAnagrams("", "");

        assertTrue(result);
    }

    // Testing printCharactersBetween
    @Test
    void printCharactersBetween_StartBeforeEnd_ShouldPrintInOrder() {

        challenge.printCharactersBetween('A', 'P');

        String expectedOutput = "ABCDEFGHIJKLMNOP";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void printCharactersBetween_StartAfterEnd_ShouldPrintInReverseOrder() {

        challenge.printCharactersBetween('P', 'A');

        String expectedOutput = "PONMLKJIHGFEDCBA";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void printCharactersBetween_StartEqualsEnd_ShouldPrintSingleCharacter() {

        challenge.printCharactersBetween('G', 'G');

        String expectedOutput = "G";
        assertEquals(expectedOutput, outputStream.toString());
    }

    // Testing findMiddleItems

    @Test
    void findMiddleItems_OddLengthArray_ShouldReturnMiddleItem() {
        // Test case for an odd-length array
        String[] input = { "apple", "banana", "cherry" };
        String[] result = challenge.findMiddleItems(input);
        assertArrayEquals(new String[] { "banana" }, result, "The middle item should be 'banana'");
    }

    @Test
    void findMiddleItems_EvenLengthArray_ShouldReturnTwoMiddleItems() {
        // Test case for an even-length array
        String[] input = { "apple", "banana", "cherry", "date" };
        String[] result = challenge.findMiddleItems(input);
        assertArrayEquals(new String[] { "banana", "cherry" }, result,
                "The middle items should be 'banana' and 'cherry'");
    }

    @Test
    void findMiddleItems_EmptyArray_ShouldReturnEmptyArray() {
        // Test case for an empty array
        String[] input = {};
        String[] result = challenge.findMiddleItems(input);
        assertArrayEquals(new String[] {}, result, "The result should be an empty array");
    }

    @Test
    void findMiddleItems_SingleElementArray_ShouldReturnSameElement() {
        // Test case for a single-element array
        String[] input = { "apple" };
        String[] result = challenge.findMiddleItems(input);
        assertArrayEquals(new String[] { "apple" }, result, "The result should be the single element 'apple'");
    }

    @Test
    void findMiddleItems_TwoElementArray_ShouldReturnBothElements() {
        // Test case for a two-element array
        String[] input = { "apple", "banana" };
        String[] result = challenge.findMiddleItems(input);
        assertArrayEquals(new String[] { "apple", "banana" }, result,
                "The result should be both elements 'apple' and 'banana'");
    }

    // Testing mergeSortedArrays

    @Test
    void mergeSortedArrays_DistinctElements_ShouldReturnMergedArray() {
        // Test merging of two sorted arrays with distinct elements
        int[] array1 = { 1, 3, 5 };
        int[] array2 = { 2, 4, 6 };
        int[] expectedOutput = { 1, 2, 3, 4, 5, 6 };
        int[] result = challenge.mergeSortedArrays(array1, array2);
        assertArrayEquals(expectedOutput, result, "The merged array should be {1, 2, 3, 4, 5, 6}");
    }

    @Test
    void mergeSortedArrays_OverlappingElements_ShouldReturnMergedArray() {
        // Test merging two sorted arrays with some overlapping elements
        int[] array1 = { 1, 3, 5, 7 };
        int[] array2 = { 5, 6, 8, 9 };
        int[] expectedOutput = { 1, 3, 5, 5, 6, 7, 8, 9 };
        int[] result = challenge.mergeSortedArrays(array1, array2);
        assertArrayEquals(expectedOutput, result, "The merged array should be {1, 3, 5, 5, 6, 7, 8, 9}");
    }

    @Test
    void mergeSortedArrays_OneEmptyArray_ShouldReturnNonEmptyArray() {
        // Test merging two sorted arrays where one array is empty
        int[] array1 = {};
        int[] array2 = { 2, 4, 6 };
        int[] expectedOutput = { 2, 4, 6 };
        int[] result = challenge.mergeSortedArrays(array1, array2);
        assertArrayEquals(expectedOutput, result, "The merged array should be {2, 4, 6}");
    }

    @Test
    void mergeSortedArrays_BothEmptyArrays_ShouldReturnEmptyArray() {
        // Test merging two sorted arrays where both arrays are empty
        int[] array1 = {};
        int[] array2 = {};
        int[] expectedOutput = {};
        int[] result = challenge.mergeSortedArrays(array1, array2);
        assertArrayEquals(expectedOutput, result, "The merged array should be empty");
    }

    @Test
    void mergeSortedArrays_NegativeAndPositiveNumbers_ShouldReturnMergedArray() {
        // Test merging two sorted arrays with negative and positive numbers
        int[] array1 = { -5, -3, 1, 2 };
        int[] array2 = { -4, 0, 3, 5 };
        int[] expectedOutput = { -5, -4, -3, 0, 1, 2, 3, 5 };
        int[] result = challenge.mergeSortedArrays(array1, array2);
        assertArrayEquals(expectedOutput, result, "The merged array should be {-5, -4, -3, 0, 1, 2, 3, 5}");
    }

    // Testing sumOfOddNumbers

    @Test
    void sumOfOddNumbers_AllOddNumbers_ShouldReturnSum() {
        // Test with an array containing only odd numbers
        int[] oddArray = { 1, 3, 5, 7, 9 };
        int result = challenge.sumOfOddNumbers(oddArray);
        assertEquals(25, result, "The sum of all odd numbers should be 25");
    }

    @Test
    void sumOfOddNumbers_AllEvenNumbers_ShouldReturnZero() {
        // Test with an array containing only even numbers
        int[] evenArray = { 2, 4, 6, 8, 10 };
        int result = challenge.sumOfOddNumbers(evenArray);
        assertEquals(0, result, "The sum of all odd numbers should be 0");
    }

    @Test
    void sumOfOddNumbers_MixedNumbers_ShouldReturnSumOfOdds() {
        // Test with an array containing both odd and even numbers
        int[] mixedArray = { 1, 2, 3, 4, 5, 6 };
        int result = challenge.sumOfOddNumbers(mixedArray);
        assertEquals(9, result, "The sum of all odd numbers should be 9");
    }

    @Test
    void sumOfOddNumbers_EmptyArray_ShouldReturnZero() {
        // Test with an empty array
        int[] emptyArray = {};
        int result = challenge.sumOfOddNumbers(emptyArray);
        assertEquals(0, result, "The sum of all odd numbers should be 0");
    }

    @Test
    void sumOfOddNumbers_NegativeAndPositiveNumbers_ShouldReturnSumOfOdds() {
        // Test with an array containing negative and positive numbers
        int[] mixedSignArray = { -5, -4, -3, 0, 2, 3, 4 };
        int result = challenge.sumOfOddNumbers(mixedSignArray);
        assertEquals(-5, result, "The sum of all odd numbers should be -5");
    }

    // Testing maxSubarraySum

    @Test
    void maxSubarraySum_StandardExample_ShouldReturnCorrectSum() {
        // Test case 1: Standard example with both negative and positive numbers
        int[] exampleArray = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = challenge.maxSubarraySum(exampleArray);
        assertEquals(6, result, "The maximum subarray sum should be 6");
    }

    @Test
    void maxSubarraySum_AllNegativeNumbers_ShouldReturnMaxSingleElement() {
        // Test case 2: All negative numbers
        int[] negativeArray = { -1, -2, -3, -4 };
        int result = challenge.maxSubarraySum(negativeArray);
        assertEquals(-1, result, "The maximum subarray sum should be -1");
    }

    @Test
    void maxSubarraySum_AllPositiveNumbers_ShouldReturnSumOfAllElements() {
        // Test case 3: All positive numbers
        int[] positiveArray = { 1, 2, 3, 4 };
        int result = challenge.maxSubarraySum(positiveArray);
        assertEquals(10, result, "The maximum subarray sum should be 10");
    }

    @Test
    void maxSubarraySum_MixedArray_ShouldReturnCorrectSum() {
        // Test case 4: Mixed array with positive, negative, and zero values
        int[] mixedArray = { 1, -2, 3, 0, -5, 4 };
        int result = challenge.maxSubarraySum(mixedArray);
        assertEquals(4, result, "The maximum subarray sum should be 4");
    }

    @Test
    void maxSubarraySum_EmptyArray_ShouldReturnZero() {
        // Test case 5: Empty array
        int[] emptyArray = {};
        int result = challenge.maxSubarraySum(emptyArray);
        assertEquals(0, result, "The maximum subarray sum should be 0");
    }

    @Test
    void maxSubarraySum_SingleElementArray_ShouldReturnElement() {
        // Test case 6: Array containing a single element
        int[] singleElementArray = { 5 };
        int result = challenge.maxSubarraySum(singleElementArray);
        assertEquals(5, result, "The maximum subarray sum should be 5");
    }

    @Test
    void maxSubarraySum_TwoPositiveElements_ShouldReturnSum() {
        // Test case 7: Array of two elements, both positive
        int[] twoPositiveArray = { 3, 5 };
        int result = challenge.maxSubarraySum(twoPositiveArray);
        assertEquals(8, result, "The maximum subarray sum should be 8");
    }

    @Test
    void maxSubarraySum_TwoNegativeElements_ShouldReturnMaxSingleElement() {
        // Test case 8: Array of two elements, both negative
        int[] twoNegativeArray = { -3, -5 };
        int result = challenge.maxSubarraySum(twoNegativeArray);
        assertEquals(-3, result, "The maximum subarray sum should be -3");
    }

    // Testing calculateFactorial

    @Test
    void calculateFactorial_Zero_ShouldReturnOne() {
        // Test the factorial of 0
        int result = challenge.calculateFactorial(0);
        assertEquals(1, result, "The factorial of 0 should be 1");
    }

    @Test
    void calculateFactorial_PositiveNumber_ShouldReturnFactorial() {
        // Test the factorial of a positive number
        int result = challenge.calculateFactorial(5);
        assertEquals(120, result, "The factorial of 5 should be 120");
    }

    @Test
    void calculateFactorial_One_ShouldReturnOne() {
        // Test the factorial of 1
        int result = challenge.calculateFactorial(1);
        assertEquals(1, result, "The factorial of 1 should be 1");
    }

    @Test
    void calculateFactorial_LargeNumber_ShouldReturnFactorial() {
        // Test the factorial of a larger number
        int result = challenge.calculateFactorial(7);
        assertEquals(5040, result, "The factorial of 7 should be 5040");
    }

    @Test
    void calculateFactorial_NegativeNumber_ShouldThrowException() {
        // Test the factorial of a negative number
        assertThrows(IllegalArgumentException.class, () -> {
            challenge.calculateFactorial(-1);
        }, "Factorial of a negative number should throw IllegalArgumentException");
    }

}

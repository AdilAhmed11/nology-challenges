package j2_methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.nology.j2_methods.Challenge;

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

    // Testing findSmallestNumber

    @Test
    void findSmallestNumber_AllDifferent_ShouldReturnSmallest() {
        // Test when all numbers are different
        int result = challenge.findSmallestNumber(5, 3, 8);
        assertEquals(3, result, "The smallest number should be 3");
    }

    @Test
    void findSmallestNumber_TwoEqualSmallest_ShouldReturnSmallest() {
        // Test when two numbers are the smallest and equal
        int result = challenge.findSmallestNumber(5, 3, 3);
        assertEquals(3, result, "The smallest number should be 3");
    }

    @Test
    void findSmallestNumber_AllEqual_ShouldReturnAny() {
        // Test when all numbers are equal
        int result = challenge.findSmallestNumber(7, 7, 7);
        assertEquals(7, result, "The smallest number should be 7");
    }

    @Test
    void findSmallestNumber_NegativeNumbers_ShouldReturnSmallest() {
        // Test with negative numbers
        int result = challenge.findSmallestNumber(-5, -3, -8);
        assertEquals(-8, result, "The smallest number should be -8");
    }

    @Test
    void findSmallestNumber_ZeroAndPositive_ShouldReturnZero() {
        // Test with zero and positive numbers
        int result = challenge.findSmallestNumber(0, 5, 10);
        assertEquals(0, result, "The smallest number should be 0");
    }

    // Testing isValidPassword

    @Test
    void isValidPassword_ValidPassword_ShouldReturnTrue() {
        // Test a valid password
        boolean result = challenge.isValidPassword("abcd123456");
        assertTrue(result, "The password should be valid");
    }

    @Test
    void isValidPassword_TooShort_ShouldReturnFalse() {
        // Test a password that is too short
        boolean result = challenge.isValidPassword("abc123");
        assertFalse(result, "The password should be invalid due to insufficient length");
    }

    @Test
    void isValidPassword_NoDigits_ShouldReturnFalse() {
        // Test a password with no digits
        boolean result = challenge.isValidPassword("abcdefghij");
        assertFalse(result, "The password should be invalid due to lack of digits");
    }

    @Test
    void isValidPassword_OneDigit_ShouldReturnFalse() {
        // Test a password with only one digit
        boolean result = challenge.isValidPassword("abcdefghi1");
        assertFalse(result, "The password should be invalid due to having only one digit");
    }

    @Test
    void isValidPassword_ContainsSpecialCharacters_ShouldReturnFalse() {
        // Test a password with special characters
        boolean result = challenge.isValidPassword("abcd1234$%");
        assertFalse(result, "The password should be invalid due to containing special characters");
    }
}

package j1_types_and_control_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import io.nology.j1_types_and_control_flow.Challenge;

public class ChallengeTest {

    private Challenge challenge;

    @BeforeEach
    void setUp() {
        challenge = new Challenge();
    }

    @AfterEach
    void tearDown() {
    }

    // -------------- FOUNDATION --------------

    // Testing findLargestNumber

    @Test
    void findLargestNumber_ValidIntegers_ReturnsLargest() {
        int result = challenge.findLargestNumber(22, 25);
        assertEquals(25, result);
    }

    @Test
    void findLargestNumber_EqualIntegers_ReturnsEqual() {
        int result = challenge.findLargestNumber(22, 22);
        assertEquals(22, result);
    }

    @Test
    void findLargestNumber_NegativeIntegers_ReturnsLargest() {
        int result = challenge.findLargestNumber(-22, -100);
        assertEquals(-22, result);
    }

    // Testing findLongestString

    @Test
    void findLargestString_ValidStrings_ReturnsLongest() {
        String result = challenge.findLongestString("Sam", "Andy");
        assertEquals("Andy", result);
    }

    @Test
    void findLargestString_EqualStrings_ReturnsEqualMessage() {
        String result = challenge.findLongestString("Cattywampus", "Cattywampus");
        assertEquals("These two are the same length!", result);
    }

    // Testing getDiscount challenge

    @Test
    void getDiscount_ValidInputs_ReturnCorrectDiscount() {
        double result = challenge.getDiscount(100, 10);
        assertEquals(90, result);
    }

    @Test
    void getDiscount_ValidInputs_ReturnCorrectDiscountWithDecimals() {
        double result = challenge.getDiscount(27, 5);
        assertEquals(25.65, result);
    }

    // -------------- INTERMEDIATE --------------

    // Testing compareTwoNumbers

    @Test
    void compareTwoNumbers_ValidInputsNotEqual_ReturnFalse() {
        boolean result = challenge.compareTwoNumbers(12.3333, 12.3343);
        assertFalse(result);
    }

    @Test
    void compareTwoNumbers_ValidInputsEqual_ReturnTrue() {
        boolean result = challenge.compareTwoNumbers(1.3333, 1.3333);
        assertTrue(result);
    }

    // Testing getDayName

    @Test
    void getDayName_ValidInput_ReturnSunday() {
        String result = challenge.getDayName(0);
        assertEquals("Sunday", result);
    }

    @Test
    void getDayName_ValidInput_ReturnMonday() {
        String result = challenge.getDayName(1);
        assertEquals("Monday", result);
    }

    @Test
    void getDayName_ValidInput_ReturnTuesday() {
        String result = challenge.getDayName(2);
        assertEquals("Tuesday", result);
    }

    @Test
    void getDayName_ValidInput_ReturnWednesday() {
        String result = challenge.getDayName(3);
        assertEquals("Wednesday", result);
    }

    @Test
    void getDayName_ValidInput_ReturnThursday() {
        String result = challenge.getDayName(4);
        assertEquals("Thursday", result);
    }

    @Test
    void getDayName_ValidInput_ReturnFriday() {
        String result = challenge.getDayName(5);
        assertEquals("Friday", result);
    }

    @Test
    void getDayName_ValidInput_ReturnSaturday() {
        String result = challenge.getDayName(6);
        assertEquals("Saturday", result);
    }

    @Test
    void getDayName_InvalidInput_ReturnsOutOfRange() {
        String result = challenge.getDayName(9);
        assertEquals("Not a valid day range! The number needs to be from 0-6", result);
    }

    // Testing isEvenWord

    @Test
    void isEvenWord_ValidInput_EvenReturnsTrue() {
        boolean result = challenge.isEvenWord("dice");
        assertTrue(result);
    }

    @Test
    void isEvenWord_ValidInput_OddReturnsFalse() {
        boolean result = challenge.isEvenWord("mouse");
        assertFalse(result);
    }

    @Test
    void isEvenWord_InvalidInputEmpty_ReturnsFalse() {
        boolean result = challenge.isEvenWord("");
        assertFalse(result);
    }

    // -------------- ADVANCED --------------

    // Testing leapYearChecker

    @Test
    void leapYearChecker_ValidInput_ReturnsTrueDivisibleBy4() {
        boolean result = challenge.leapYearChecker(2016);
        assertTrue(result);
    }

    @Test
    void leapYearChecker_InvalidInput_ReturnsFalseNotDivisibleBy4() {
        boolean result = challenge.leapYearChecker(2017);
        assertFalse(result);
    }

    @Test
    void leapYearChecker_ValidInput_ReturnsTrueDivisibleBy4And400() {
        boolean result = challenge.leapYearChecker(2000);
        assertTrue(result);
    }

    @Test
    void leapYearChecker_InvalidInput_ReturnsFalseDivisibleBy4And100() {
        boolean result = challenge.leapYearChecker(2100);
        assertFalse(result);
    }

}
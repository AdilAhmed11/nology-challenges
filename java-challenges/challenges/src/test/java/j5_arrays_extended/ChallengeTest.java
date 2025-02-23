package j5_arrays_extended;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.nology.j5_arrays_extended.Challenge;

public class ChallengeTest {
    private Challenge challenge;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        challenge = new Challenge();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    // Testing print2DArray

    @Test
    void print2DArray_3x4Matrix_PrintsMatrixFormat() {
        challenge.print2DArray(3, 4);
        String output = outputStreamCaptor.toString().trim();
        String[] lines = output.split("\n");

        // Check that there are 3 lines (rows)
        assertEquals(3, lines.length);

        // Check that each line has 4 numbers (columns)
        for (String line : lines) {
            String[] numbers = line.trim().split("\\s+");
            assertEquals(4, numbers.length);
        }
    }

    @Test
    void print2DArray_2x2Matrix_PrintsMatrixFormat() {
        challenge.print2DArray(2, 2);
        String output = outputStreamCaptor.toString().trim();
        String[] lines = output.split("\n");

        // Check that there are 2 lines (rows)
        assertEquals(2, lines.length);

        // Check that each line has 2 numbers (columns)
        for (String line : lines) {
            String[] numbers = line.trim().split("\\s+");
            assertEquals(2, numbers.length);
        }
    }

    // Testing findMaxInRows

    @Test
    void findMaxInRows_ValidArray_PrintsMaxElements() {
        int[][] array = {
                { 14, 73, 28, 42 },
                { 39, 91, 19, 46 },
                { 67, 34, 89, 75 }
        };
        challenge.findMaxInRows(array);

        String expectedOutput = "73\n91\n89\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void findMaxInRows_SingleElementRows_PrintsElements() {
        int[][] array = {
                { 5 },
                { 10 },
                { 3 }
        };
        challenge.findMaxInRows(array);

        String expectedOutput = "5\n10\n3\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void findMaxInRows_EmptyArray_NoOutput() {
        int[][] array = {};
        challenge.findMaxInRows(array);

        String expectedOutput = "";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    // Testing sortByColumn

    @Test
    void sortByColumn_ValidColumn_SortsCorrectly() {
        int[][] array = {
                { 14, 73, 28, 42 },
                { 39, 91, 19, 46 },
                { 67, 34, 89, 75 }
        };
        challenge.sortByColumn(array, 1); // Sort by the second column (index 1)

        String expectedOutput = "67 34 89 75 \n14 73 28 42 \n39 91 19 46 \n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    void sortByColumn_InvalidColumnIndex_ThrowsException() {
        int[][] array = {
                { 14, 73, 28, 42 },
                { 39, 91, 19, 46 },
                { 67, 34, 89, 75 }
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            challenge.sortByColumn(array, 5); // Invalid column index
        });

        assertEquals("Invalid column index", exception.getMessage());
    }

    @Test
    void sortByColumn_EmptyArray_NoOutput() {
        int[][] array = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            challenge.sortByColumn(array, 0); // Sorting an empty array
        });

        assertEquals("Invalid column index", exception.getMessage());
    }

}
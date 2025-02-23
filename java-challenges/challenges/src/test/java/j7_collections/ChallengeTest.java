package j7_collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.nology.j7_collections.Challenge;

public class ChallengeTest {
    private Challenge challenge;

    @BeforeEach
    void setUp() {
        challenge = new Challenge();
    }

    @AfterEach
    void tearDown() {
    }

    // Testing reverseList

    @Test
    public void testReverseList() {
        List<String> names = List.of("Andy", "Sam", "Bex", "Ollie");
        List<String> expected = List.of("Ollie", "Bex", "Sam", "Andy");
        assertEquals(expected, challenge.reverseList(names));

        List<String> emptyList = new ArrayList<>();
        assertEquals(emptyList, challenge.reverseList(emptyList));
    }

    // Testing findMaxValue

    @Test
    public void testFindMaxValue() {
        List<Integer> numbers = List.of(10, 20, 5, 30, 25);
        assertEquals(30, challenge.findMaxValue(numbers));

        List<Integer> singleElementList = List.of(42);
        assertEquals(42, challenge.findMaxValue(singleElementList));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            challenge.findMaxValue(new ArrayList<>());
        });
        assertEquals("List is empty", exception.getMessage());
    }

    // Testing rotateListRight

    @Test
    public void testRotateListRight() {
        List<String> items = List.of("A", "B", "C", "D", "E");
        List<String> expected = List.of("D", "E", "A", "B", "C");
        assertEquals(expected, challenge.rotateListRight(items, 2));

        List<String> expectedNoRotation = List.of("A", "B", "C", "D", "E");
        assertEquals(expectedNoRotation, challenge.rotateListRight(items, 0));

        List<String> expectedFullRotation = List.of("A", "B", "C", "D", "E");
        assertEquals(expectedFullRotation, challenge.rotateListRight(items, 5));

        List<String> expectedOverRotation = List.of("D", "E", "A", "B", "C");
        assertEquals(expectedOverRotation, challenge.rotateListRight(items, 7));

        List<String> emptyList = new ArrayList<>();
        assertEquals(emptyList, challenge.rotateListRight(emptyList, 3));
    }

}

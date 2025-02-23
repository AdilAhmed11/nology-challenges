package j8_hash_maps_and_streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.nology.j8_hash_maps_and_streams.Challenge;

public class ChallengeTest {

    private Challenge challenge;

    @BeforeEach
    void setUp() {
        challenge = new Challenge();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testCountWordOccurrences() {
        String sentence = "This is a test. This test is only a test.";
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("this", 2);
        expected.put("is", 2);
        expected.put("a", 2);
        expected.put("test", 3); // Corrected: "test" should be counted 3 times without punctuation
        expected.put("only", 1);

        assertEquals(expected, challenge.countWordOccurrences(sentence));

        String emptySentence = "";
        HashMap<String, Integer> expectedEmpty = new HashMap<>();
        assertEquals(expectedEmpty, challenge.countWordOccurrences(emptySentence));
    }

    @Test
    public void testMergeStudentScores() {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Alice", 85);
        map1.put("Bob", 90);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Bob", 10);
        map2.put("Charlie", 75);

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Alice", 85);
        expected.put("Bob", 100);
        expected.put("Charlie", 75);

        assertEquals(expected, challenge.mergeStudentScores(map1, map2));

        HashMap<String, Integer> emptyMap = new HashMap<>();
        assertEquals(map1, challenge.mergeStudentScores(map1, emptyMap));
    }

    @Test
    public void testFindMostFrequentCharacter() {
        String input = "banana";
        char expected = 'a'; // 'a' and 'n' both appear twice, but 'a' is found first
        assertEquals(expected, challenge.findMostFrequentCharacter(input));

        String singleChar = "x";
        assertEquals('x', challenge.findMostFrequentCharacter(singleChar));

        String emptyInput = "";
        assertThrows(IllegalArgumentException.class, () -> {
            challenge.findMostFrequentCharacter(emptyInput);
        });
    }

    @Test
    public void testCalculateAverageWordLength() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        double expectedAverage = (5 + 6 + 6) / 3.0;
        assertEquals(expectedAverage, challenge.calculateAverageWordLength(words), 0.001);

        List<String> emptyList = Arrays.asList();
        assertEquals(0.0, challenge.calculateAverageWordLength(emptyList), 0.001);
    }

    @Test
    public void testFilterPrimes() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, challenge.filterPrimes(numbers));

        List<Integer> noPrimes = Arrays.asList(4, 6, 8, 10);
        List<Integer> expectedNoPrimes = Arrays.asList();
        assertEquals(expectedNoPrimes, challenge.filterPrimes(noPrimes));
    }

    @Test
    public void testConcatenateWithCommas() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        String expected = "apple, banana, cherry";
        assertEquals(expected, challenge.concatenateWithCommas(strings));

        List<String> singleString = Arrays.asList("apple");
        String expectedSingle = "apple";
        assertEquals(expectedSingle, challenge.concatenateWithCommas(singleString));

        List<String> emptyList = Arrays.asList();
        String expectedEmpty = "";
        assertEquals(expectedEmpty, challenge.concatenateWithCommas(emptyList));
    }
}

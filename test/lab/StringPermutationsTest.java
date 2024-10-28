package lab;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringPermutationsTest {

    @Test
    public void testGeneratePermutations() {
        List<String> permutations = StringPermutations.generatePermutations("abc");
        assertEquals(6, permutations.size(), "There should be 6 unique permutations for 'abc'.");
        assertTrue(permutations.contains("abc"));
        assertTrue(permutations.contains("acb"));
        assertTrue(permutations.contains("bac"));
        assertTrue(permutations.contains("bca"));
        assertTrue(permutations.contains("cab"));
        assertTrue(permutations.contains("cba"));
    }

    @Test
    public void testEmptyString() {
        List<String> permutations = StringPermutations.generatePermutations("");
        assertEquals(1, permutations.size(), "There should be 1 permutation for an empty string.");
        assertEquals("", permutations.get(0), "The only permutation of an empty string should be an empty string.");
    }

    @Test
    public void testSingleCharacter() {
        List<String> permutations = StringPermutations.generatePermutations("a");
        assertEquals(1, permutations.size(), "There should be 1 permutation for a single character.");
        assertEquals("a", permutations.get(0), "The only permutation of 'a' should be 'a'.");
    }

    @Test
    public void testDuplicateCharacters() {
        List<String> permutations = StringPermutations.generatePermutations("aab");
        assertEquals(3, permutations.size(), "There should be 3 unique permutations for 'aab'.");
        assertTrue(permutations.contains("aab"));
        assertTrue(permutations.contains("aba"));
        assertTrue(permutations.contains("baa"));
    }
}


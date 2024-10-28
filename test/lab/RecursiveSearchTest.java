package lab;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RecursiveSearchTest {

    @Test
    public void testFileFound() {
        List<String> results = new ArrayList<>();
        File directory = new File("/home/scorpius/testDir");
        RecursiveSearch.searchFile(directory, "testFile.txt", results);
        assertFalse(results.isEmpty(), "File should be found in the directory.");
    }

    @Test
    public void testFileNotFound() {
        List<String> results = new ArrayList<>();
        File directory = new File("/home/scorpius/testDir");
        RecursiveSearch.searchFile(directory, "nonexistent.txt", results);
        assertTrue(results.isEmpty(), "File should not be found in the directory.");
    }

    @Test
    public void testCaseInsensitiveSearch() {
        List<String> results = new ArrayList<>();
        RecursiveSearch.setCaseSensitive(false); // Use the setter to change case sensitivity
        File directory = new File("/home/scorpius/testDir");
        RecursiveSearch.searchFile(directory, "Testfile.txt", results);
        assertFalse(results.isEmpty(), "File should be found with case-insensitive search.");
    }

    @Test
    public void testInvalidDirectory() {
        List<String> results = new ArrayList<>();
        File directory = new File("/invalidDir");
        RecursiveSearch.searchFile(directory, "file.txt", results);
        assertTrue(results.isEmpty(), "No files should be found in an invalid directory.");
    }
}

package lab;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursiveSearch {
    private static boolean caseSensitive = true;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RecursiveFileSearch <directory> <fileName> [caseSensitive]");
            return;
        }

        String directoryPath = args[0];
        String fileName = args[1];
        if (args.length > 2) {
            caseSensitive = Boolean.parseBoolean(args[2]);
        }

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        List<String> foundFiles = new ArrayList<>();
        searchFile(directory, fileName, foundFiles);

        if (foundFiles.isEmpty()) {
            System.out.println("File not found.");
        } else {
            foundFiles.forEach(System.out::println);
        }
    }

    public static void searchFile(File directory, String fileName, List<String> foundFiles) {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchFile(file, fileName, foundFiles);
            } else if (matches(file.getName(), fileName)) {
                foundFiles.add("File found at: " + file.getAbsolutePath());
            }
        }
    }

    private static boolean matches(String fileName1, String fileName2) {
        return caseSensitive ? fileName1.equals(fileName2) : fileName1.equalsIgnoreCase(fileName2);
    }

    // Setter for testing
    public static void setCaseSensitive(boolean caseSensitive) {
        RecursiveSearch.caseSensitive = caseSensitive;
    }
}

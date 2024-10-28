package lab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = generatePermutations(input);
        System.out.println("Permutations: " + permutations);
    }

    public static List<String> generatePermutations(String str) {
        Set<String> results = new HashSet<>();
        generatePermutationsHelper(str, "", results);
        return new ArrayList<>(results);
    }

    private static void generatePermutationsHelper(String str, String prefix, Set<String> results) {
        if (str.isEmpty()) {
            results.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String remaining = str.substring(0, i) + str.substring(i + 1);
                generatePermutationsHelper(remaining, prefix + ch, results);
            }
        }
    }
}


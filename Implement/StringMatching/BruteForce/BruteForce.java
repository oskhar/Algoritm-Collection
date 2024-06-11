package Implement.StringMatching.BruteForce;

public class BruteForce {
    public static void handle(String string, String pattern) {
        int sLen = string.length();
        int pLen = pattern.length();
        boolean found = false;
        int i;

        System.out.println("String: " + string);
        System.out.println("Pattern: " + pattern);
        System.out.println("Starting brute force string matching...");

        for (i = 0; i < sLen - pLen + 1; i++) {
            int j = 0;
            for (; j < pLen; j++) {
                System.out.println("Comparing string[" + (i + j) + "] = " + string.charAt(i + j) + " with pattern[" + j + "] = " + pattern.charAt(j));
                if (string.charAt(i + j) != pattern.charAt(j)) {
                    System.out.println("Characters do not match, moving to the next starting position.");
                    break;
                }
            }
            if (j == pLen) {  // If we have reached end of pattern, we have found the pattern in string
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Found pattern at index: " + i);
        } else {
            System.out.println("Could not find pattern");
        }
    }
}
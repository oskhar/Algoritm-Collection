package Implement.Compression.RLE;

import java.util.regex.Pattern;

public class RunLengthEncoding {

    public static String compress(String text) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");
        pattern.matcher(text).results().forEach(result -> {
            int repetitions = result.group(1).length();
            sb.append(result.group(2)).append(repetitions);
        });
        return sb.toString();
    }

    public static String decompress(String text) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("([a-zA-Z])([0-9]*)");
        pattern.matcher(text).results().forEach(result -> {
            int count = Integer.parseInt(result.group(2));
            sb.append(result.group(1).repeat(count));
        });
        return sb.toString();
    }

    public static String classicCompress(String text) {
        StringBuilder sb = new StringBuilder();
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            int charCount = 1;
            while (textIndex < text.length() - 1 && text.charAt(textIndex) == text.charAt(textIndex + 1)) {
                charCount++;
                textIndex++;
            }
            sb.append(text.charAt(textIndex)).append(charCount);
        }
        return sb.toString();
    }

    public static String classicDecompress(String text) {
        StringBuilder sb = new StringBuilder();
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            if (Character.isDigit(text.charAt(textIndex))) {
                int charCount = Character.getNumericValue(text.charAt(textIndex));
                while (charCount-- != 1) sb.append(text.charAt(textIndex - 1));
            } else {
                sb.append(text.charAt(textIndex));
            }
        }
        return sb.toString();
    }

}
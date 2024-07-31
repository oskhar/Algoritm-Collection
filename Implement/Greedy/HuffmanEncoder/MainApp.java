package Implement.Greedy.HuffmanEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MainApp {

    public static boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    public static void printCode(HuffmanNode node, String s, Map<Character, String> huffmanCodeMap) {
        if (node == null) {
            return;
        }

        // If the current node represents a character, print its code
        if (isLetter(node.charData)) {
            System.out.println(node.charData + "   |  " + s);
            huffmanCodeMap.put(node.charData, s);
        }

        // Recursively print codes for the left and right subtrees
        printCode(node.left, s + "0", huffmanCodeMap);
        printCode(node.right, s + "1", huffmanCodeMap);
    }

    public static String decodeString(String encodedString, HuffmanNode root) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode current = root;
        for (int i = 0; i < encodedString.length(); i++) {
            current = encodedString.charAt(i) == '0' ? current.left : current.right;

            // Reached a leaf node
            if (isLetter(current.charData)) {
                decodedString.append(current.charData);
                current = root;
            }
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {

        System.out.println("Text: contoh teks 'abcbe'\n");
        char[] charArray = {'A', 'B', 'C', 'D', 'E'};
        int[] char_frequency = {1, 6, 7, 2, 8};

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(charArray.length, new ImplementComparator());

        System.out.println("Step 1: Initial nodes with their frequencies:");
        for (int i = 0; i < charArray.length; i++) {
            HuffmanNode node = new HuffmanNode();
            node.charData = charArray[i];
            node.data = char_frequency[i];
            node.left = null;
            node.right = null;

            System.out.println("Character: " + node.charData + ", Frequency: " + node.data);
            queue.add(node);
        }

        HuffmanNode root = null;

        System.out.println("\nStep 2: Constructing the Huffman Tree:");
        while (queue.size() > 1) {

            HuffmanNode min_freq_node = queue.poll();
            HuffmanNode second_min_freq_node = queue.poll();

            HuffmanNode f_node = new HuffmanNode();
            f_node.data = min_freq_node.data + second_min_freq_node.data;
            f_node.charData = '-';
            f_node.left = min_freq_node;
            f_node.right = second_min_freq_node;

            root = f_node;

            System.out.println("Combine nodes: ('" + min_freq_node.charData + "', " + min_freq_node.data + ") + ('" +
                               second_min_freq_node.charData + "', " + second_min_freq_node.data + ") = New node ('-', " + f_node.data + ")");
            queue.add(f_node);
        }

        Map<Character, String> huffmanCodeMap = new HashMap<>();
        System.out.println("\nStep 3: Huffman Codes:");
        printCode(root, "", huffmanCodeMap);
    }
}

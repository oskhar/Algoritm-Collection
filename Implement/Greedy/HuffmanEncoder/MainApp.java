package Implement.Greedy.HuffmanEncoder;

import java.util.PriorityQueue;

public class MainApp {

    public static boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    public static void printCode(HuffmanNode node, String s) {
        if (node == null) {
            return;
        }

        // If the current node represents a character, print its code
        if (isLetter(node.charData)) {
            System.out.println(node.charData + "   |  " + s);
        }

        // Recursively print codes for the left and right subtrees
        printCode(node.left, s + "0");
        printCode(node.right, s + "1");
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println("Text: BCAADDDCCACACAC\n");
        char[] charArray = {'B', 'C', 'A', 'D'};
        int[] char_frequency = {1, 6, 5, 3};

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(n, new ImplementComparator());

        System.out.println("Step 1: Initial nodes with their frequencies:");
        for (int in = 0; in < n; in++) {
            HuffmanNode node = new HuffmanNode();
            node.charData = charArray[in];
            node.data = char_frequency[in];
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

        System.out.println("\nStep 3: Huffman Codes:");
        printCode(root, "");
    }
}
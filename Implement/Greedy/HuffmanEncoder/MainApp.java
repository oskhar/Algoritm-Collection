package Implement.Greedy.HuffmanEncoder;

import java.util.PriorityQueue;

// Huffman algorithm
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

        char[] charArray = {
                'B',
                'C',
                'A',
                'D'
        };
        int[] char_frequency = {
                1,
                6,
                5,
                3
        };

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

        for (int in = 0; in < n; in++) {
            HuffmanNode node = new HuffmanNode();

            node.charData = charArray[in];
            node.data = char_frequency[in];

            node.left = null;
            node.right = null;

            queue.add(node);
        }

        HuffmanNode root = null;

        while (queue.size() > 1) {

            HuffmanNode min_freq_node = queue.poll();
            HuffmanNode second_min_freq_node = queue.poll();

            HuffmanNode f_node = new HuffmanNode();

            f_node.data = min_freq_node.data + second_min_freq_node.data;
            f_node.charData = '-';
            f_node.left = min_freq_node;
            f_node.right = second_min_freq_node;

            root = f_node;

            queue.add(f_node);
        }
        printCode(root, "");
    }
}
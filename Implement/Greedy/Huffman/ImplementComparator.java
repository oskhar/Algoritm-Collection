package Implement.Greedy.Huffman;

import java.util.Comparator;

// Comparing two nodes
class ImplementComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.data - node2.data;
    }
}
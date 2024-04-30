package Implement.Greedy.HuffmanEncoder;

import java.util.Comparator;

public class ImplementComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.data - node2.data;
    }
}
package Implement.Greedy.HuffmanEncoder;

class ImplementComparator implements java.util.Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

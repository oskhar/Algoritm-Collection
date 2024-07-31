package Implement.Tree.Trie;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private final char character;
    private boolean isEndOfWord;
    private Map<Character, Node> children = new HashMap<>();

    public Node(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "character=" + character +
                ", isEndOfWord=" + isEndOfWord +
                '}';
    }
}

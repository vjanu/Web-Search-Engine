package com.acc.se.autocomplete;

import java.util.HashMap;
import java.util.Map;

public class Node {
    char character;
    boolean isWord;

    Map<Character, Node> children;

    public Node(char character) {
        this.character = character;
        children = new HashMap<>();
    }

    public Node() {
        children = new HashMap<>();
    }

    private Node insertChild(char character) {
        Node node = new Node(character);
        children.put(character, node);
        return node;
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) return;

        char initial = word.charAt(0);
        Node child = (children.get(initial) == null) ? insertChild(initial) : children.get(initial);

        if (word.length() > 1) child.insert(word.substring(1));
        else child.isWord = true;
    }
}

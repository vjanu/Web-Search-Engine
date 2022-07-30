package com.acc.se.autocomplete;

import java.util.*;

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(List<String> words) {
        for (String word : words)
            root.insert(word);
    }

    public void insert(String word) {
        root.insert(word);
    }

    public void suggestHelper(Node root, List<String> list, StringBuffer curr) {
        if (root.isWord) list.add(curr.toString());
        if (root.children == null || root.children.isEmpty()) return;

        for (Node child : root.children.values()) {
            suggestHelper(child, list, curr.append(child.character));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        Node lastNode = root;

        List<String> suggestions = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        for (char current : prefix.toCharArray()) {
            lastNode = lastNode.children.get(current);
            if (lastNode == null) return suggestions;
            buffer.append(current);
        }

        suggestHelper(lastNode, suggestions, buffer);
        return suggestions;
    }
}

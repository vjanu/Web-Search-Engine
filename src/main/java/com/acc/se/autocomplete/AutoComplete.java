package com.acc.se.autocomplete;

import java.io.*;
import java.util.List;

public class AutoComplete {
    Trie wordTrie;

    public AutoComplete(String path) throws IOException {
        String line;
        wordTrie = new Trie();

        File file = new File("src/main/resources/static/data/text/nounlist.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((line = reader.readLine()) != null)
            wordTrie.insert(line);
    }

    private List<String> suggest(String prefix) {
        return wordTrie.suggest(prefix);
    }
}

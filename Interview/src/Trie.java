/**
 * Created by kapilkrishnakumar on 10/18/15.
 */
import java.util.*;
public class Trie {

    TrieNode root;

    public boolean contains(String prefix, boolean exact){
        TrieNode lastNode = root;
        for(int i = 0; i < prefix.length(); i++){
            lastNode = lastNode.children.get(prefix.charAt(i));
            if(lastNode == null) return false;
        }

        return !exact || lastNode.terminates;
    }


    private class TrieNode {
        char character;
        HashMap<Character, TrieNode> children;
        boolean terminates;


        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
        }

        public TrieNode(char c) {
            this();
            this.character = c;

        }

        public void addWord(String word) {
            if (word == null || word.isEmpty())
                return;

            char firstChar = word.charAt(0);
            TrieNode child = children.get(firstChar);
            if(child == null){
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }

            if(word.length() > 1){
                child.addWord(word.substring(1));
            } else
                terminates = true;
        }
    }


}

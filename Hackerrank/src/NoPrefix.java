/**
 * Created by kapilkrishnakumar on 10/18/15.
 */
import java.util.*;

public class NoPrefix {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        Trie tr = new Trie();
        tr.root = new TrieNode(' ');
        for(int i = 1; i < w; i ++){
            String word = sc.next();
//            System.out.println(word);
            if(!tr.add(word)){
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }
        System.out.println("GOOD SET");
//
//        Stack<TrieNode> q = new Stack<TrieNode>();
//        TrieNode last = tr.root;
//        StringBuffer path = new StringBuffer();
//        q.push(last);
//        while(!q.isEmpty()){
//            last = q.pop();
//            if(last.character != ' '){
//                path.append(last.character);
//                if(last.terminates) {
//                    if(last.children != null && last.children.size() > 0){
//
//
//
//                        break;
//                    }
//                }
//                for(char tn : last.children.keySet())
//                    q.add(last.children.get(tn));
//            }
//
//        }
    }


    public static class Trie {

        TrieNode root;

        public boolean contains(String prefix, boolean exact){
            TrieNode lastNode = root;
            for(int i = 0; i < prefix.length(); i++){
                lastNode = lastNode.children.get(prefix.charAt(i));
                if(lastNode == null) return false;
            }

            return !exact || lastNode.terminates;
        }

        public boolean add(String word){
            TrieNode node = root;
            int index = 0;
            while (index < word.length()) {
                node.terminates = false;
                char c = word.charAt(index);
                if (node.children.get(c) == null) {
                    node.children.put(c, new TrieNode(c));
                } else if (node.children.get(c).terminates || index == word.length() - 1) {
                    return false;
                }
                node = node.children.get(c);
                index++;
            }
            return true;
        }

    }

    public static class TrieNode {
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

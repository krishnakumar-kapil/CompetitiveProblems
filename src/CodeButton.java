import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/9/15.
 */
public class CodeButton {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int init = sc.nextInt();
        int fin = sc.nextInt();
//        System.out.println(init + " "+fin);

        Map<Node, Set<Node>> g = new HashMap<Node, Set<Node>>();
        Node initNode = new Node(init);
        Node current = initNode;

        while(current.value < 10000){
            Node childNeg = new Node(current.value - 1);
            Node childDoub = new Node(current.value * 2);
            Set<Node> s = new HashSet<Node>();
            s.add(childNeg);
            s.add(childDoub);
            g.put(current, s);
        }

    }

    public static class Node{
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}

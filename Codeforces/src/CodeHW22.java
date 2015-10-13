import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by kapilkrishnakumar on 9/8/15.
 */
public class CodeHW22 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int init = sc.nextInt();
        int fin = sc.nextInt();
//        System.out.println(init + " "+fin);

//        Queue<Node> q = new LinkedList<Node>();
//        Set<Integer> vis = new HashSet<Integer>();
//        Node initN = new Node(init, 0);
//        q.add(initN);
//        vis.add(initN.value);
//        Node current = initN;
//        while(q.size() > 0){
//            current = q.remove();
//            System.out.println(current.value);
//            if(current.value == fin){
//                System.out.println(current.pathNum);
//                return;
//            } else{
//                int value = current.value - 1;
//                if(value > 0 && value >= (fin /2 - 1) && !vis.contains(value) ){
//                    q.add(new Node(current.value - 1, current.pathNum + 1));
//                }
//                value = current.value * 2;
//
//                if(value <= 2 * fin  && !vis.contains(value) ) {
//                    q.add(new Node(current.value * 2, current.pathNum + 1));
//                }
//            }
////            System.out.println(q.size());
//        }
////        System.out.println(0);

        Queue<Node> q = new LinkedList<Node>();
        Set<Integer> vis = new HashSet<Integer>();
        Node initN = new Node(fin, 0);
        q.add(initN);
        vis.add(initN.value);
        Node current = initN;
        while(q.size() > 0){
            current = q.remove();
//            System.out.println(current.value);
            if(current.value == init){
                System.out.println(current.pathNum);
                return;
            } else{
//                System.out.println(q);
                int value = current.value + 1;
                if(current.value <= init && !vis.contains(value) ){

                    int temp = value;
                    int path = 0;
                    while(temp<=init) {
                        path++;
                        temp++;
                    }
//                    System.out.println(current.pathNum+ path);
//                    return;
                    q.add(new Node(init, current.pathNum +path));
                } else {
                    value = current.value / 2;
                    if (current.value % 2 == 0 && !vis.contains(value)) {
                        q.add(new Node(current.value / 2, current.pathNum + 1));
                    } else if (current.value % 2 == 1 && !vis.contains(value)) {
                        value = (current.value + 1) / 2;
                        q.add(new Node(value, current.pathNum + 2));
                    }
                }
            }
//            System.out.println(q);
        }
//        System.out.println(0);


    }

    static class Node
    {
        int value;
        int pathNum;

        public Node(int value, int pathNum) {
            this.value = value;
            this.pathNum = pathNum;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", pathNum=" + pathNum +
                    '}';
        }
    }

}

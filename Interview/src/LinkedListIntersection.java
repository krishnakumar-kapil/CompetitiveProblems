/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
import java.util.*;
public class LinkedListIntersection {


    public static Node getIntersection(Node a, Node b){


        //compare nodes using ==
        //N^2 algo would be to cycle through every node and see whether they are the same


        //better would be to store the nodes of B in a hashset and see whether the current node of A is contained in them..
        //O(N) O(N)


        //O(N) O(1)


        //if tails are different then return immediately ...
        //advance pointer of the longer one till its length is equal to the other one

        return null;
    }


    public class Node {
        int val;
        Node next;
    }
}

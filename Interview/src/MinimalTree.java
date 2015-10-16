/**
 * Created by kapilkrishnakumar on 10/14/15.
 */
import java.util.*;
public class MinimalTree {

    public Node minimalTree(int[] a){
        if(a.length == 0)
            return null;
        return helper(a, 0, a.length - 1);
    }

    private Node helper(int[] a, int low, int high){
        if(low < high)
            return null;
        int mid = low + (high - low)/2;
        Node n = new Node();
        n.val = a[mid];
        n.leftChild = helper(a, low, mid - 1);
        n.rightChild = helper(a, mid + 1, high);
        return n;
    }

    public class Node{
        int val;
        Node leftChild;
        Node rightChild;
    }
}

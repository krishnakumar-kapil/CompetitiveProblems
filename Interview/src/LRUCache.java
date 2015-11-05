/**
 * Created by kapilkrishnakumar on 10/27/15.
 */
import java.util.*;
public class LRUCache {

    private int maxSize;
    HashMap<Integer, LinkedListNode> map;
    private LinkedListNode listHead;
    public LinkedListNode listTail;

    public LRUCache(int size){
        maxSize = size;
    }

    public String getValue(int key){
        LinkedListNode item = map.get(key);

        if(item == null) return null;

        if(item != listHead){
            removeFromLinkedList(item);
            insertAtFrontOfLinkedList(item);
        }
        return item.val;
    }

    private void removeFromLinkedList(LinkedListNode node){
        if(node == null) return;

        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
        if(node == listTail) listTail = node.prev;
        if(node == listHead) listHead = node.next;
    }

    private void insertAtFrontOfLinkedList(LinkedListNode item){
        if(item == null) return;

        if(listHead == null){
            listHead = item;
            listTail = item;
        } else {
            item.next = listHead;
            listHead.prev = item;
            listHead = item;
        }
    }

    public boolean removeKey(int key){
        LinkedListNode node = map.get(key);
        removeFromLinkedList(node);
        map.remove(key);
        return true;
    }

    public void setKeyValue(int key, String value){
        removeKey(key);

        if(map.size() >= maxSize && listTail != null){
            removeKey(listTail.key);
        }

        LinkedListNode node = new LinkedListNode(value, key);
        insertAtFrontOfLinkedList(node);
        map.put(key, node);
    }

    public class LinkedListNode{
        String val;
        int key;
        LinkedListNode prev;
        LinkedListNode next;

        public LinkedListNode(String val, int key) {
            this.val = val;
            this.key = key;
        }
    }
}

/**
 * Created by kapilkrishnakumar on 10/16/15.
 */

import java.util.*;
public class SmallestKInArray {


    public List<Integer> getSmallestK(int[] a, int k){
        //O(Nlog N) -- linear....
        //We can't change the array -->
        //max heap ??? where the max is actually the kth element???
        //or have a min heap of size n and add

        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k , new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for(int i = 0; i < a.length ; i++){
            int val = a[i];
            if(maxheap.size() < k)
                maxheap.add(val);
            else {
                maxheap.poll();
                maxheap.add(val);
            }

        }

        return null;
    }
}

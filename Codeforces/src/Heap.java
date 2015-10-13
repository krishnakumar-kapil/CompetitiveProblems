/**
 * Created by kapilkrishnakumar on 10/5/15.
 */
public class Heap {

    private int heapSize;
    private int[] heap;

    public Heap(int cap) {
        heap = new int[cap];
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public void insert(int val){
        if(heapSize == heap.length)
            throw new IllegalStateException();

        heapSize++;
        heap[heapSize - 1] = val;
        heapifyUp(heapSize - 1);
    }

    private void heapifyUp(int index){
        int tmp = heap[index];
        while(index > 0 && tmp < heap[parent(index)]){
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = tmp;
    }

    private int kthChild(int i, int k)
    {
        return 2 * i + k;
    }

    private int parent(int i)
    {
        return (i - 1)/2;
    }


}

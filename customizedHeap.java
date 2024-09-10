import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomizedHeap{
    private List<Integer> heap;
    private int numChildren; 

        public CustomizedHeap(int x) {
        heap = new ArrayList<>();
        numChildren = 1 << x;
    }

        public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1; 
        heapifyUp(index);
    }

    
    public int popMax() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        heapifyDown(0);
        return max;
    }

 
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / numChildren;
        if (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            Collections.swap(heap, index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

   
    private void heapifyDown(int index) {
        int parIndex = index;
        for (int i = 1; i <= numChildren; i++) {
            int childIndex = numChildren * index + i;
            if (childIndex < heap.size() && heap.get(childIndex) > heap.get(parIndex)) {
                parIndex = childIndex;
            }
        }
        if (parIndex != index) {
            Collections.swap(heap, index, largest);
            heapifyDown(largest);
        }
    }

    public static void main(String[] args) {
        CustomizedHeap heap = new CustomizedHeap(2);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(15);

        System.out.println("Max: " + heap.popMax());
        System.out.println("Max: " + heap.popMax());
    }
}

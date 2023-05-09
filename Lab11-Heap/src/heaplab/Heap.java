package heaplab;

public class Heap {
    int[] heap;
    int size;
    public Heap(int capacity){
        heap = new int[capacity];
        size = 0;
    }
    public Heap(){
        this(100);
    }
    public boolean isFull(){
        return (size >= heap.length);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void printAll(){
        for (int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
    }
    public void enqueue(int newInfo){
        if (!isFull()){
            heap[size] = newInfo;
            int newValueIndex = size;
            size++;
            int parentIndex = (newValueIndex - 1)/ 2;
            //move up
            while (newValueIndex > 0 && heap[parentIndex] < heap[newValueIndex]){
                //swap
                int temp = heap[newValueIndex];
                heap[newValueIndex] = heap[parentIndex];
                heap[parentIndex] = temp;
                newValueIndex = parentIndex;
                parentIndex = (newValueIndex - 1)/2;

            }
        }
    }
    public int dequeue(){
        int root = heap[0];
        if (!isEmpty()){
            int lastElement = heap[size - 1];
            heap[0] = lastElement;
            size--;
            //move down
            int lastElementIndex = 0;
            int leftChildOfLastElement = lastElementIndex*2 +1;
            int rightChildOfLastElement = lastElementIndex*2 + 2;
            while ((leftChildOfLastElement < size && heap[lastElementIndex] < heap[leftChildOfLastElement])
                    || (rightChildOfLastElement < size && heap[lastElementIndex] < heap[rightChildOfLastElement])) {
                int swapIndex;
                if (leftChildOfLastElement == size - 1){ //if there is only left child
                    swapIndex = leftChildOfLastElement;
                } else if (heap[leftChildOfLastElement] > heap[rightChildOfLastElement]){
                    swapIndex = leftChildOfLastElement;
                } else {
                    swapIndex = rightChildOfLastElement;
                }
                int temp = heap[lastElementIndex];
                heap[lastElementIndex] = heap[swapIndex];
                heap[swapIndex] = temp;
                lastElementIndex = swapIndex;
                leftChildOfLastElement = lastElementIndex * 2 + 1;
                rightChildOfLastElement = lastElementIndex * 2 + 2;
            }
        } else {
            System.out.println("Heap is empty");
            root = -1;
        }
        return root;
    }
    public void heapSort(){
        //phase 1: arrange the array into the heap structure
        //phase 2: sort the heap
        //No need to do phase 1 here because we already work on the heap
        for (int last = size - 1; last > 0; last--){
            //swap root with last
            int temp = heap[last];
            heap[last] = heap[0];
            heap[0] = temp;
            //move down from root
            int lastElementIndex = 0;
            int leftChildOfLastElement = lastElementIndex*2 +1;
            int rightChildOfLastElement = lastElementIndex*2 + 2;
            while ((leftChildOfLastElement < last && heap[lastElementIndex] < heap[leftChildOfLastElement])
                    || (rightChildOfLastElement < last && heap[lastElementIndex] < heap[rightChildOfLastElement])) {
                int swapIndex;
                if (leftChildOfLastElement == last - 1){ //if there is only left child
                    swapIndex = leftChildOfLastElement;
                } else if (heap[leftChildOfLastElement] > heap[rightChildOfLastElement]){
                    swapIndex = leftChildOfLastElement;
                } else {
                    swapIndex = rightChildOfLastElement;
                }
                //swap
                temp = heap[lastElementIndex];
                heap[lastElementIndex] = heap[swapIndex];
                heap[swapIndex] = temp;
                lastElementIndex = swapIndex;
                leftChildOfLastElement = lastElementIndex * 2 + 1;
                rightChildOfLastElement = lastElementIndex * 2 + 2;
            }
        }
    }
}

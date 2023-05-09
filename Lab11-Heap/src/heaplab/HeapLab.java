package heaplab;

public class HeapLab {
    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.enqueue(50);
        h.enqueue(20);
        h.enqueue(300);
        h.enqueue(60);
        h.enqueue(250);
        h.enqueue(500);

        //          500
        //  250             3000
        //20    60      50
        h.printAll();
        System.out.println("");

        System.out.println(h.dequeue());
        //          300
        //  250             50
        //20    60
        h.printAll();
    }
}

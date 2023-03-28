package sortinglab;

public class SortingLab {
    public static void main(String[] args) {
        Data d1 = new Data(100);
        d1.addNewInfo(50); d1.addNewInfo(100);
        d1.addNewInfo(25); d1.addNewInfo(90);
        d1.addNewInfo(40); d1.addNewInfo(1200);
        d1.addNewInfo(21); d1.addNewInfo(25);
        d1.addNewInfo(12); d1.addNewInfo(30);

        Data d2 = new Data(100);
        d2.clone(d1);
        System.out.println("Selection Sort:");
        d2.printAll();
        d2.selectionSort();
        d2.printAll();

        Data d3 = new Data(100);
        d3.clone(d1);

        System.out.println("Insertion Sort:");
        d3.printAll();
        d3.insertionSort();
        d3.printAll();

        Data d4 = new Data(100); d4.clone(d1);

        System.out.println("Bubble Sort:");
        d4.printAll();
        d4.bubbleSort();
        d4.printAll();

        Data d5 = new Data(100); d5.clone(d1);

        System.out.println("Quick Sort:");
        d5.printAll();
        d5.quickSort(0, d5.size - 1);
        d5.printAll();
    }
}

package sortinglab;

public class SortingLab {
    public static void main(String[] args) {
        Data d1 = new Data(100);
        d1.addNewInfo(507); d1.addNewInfo(100);
        d1.addNewInfo(9401); d1.addNewInfo(9);
        d1.addNewInfo(40); d1.addNewInfo(1200);
        d1.addNewInfo(2195); d1.addNewInfo(60);
        d1.addNewInfo(834); d1.addNewInfo(25);
        d1.addNewInfo(512); d1.addNewInfo(30);

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


        Data d6 = new Data(100); d6.clone(d1);

        System.out.println("Radix Sort:");
        d6.printAll();
        d6.radixSort();
        d6.printAll();

        Data d7 = new Data(100); d7.clone(d1);

        System.out.println("Merge Sort:");
        d7.printAll();
        d7.mergeSort(0, d7.size - 1);
        d7.printAll();

        Data d8 = new Data(100); d8.clone(d1);

        System.out.println("Shell Sort:");
        d8.printAll();
        d8.shellSort();
        d8.printAll();
    }
}

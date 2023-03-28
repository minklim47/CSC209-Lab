package sortinglab;

public class SortingLab {
    public static void main(String[] args) {
        Data d1 = new Data(100);
        d1.addNewInfo(50); d1.addNewInfo(100);
        d1.addNewInfo(25); d1.addNewInfo(90);
        d1.addNewInfo(40); d1.addNewInfo(1200);
        d1.addNewInfo(21); d1.addNewInfo(25);
        d1.addNewInfo(12); d1.addNewInfo(30);
        d1.printAll();
        d1.selectionSort();
        d1.printAll();
    }
}

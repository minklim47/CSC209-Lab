package sortinglab;

public class Data {
    int[] info;
    int capacity;
    int size;

    public Data(){
        this(100);
    }
    public Data(int c){
        capacity = c;
        info = new int[capacity];
        size = 0;
    }
    public int addNewInfo(int newInfo){
        info[size] = newInfo;
        size++;
        return size;
    }
    public int clone(Data d){
        size = 0;
        for (int i = 0; i < d.size; i++){
            info[i] = d.info[i];
            size++;
        }
        return size;
    }
    public void swap(int index1, int index2){
        int temp = info[index1];
        info[index1] = info[index2];
        info[index2] = temp;
    }

    public void selectionSort(){
        for (int i = 0; i < size - 1; i++){
            int smallestIndex = i;
            for (int j = i + 1; j < size; j++){
                if (info[j] < info[smallestIndex]){
                    smallestIndex = j;
                }
            }
            swap(i, smallestIndex);
        }
    }
    public void insertionSort(){
        //5, 23, 44, 55, 16
        //5, 16, 23, 44, 55
        for (int i = 1; i < size; i++){
            int valueAti = info[i];
            int j;
            for (j = i - 1; j >= 0 && info[j] > valueAti; j--){
                info[j+1] = info[j];
            }
            info[j+1] = valueAti;
        }
    }
    public void bubbleSort(){
        //50              8
        //8           8   50
        //25      10  10  10
        //30  10  25  25  25
        //10  30  30  30  30
        for (int i = 0; i < size-1; i++){
            for (int j = size - 1; j > i; j--){
                if (info[j - 1] > info[j]){
                    swap(j-1, j);
                }
            }
        }
    }

    public void quickSort(int first, int last){
        if (first >= last) {
            return;
        }
        int pivot = info[first];
        int lower = first + 1;
        int upper = last;
        while (lower <= upper){
            while (lower <= last && info[lower] < pivot){
                //seach info that is bigger than pivot
                lower++;
            }
            while(upper > first && info[upper] >= pivot){
                //search info that is smaller than pivot
                upper--;
            }
            if (lower < upper){
                swap(lower, upper); lower++; upper--;
            }
        }
        swap(first, upper);
        quickSort(first, upper - 1);
        quickSort(upper + 1, last);
    }
    public void printAll(){
        for (int i = 0; i < size; i++){
            System.out.print(info[i] + " ");
        }
        System.out.println();
    }
}

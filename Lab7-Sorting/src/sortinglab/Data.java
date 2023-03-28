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
        for (int i = 0; i < size; i++){
            int smallestIndex = i;
            for (int j = i + 1; j < size; j++){
                if (info[j] < info[smallestIndex]){
                    smallestIndex = j;
                }
            }
            swap(i, smallestIndex);
        }
    }

    public void printAll(){
        for (int i = 0; i < size; i++){
            System.out.print(info[i] + " ");
        }
        System.out.println();
    }
}

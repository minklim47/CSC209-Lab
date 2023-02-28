public class Stack {
    int[] st;
    int top;

    public Stack(int capacity){
        st = new int[capacity];
        top = 0;
    }
    public Stack(){
        this(100);
    }
    public boolean isFull(){
        return top >= st.length;
    }
    public int pop(){

    }
    public void push(int newMember){
        st[top] = newMember;
        top++;
    }
}
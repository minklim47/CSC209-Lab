package sll_lab;

public class SinglyLinkedList {
    SLLNode head, tail;
    public SinglyLinkedList() {
        head = tail = null;
    }
    public void addToTail(int newValue){
        //special case : the list has no node
        if (head == null){
            head = tail = new SLLNode(newValue, null);
        }
        else {
            tail.next = new SLLNode(newValue, null);
            tail = tail.next;
        }
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(int newValue){
        if (isEmpty()) {
            head = tail = new SLLNode(newValue, head);
        }else {
            head = new SLLNode(newValue, head);
        }
        //1) create new node
        //2) put value of newValue into the new node
        //3) make the next of the new node pointing to the original head
        //4) head points to the new node [head = ...]
        //new node
        //head will point to the new node
    }

    public void printAllNode() {
        for (SLLNode temp = head; temp != null; temp = temp.next){
            System.out.print(temp.info + " => ");
        }
        System.out.println(" end at null");
    }
    public int deleteFromHead(){
        int firstInfo = head.info;
        //special case  ; list has no node OR list has only 1 node
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return firstInfo;
    }

    public int deleteFromTail(){
        if (head == null){
            return -1;
        }else if (head == tail){
            int lastInfo = tail.info;
            head = tail = null;
            return lastInfo;
        }
        else {
            int lastInfo = tail.info;
            SLLNode temp;
            for (temp = head; temp.next != tail; temp=temp.next);   //loop of searching

            //temp will stop at the (n-1)th node [one before last]
            temp.next = null;
            tail = temp;
            return lastInfo;
        }
    }
//    public int deleteIthNode(int i){
//
//    }
//    public void insertNodeAtIthMiddle(int i, int newValue){
//
//    }
}



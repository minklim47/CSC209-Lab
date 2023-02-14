package sll_lab;

public class SLLNode {
    int info;
    SLLNode next;

    public SLLNode(int info, SLLNode next) {
        this.info = info;
        this.next = next;
    }

    public SLLNode (int info){
        this(info, null);
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public SLLNode getNext() {
        return next;
    }

    public void setNext(SLLNode next) {
        this.next = next;
    }
}

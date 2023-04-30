package binarysearchtreelab;

public class BSTnode {
    int info;
    BSTnode left,right;

    public BSTnode(int info, BSTnode left, BSTnode right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public BSTnode(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
    public void visit(){
        System.out.println(info + " ");
    }
}

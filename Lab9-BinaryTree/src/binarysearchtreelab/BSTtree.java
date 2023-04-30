package binarysearchtreelab;

public class BSTtree {
    BSTnode root;

    public BSTtree(){
        root = null;
    }
    //insert method
    //print all node => traverse => tree traversal
    //delete node
    //search on the tree
    //balance
    public void insert(int newInfo){
        BSTnode temp = root;
        if (root == null) {
            root = new BSTnode(newInfo, null, null);
            return;
        }
        while(true){
            if (newInfo < temp.info && temp.left != null){
                temp = temp.left;
            }else if (newInfo >= temp.info && temp.right != null){
                temp = temp.right;
            }else if (newInfo < temp.info && temp.left == null){
                temp.left = new BSTnode(newInfo,null,null);
                break;
            } else if (newInfo >= temp.info && temp.right == null){
                temp.right = new BSTnode(newInfo,null,null);
                break;
            }
        }
    }

    public BSTnode search(int key){
        BSTnode temp = root;
        if (root == null) {
            return null;
        }
        while(true) {
            if (key == temp.info) {
                return temp;
            } else {
                if (key < temp.info && temp.left != null) {
                    temp = temp.left;
                } else if (key > temp.info && temp.right != null) {
                    temp = temp.right;
                } else {
                    return null;
                }
            }
        }
    }
}

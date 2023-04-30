package binarysearchtreelab;

public class BinarySearchTreeLab {
    public static void main(String[] args) {
        BSTtree tree1 = new BSTtree();
        tree1.insert(59);
        tree1.insert(100);
        tree1.insert(20);
        tree1.insert(200);
//                    59
//                20      100
//                            200
        System.out.println(tree1.root.info);
        System.out.println(tree1.root.right.info);
        System.out.println(tree1.root.right.right.info);
        System.out.println(tree1.root.left.info);

        BSTnode s = tree1.search(200);
        if (s != null){
            System.out.println(s.info);
        } else {
            System.out.println("not found");
        }
       
    }

}

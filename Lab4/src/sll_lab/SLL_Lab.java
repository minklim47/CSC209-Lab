package sll_lab;

public class SLL_Lab {
    public static void main(String[] args) {
        SLLNode node1 = new SLLNode(30);
        System.out.println(node1.info + " " + node1.next);
        SLLNode node2 = new SLLNode(40, node1);
        System.out.println(node2.info + " ");
        System.out.println(node2.next.info);
        //System.out.println(node1.next.info); ==> ERROR

        SinglyLinkedList list1 = new SinglyLinkedList();
        System.out.println(list1.head);
        list1.addToTail(66); //head and tell will point to node 66
        System.out.println(list1.head.info + " " + list1.tail.info);
        list1.addToTail(79);
        System.out.println(list1.head.info + " " + list1.head.next.info);
        list1.addToHead(34);
        System.out.println(list1.head.info + " " + list1.tail.info + " " + list1.head.next.next.info);
        list1.addToHead(71);
        // 71 -> 34 -> 66 -> 79
        System.out.println(list1.head.info + " 3rd=" + list1.head.next.next.info + " 4th=" + list1.head.next.next.next.info);
        list1.printAllNode();
        list1.deleteFromHead();
        // 71 -> 34 -> 66 -> 79
        //       34 -> 66 -> 79
     //   System.out.println(list1.head.info);
        list1.printAllNode();

        list1.addToHead(61);
        list1.addToHead(40);
        list1.addToTail(59);
        list1.addToHead(80);
        list1.printAllNode();

        list1.deleteFromTail();
        list1.printAllNode();

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addToHead(99);
        list2.printAllNode();
        list2.deleteFromTail();
        list2.printAllNode();
    }
}

package LinkedList.SinglyList;

public class Intro_To_LL {
    //Node of the list
    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    // Using Loops
    public static void displayByLoop(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    // display By Recursion
    public static void displayByRecursion(Node head){
        if(head == null) return;
        System.out.print(head.data + " ");
        displayByRecursion(head.next);
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        displayByLoop(a);
        displayByRecursion(a);
    }
}

package LinkedList.SinglyList;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.plaf.ColorUIResource;
import java.util.LinkedList;

import static LinkedList.SinglyList.reverseLinkedList.linkedList.display;
import static LinkedList.SinglyList.reverseLinkedList.linkedList.reverseWithLoop;

public class reverseLinkedList {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static class linkedList{
        Node head;
        Node tail;
//        linkedList(int val){
//            head = new Node(val);
//            tail = head;
//        }
        void add(int val){
            Node temp = new Node(val);
            if(head == null){
                head = temp;
            }else{
                tail.next = temp;
            }
            tail = temp;
        }
        void display(){
            Node temp = this.head;
            while (temp != null){
                System.out.print(temp.val + (temp.next == null ? " -> null" : " -> "));
                temp = temp.next;
            }
        }
        public static void display(Node head){
            if(head == null) return;
            System.out.print(head.val + (head.next == null ? " -> null" : " -> "));
            display(head.next);
        }
        Node reverse(Node head){
            if(head.next == null) return head;
            Node newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
        static Node reverseWithLoop(Node head){
            if(head == null) return null;
            Node left = null;
            Node current = head;
            Node right = head;
            while (right != null){
                right = right.next;
                current.next = left;
                left = current;
                current = right;
            }
            return left;
        }
    }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        Node a = reverseWithLoop(ll.head);
        display(a);

//        ll.display();
//        System.out.println(ll.head.val);
//        System.out.println(ll.tail.val);
    }
}

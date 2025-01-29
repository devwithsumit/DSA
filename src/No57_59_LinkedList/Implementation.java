package No57_59_LinkedList;

import java.util.LinkedList;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class linkedList {
    Node head;
    Node tail;
    int size;

    linkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean add(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        size++;
        tail = temp;
        return true;
    }

    void add(int index, int val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index : " + index + " out of bounds for size: " + size);
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        if(index == size){
            addLast(val);
            return;
        }
        Node temp = head;
        Node newNode = new Node(val);
        while (index > 1) {
            temp = temp.next;
            index--;
        }
        System.out.println("temp: "+ temp.val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    void addFirst(int val) {
        Node temp = new Node(val);
        if (head == null) {
            tail = temp;
        } else {
            temp.next = head;
        }
        size++;
        head = temp;
    }

    void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public String toString() {
        Node temp = head;
        StringBuilder str = new StringBuilder();
        while (temp != null) {
            str.append(temp.val).append(temp.next != null ? " -> " : " -> null");
            temp = temp.next;
        }
        return str.toString();
    }

    public int getSize() {
        return size;
    }
}

public class Implementation {
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(3, 10);
        System.out.println(ll);
        System.out.println(ll.head.val);
        System.out.println(ll.tail.val);
        System.out.println(ll.size);
    }
}

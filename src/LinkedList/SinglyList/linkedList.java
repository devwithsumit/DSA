package LinkedList.SinglyList;

class Node {
    int val;
    Node next;

    public Node(int data) {
        this.val = data;
    }
}

public class linkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    // Insert at the end of the list
    void insertAtEnd(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
        size++;
    }

    // Insert at the beginning of the list
    void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    // Insert at a specific index
    void insertAt(int index, int val) {
        if (index > size || index < 0) {
            System.out.println("Index Out of Bound Error: index = " + index);
            return;
        }
        if (index == 0) {
            insertAtHead(val);
            return;
        }
        if (index == size) {
            insertAtEnd(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 1; i <= index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // Delete at a specific index
    void deleteAt(int index) {
        if (index >= size || index < 0) {
            System.out.println("Index Out of Bound Error: index = " + index);
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head == null) tail = null; // If list becomes empty
            size--;
            return;
        }

        Node temp = head;
        for (int i = 1; i <= index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        if (index == size - 1) {
            tail = temp; // Update tail if the last node is deleted
        }
        size--;
    }

    // Display the linked list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : " -> null\n"));
            temp = temp.next;
        }
    }

    // Get size of the linked list
    int getSize() {
        return size;
    }
}

package Stack.Implementation;

import java.util.EmptyStackException;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class MyStack2 {
    private Node head;
    private int size;

    MyStack2() {
        head = null;
        size = 0;
    }

    void push(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() {
        if(head == null){
            throw new EmptyStackException();
        }
        int elem = head.val;
        head = head.next;
        size--;
        return elem;
    }

    int peek() {
        if(head == null){
            throw new EmptyStackException();
        }
        return head.val;
    }

    int size() {
        return this.size;
    }

    private String fromStart(Node head){
        if(head == null) return "";

        return fromStart(head.next) + (head.val) + (head != this.head ? ", " : "");
    }
    @Override
    public String toString() {
        return "[" + fromStart(this.head) + "]";
    }

    boolean isEmpty() {;
        return this.size == 0;
    }
}

public class LinkedListImplementationOfStack {
    public static void main(String[] args) {
        MyStack2 st = new MyStack2();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st);
        System.out.println("size: " + st.size());
        System.out.println("peek: " + st.peek());

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
        System.out.println(st);
        System.out.println("size: " + st.size());
    }
}

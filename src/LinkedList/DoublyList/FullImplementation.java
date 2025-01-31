package LinkedList.DoublyList;

public class FullImplementation {
    public static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    public static class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public void insert(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
            } else {
                tail.next = temp; //connect the tail to new Node
                temp.prev = tail; //connect the prev of new node to tail
            }
            tail = temp;//shift the tail to new Node at the last;
            size++;
        }

        public void insertAtHead(int val) {
            Node temp = new Node(val);
            if (head == null) {
                tail = temp;
            } else {
                head.prev = temp;
                temp.next = head;
            }
            head = temp;
            size++;
        }

        public void insertAt(int index, int val) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
            } else if (index == 0) {
                insertAtHead(val);
                return;
            } else if (index == size) {
                insert(val);
                return;
            }
            Node newNode = new Node(val);
            Node temp = head;
            while (index > 1) {
                temp = temp.next;
                index--;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            size++;
        }
        public void deleteHeadNode(){
            head = head.next;
            head.prev = null;
            size--;
        }
        public void deleteTailNode(){
            tail.prev.next = null;
            tail = tail.prev;
            size--;
        }
        public void deleteAt(int index, Node head) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("index " + index + " out of bounds for size " + size);
            }
            else if(index == 0){
                deleteHeadNode();
//                this.head = head.next;
//                this.head.prev = null;
//                size--;
            } else if (index == size - 1) {
                deleteTailNode();
//                this.tail.prev.next = null;
//                this.tail = tail.prev;
//                size--;
            } else{
                Node temp = head;
                for (int i = 1; i <= index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                temp.next.prev = temp;
                size--;
            }
        }

        public void display() {
            Node temp = this.head;

            System.out.print("[");
            while (temp != null) {
                System.out.print(temp.val + (temp.next != null ? ", " : ""));
                temp = temp.next;
            }
            System.out.println("]");
        }
//        public static void displayByRandom(Node random){
//            Node temp = random;
//            //move to head node
//            while (temp.prev != null){
//                temp = temp.prev;
//            }
//            //Now temp is at head so simply print the list
//            while (temp != null){
//                System.out.print(temp.val+ (temp.next != null ? "-> " :"-> null"));
//                temp = temp.next;
//            }
//        }
//        public static void displayReverseByTail(Node tail){
//            Node temp = tail;
//            while (temp != null){
//                System.out.print(temp.val + (temp.prev != null ? "-> " :"-> null"));
//                temp = temp.prev;
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        int[] arr = {6, 1, 7, 2, 9};
        for (int j : arr) {
            ll.insertAtHead(j);
        }
        ll.display();
        System.out.println("head: " + ll.head.val);
        System.out.println("tail: " + ll.tail.val);
        System.out.println("size: " + ll.size);
//
//        ll.insertAt(5, 8);
//        ll.display();
//        System.out.println("new head: " + ll.head.val);
//        System.out.println("new tail: " + ll.tail.val);

        ll.deleteAt(4,ll.head);
        ll.display();
        System.out.println("new head: " + ll.head.val);
        System.out.println("new tail: " + ll.tail.val);
        Node temp = ll.tail;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }

    }
}

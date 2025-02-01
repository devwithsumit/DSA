package LinkedList.SinglyList;

public class FindIntersection {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtHead(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                tail = newNode;
            } else {
                newNode.next = head;
            }
            head = newNode;
            size++;
        }

        void insertAtEnd(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            size++;
            tail = newNode;
        }

        void display() {
            if (head == null) {
                System.out.println("null");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + (temp.next != null ? " -> " : " -> null\n"));
                temp = temp.next;
            }
        }
    }

    static int getSize(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    static Node findIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null; // No intersection possible

        int size1 = getSize(head1);
        int size2 = getSize(head2);

        // Align the start of both lists
        while (size1 > size2) {
            head1 = head1.next;
            size1--;
        }
        while (size2 > size1) {
            head2 = head2.next;
            size2--;
        }

        // Traverse both lists together to find intersection
        while (head1 != null && head2 != null) {
            if (head1 == head2) { // Check reference equality
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null; // No intersection
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        int[] arr1 = new int[]{100, 13, 4, 5, 12, 10};
        for (int j : arr1) {
            ll1.insertAtEnd(j);
        }
        ll1.display();

        LinkedList ll2 = new LinkedList();
        int[] arr2 = new int[]{90, 9, 5, 12, 10};
        for (int j : arr2) {
            ll2.insertAtEnd(j);
        }
        ll2.display();
        ll2.head.next.next = ll1.head.next.next.next;
        System.out.println(findIntersect(ll1.head, ll2.head).data);
    }
}


package LinkedList.SinglyList;


import static LinkedList.SinglyList.reverseLinkedList.linkedList.display;

public class PalindromicLinkedList {
    static boolean isPalindromic(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = reverse2(slow.next);
        slow.next = temp;

        //check for palindrome
        Node p1 = head;
        Node p2 = slow.next;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    static Node reverse2(Node head) {
        Node left = null;
        Node right = head;

        Node current = head;
        while (current != null) {
            right = right.next;
            current.next = left;
            left = current;
            current = right;
        }
        return left;
    }

    static Node reverse(Node head) {
        if (head.next == null) return head;
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void display(Node head) {
        if (head == null) return;
        System.out.print(head.val + (head.next == null ? " -> null" : " -> "));
        display(head.next);
    }

    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtEnd(1);
//        ll.insertAtEnd(2);
//        ll.insertAtEnd(2);
//        ll.insertAtEnd(1);
        ll.display();
        System.out.println(isPalindromic(ll.head));
        ll.display();
    }
}

package LinkedList.DoublyList;

public class PalindromeDLL {
    public static boolean isPalindrome(Node head) {
        if (head == null) return true;
//        Node tail = head;
////        while(tail.next != null){
////            tail = tail.next;
////        }
////        while(head != tail){
////            if(head.val != tail.val) return false;
////            head = head.next;
////            tail = tail.prev;
////        }

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp;
        if (fast.next == null) { //fast reached to end node list is odd
            temp = slow.next; // next node of middle node
            slow = slow.prev; // prev node of middle so that middle node can be ignored
        } else {
            //else list is even so the next node of slow pointer is temp
            temp = slow.next;
        }
        while (temp != null && slow != null /*this condition is optional */) {
            if (temp.val != slow.val) return false;
            slow = slow.prev;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        int[] arr = {1,2,1};
        for (int j : arr) {
            ll.insert(j);
        }
        System.out.println(isPalindrome(ll.head));

    }
}

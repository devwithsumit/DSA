package LinkedList.SinglyList;


public class find_Length {
    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public static int length(Node head){
        int len = 0;
        Node temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        a.next = b;
        b.next = c;
        System.out.println(length(a));
    }
}

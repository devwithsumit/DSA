package LinkedList.DoublyList;

public class DoublyLL {
    public static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
        }
    }
    public static void displayByHead(Node head){
        Node temp = head;
        while( temp != null){
            System.out.print(temp.val + (temp.next != null ? "-> " :"-> null"));
            temp = temp.next;
        }
        System.out.println();
    }
    public static void displayReverseByTail(Node tail){
        Node temp = tail;
        while (temp != null){
            System.out.print(temp.val + (temp.prev != null ? "-> " :"-> null"));
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void displayByRandom(Node random){
        Node temp = random;
        //move to head node
        while (temp.prev != null){
            temp = temp.prev;
        }
        //Now temp is at head so simply print the list
        while (temp != null){
            System.out.print(temp.val+ (temp.next != null ? "-> " :"-> null"));
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(6);
        Node d = new Node(1);
        Node e = new Node(8);

        a.prev = null;
        a.next = b;
        b.prev = a;

        b.next = c;
        c.prev = b;

        c.next = d;
        d.prev = c;

        d.next = e;
        e.prev = d;
        e.next = null;
        displayByHead(a);

        displayReverseByTail(e);

        displayByRandom(c);

    }
}

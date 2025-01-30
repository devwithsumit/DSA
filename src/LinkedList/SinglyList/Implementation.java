package LinkedList.SinglyList;

public class Implementation {

    public static void main(String[] args) {
        linkedList ll = new linkedList();

        // Insert at end
        int[] arr = {2, 5, 1, 8, 9};
        for (int j : arr) {
            ll.insertAtEnd(j);
        }

        // Display initial list
        System.out.println("Initial List:");
        ll.display();

        // Insert at head
        ll.insertAtHead(10);
        System.out.println("After inserting 10 at head:");
        ll.display();

        // Insert at specific index
        ll.insertAt(3, 15);
        System.out.println("After inserting 15 at index 3:");
        ll.display();

        // Delete at specific index
        ll.deleteAt(2);
        System.out.println("After deleting element at index 2:");
        ll.display();

        // Print size of the list
        System.out.println("Size of the list: " + ll.getSize());

        // Test delete at head and tail
        ll.deleteAt(0);
        ll.deleteAt(ll.getSize() - 1);
        System.out.println("After deleting head and tail:");
        ll.display();
    }
}

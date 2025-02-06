 package No_60_Queue;

class Node2 {
    int val;
    Node2 next;
    Node2(int val){
        this.val = val;
    }
}
class MyCircularDeque {
    private Node2 head;
    private Node2 tail;
    private int size;
    private int capacity;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node2 temp = head;
        while(temp != null){
            sb.append(temp.val).append(temp.next != null ? ", " : "");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public MyCircularDeque(int k) {
        head = tail = null;
        size = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        Node2 newNode = new Node2(value);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.next = newNode;
        }
        head = newNode;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;

        Node2 newNode = new Node2(value);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        head = head.next;
        if(head == null) tail = null;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;

        if(head.next == null){
            head = tail = null;
        }
        Node2 temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        return true;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return head.val;
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size != capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your No_60_Queue.MyCircularDeque object will be instantiated and called as such:
 * No_60_Queue.MyCircularDeque obj = new No_60_Queue.MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
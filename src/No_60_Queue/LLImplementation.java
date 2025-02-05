package No_60_Queue;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node2 next;
    Node(int val){
        this.val = val;
    }
}
class MyQueue{
    Node2 tail;
    Node2 head;
    private int size;
    MyQueue(){
        Node2 head = null;
        Node2 tail = null;
        size = 0;
    }
    void offer(int val){
        Node2 newNode = new Node2(val);

        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    Integer poll(){
        if(head == null){
            return null;
        }
        int temp = head.val;
        head = head.next;
        size--;
        return temp;
    }
    boolean isEmpty(){
        return head == null || tail == null;
    }
    int size(){
        return this.size;
    }
    Integer peek(){
        if(head == null) return null;
        return head.val;
    }
    @Override
    public String toString() {
        Node2 temp = head;
        StringBuilder sb = new StringBuilder("[");
        while(temp != null){
            sb.append(temp.val).append((temp.next != null ? ", " : ""));
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
public class LLImplementation {


    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        Queue<Integer> q1 = new LinkedList<>();
        System.out.println(q1.poll());
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q + " size: " + q.size());

        q.poll();
        System.out.println(q + " size: " + q.size());

        System.out.println(q.isEmpty());
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
        System.out.println(q.isEmpty());
        System.out.println(q.peek());
    }
}

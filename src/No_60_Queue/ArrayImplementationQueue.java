package No_60_Queue;

import java.util.Arrays;

class MyQueue2 {
    int[] arr;
    int rear;
    int front;
    int size;

    MyQueue2() {
        arr = new int[5];
        rear = -1;
        front = -1;
        size = 0;
    }

    MyQueue2(int capacity) {
        arr = new int[capacity];
        rear = -1;
        front = -1;
    }

    void offer(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) front = 0;
        rear = ++rear % arr.length;
        arr[++rear] = val;
//        if(rear == arr.length - 1){
//            arr[rear = 0] = val;
//            return;
//        }
    }

    Integer poll() {
        if (isEmpty()) {
            return null;
        }
        int temp = arr[front];
        front = ++front % arr.length;
        if (front == rear) {
            front = rear = -1;
            return temp;
        }
        return temp;
    }

    Integer peek() {
        if (isEmpty()) return null;
        return arr[front];
    }

    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        return (rear + 1) % arr.length == front;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        if (isEmpty()) return sb.append("]").toString();

        for (int i = front; i != rear; i = (i + 1) % arr.length /* when 'i' >= n, 5 % 5 = 0; i -> 0,1,2*/) {
            sb.append(arr[i]).append(", ");
        }
        //add the last rear element
        sb.append(arr[rear]);
        sb.append("]");
        return sb.toString();
    }
}

public class ArrayImplementationQueue {
    public static void main(String[] args) {
        MyQueue2 q = new MyQueue2();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
        q.offer(10);
        System.out.println(q);
//        System.out.println(Arrays.toString(q.arr));
//        System.out.println(q.front);
//        System.out.println(q.rear);
        while (!q.isEmpty()) System.out.println(q.poll());
        q.offer(4);
        q.offer(3);
        q.offer(7);

        System.out.println(q);
        System.out.println(q.peek());

    }
}

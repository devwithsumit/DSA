package No_60_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseKElementsOfQueue {
    public static void reverseK(Queue<Integer> q, int k) {
        if (k > q.size() || k <= 1) return;

        Stack<Integer> st = new Stack<>();
        int counter = 1;
        // move (k = 3) elements to the stack to reverse them
        // Queue - 1 2 3 4 5
        // After moving------
        // Queue -  4 5
        // Stack - 1 2 3
        while (!q.isEmpty() && counter <= k) {
            st.push(q.poll());
            counter++;
        }
        // add back the k elements to the queue.
        // Queue - 4 5 1 2 3
        while (!st.isEmpty()) {
            q.offer(st.pop());
        }

        // move the rest (n - k = 2) elements to the back of queue itself.
        counter = q.size() - k;
        while (counter-- > 0) {
            q.offer(q.poll());
        }
        // Queue - 1 2 3 4 5
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int[] arr = {1, 2, 3, 4, 5};
        for (int j : arr) q.offer(j);

        System.out.println(q); // 1 2 3 4 5
        reverseK(q, 3);
        System.out.println(q); // 3 2 1 4 5
    }
}

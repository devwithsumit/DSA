package No_60_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void reverseQ(Queue<Integer> q) {
        Stack<Integer> tempQ = new Stack<>();

        /// move the queue elements to stack
        // Queue : poll <-1 2 3 4 5 6 7
        while(!q.isEmpty()){
            int temp = q.poll();
            tempQ.push(temp);
        }
        // Stack : 1 2 3 4 5 6 7-> pop
        ///  move the stack element back to queue
        while (!tempQ.isEmpty()){
            int temp = tempQ.pop();
            q.offer(temp);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for(int j: arr) q.offer(j);
        System.out.println(q);
        reverseQ(q);
        System.out.println(q);
    }
}

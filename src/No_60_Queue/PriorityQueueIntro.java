package No_60_Queue;

import java.util.*;

public class PriorityQueueIntro {
    public static void main(String[] args) {
        /// min priority queue
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        pqMin.add(5);
        pqMin.add(2);
        pqMin.add(4);
        pqMin.add(3);
        System.out.println("PQ MIN");
        System.out.println(pqMin); // 2 5 4 3 (only one smaller element is given priority rest are in their sequence

        System.out.println(pqMin.poll()); // 2
        System.out.println(pqMin); // 3 5 4 (after polling the priority is revised and again another smaller one element is given priority


        /// max priority queue
        System.out.println();

        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());

        pqMax.add(5);
        pqMax.add(2);
        pqMax.add(4);
        pqMax.add(3);
        System.out.println("PQ MAX");
        System.out.println(pqMax); // 5 2 4 3 (similar to min PQ only max is replaced with min

        System.out.println(pqMax.poll()); // 5
        System.out.println(pqMax); // 4 2 3
    }
}

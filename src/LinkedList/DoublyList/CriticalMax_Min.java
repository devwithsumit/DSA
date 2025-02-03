package LinkedList.DoublyList;

import java.util.ArrayList;
import java.util.List;

public class CriticalMax_Min {
    public static void Max_Min(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        Node temp = head.next;
        int index = 1;
        List<Integer> indices = new ArrayList<>();
        while (temp.next != null){
            int prev = temp.prev.val;
            int next = temp.next.val;
            int current = temp.val;
            if((current > prev && current > next) || (current < prev && current < next)){
                indices.add(index);
            }
            temp = temp.next;
            index++;
        }
        if(indices.size() < 2){
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = indices.getLast() - indices.getFirst();
        for (int i = 1; i < indices.size(); i++) {
            int distance = indices.get(i) - indices.get(i - 1);
            min = Math.min(min, distance);
        }
        System.out.println(max);
        System.out.println(min);
//        Node temp = head.next;
//        int distance = 0;
//        Node c1 = null;
//        int min = Integer.MAX_VALUE;
//        while(temp.next != null){
//            int prev = temp.prev.val;
//            int next = temp.next.val;
//            if((temp.val > prev && temp.val > next) || (temp.val < prev && temp.val < next)){
//                if(c1 == null){
//                    c1 = temp;
//                    distance = 1;
//                    temp = temp.next;
//                    while (temp.next != null){
//                        int localPrev = temp.prev.val;
//                        int localNext = temp.next.val;
//                        if ((temp.val > localPrev && temp.val > localNext) || (temp.val < localPrev && temp.val < localNext)){
//                            c1 = temp;
//                            min = Math.min(min, distance);
//                            distance = 0;
//                            break;
//                        }
//                        distance++;
//                        temp = temp.next;
//                    }
//                }
//                else{
//                    c1 = temp;
//                    min = Math.min(min, distance);
//                    distance = 0;
//                }
//            }
//            temp = temp.next;
//            distance++;
//        }
//        temp = c1;
//        Node c2 = null;
//        int max = Integer.MIN_VALUE, count = 0;
//        while(temp.prev != null){
//            int prev = temp.prev.val;
//            int next = temp.next.val;
//            if((temp.val > prev && temp.val > next) || (temp.val < prev && temp.val < next)){
//                c2 = temp;
//                max = count;
//            }
//            count++;
//            temp = temp.prev;
//        }
//        System.out.println(max);
//        System.out.println(min);
    }
    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        int[] arr = {1, 2, 5, 3, 2, 7, 8, 9, 1, 10};
        for (int j : arr) {
            ll.insert(j);
        }
        ll.display();
        Max_Min(ll.head);
    }
}

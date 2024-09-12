package No_75_BinaryHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinHeap_Implementation {
    static class MinHeap {
        private int[] arr = new int[16];
        private int size;

        void offer(int val) {
            if(size == 16) return;
            size++;
            int p = size;
            arr[p] = val;
            while (p > 1) {
                if (arr[p] < arr[p / 2]) {
                    int temp = arr[p];
                    arr[p] = arr[p / 2];
                    arr[p / 2] = temp;
                }
                p = p / 2;
            }
        }

        Integer poll() {
            if(isEmpty()) return null;
            if(size == 1){
                size--;
                return arr[1];
            }
            int val = arr[1];
            // swap the last element and put it at first
            arr[1] = arr[size];

            minHeapify(1);
            size--;
            return val;
        }
        void minHeapify(int key){
            int leftIdx = 2 * key;
            int rightIdx = 2 * key + 1;

            int smallest = key;
            if(leftIdx <= size){ // check if the left or right idx is in bounds
                if(arr[leftIdx] < arr[smallest]) smallest = leftIdx;
            }
            if(rightIdx <= size){
                if(arr[rightIdx] < arr[smallest]) smallest = rightIdx;
            }
            if(smallest != key){
                int temp = arr[smallest];
                arr[smallest] = arr[key];
                arr[key] = temp;
                minHeapify(smallest);
            }
        }
        Integer peek(){
            if(isEmpty()) return null;
            return arr[1];
        }
        Integer parent(int idx) {
            idx++;
            if (idx/ 2 < 1) return null;
            return idx / 2;
        }

        Integer left(int idx) {
            idx++;
            if (2 * idx > size) return null;
            return arr[2 * idx];
        }

        Integer right(int idx) {
            idx++;
            if (2 * idx + 1 > size) return null;
            return arr[2 * idx + 1];
        }
        boolean isEmpty(){
            return size == 0;
        }
        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(arr, 1, size + 1));
        }
    }

    public static void main(String[] args) {
//        MinHeap pq = new MinHeap();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(6);
        pq.offer(2);
        pq.offer(1);
        pq.offer(5);
        pq.offer(3);
        pq.offer(7);
        pq.offer(8);

        while (!pq.isEmpty()){
            System.out.println(pq);
            System.out.println(pq.poll());
        }
        System.out.println(pq);
    }
}

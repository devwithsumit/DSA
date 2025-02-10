package Stack.BasicAlgorithms;

import java.util.Stack;

public class PushAt {
    public static void insertAtBottom(Stack<Integer> st, int element) {
        Stack<Integer> temp = new Stack<>();
        while (!st.isEmpty()){
            temp.push((Integer) st.pop());
        }
        st.push(element);
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }

    public static void insertAt(Stack<Integer> st, int index , int element) {
        if(index == 0){
            insertAtBottom(st,element);
            return;
        };
        if(index < 0){
            throw new  IndexOutOfBoundsException("invalid index: " + index);
        }
        Stack<Integer> temp = new Stack<>();
        while(st.size() > index){
            temp.push((Integer) st.pop());
        }
        st.push(element);
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);

        insertAtBottom(st,0);
        System.out.println(st);

        insertAt(st,2,5);
        System.out.println(st);
    }
}


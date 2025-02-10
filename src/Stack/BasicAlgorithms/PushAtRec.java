package Stack.BasicAlgorithms;

import java.util.Stack;

public class PushAtRec {
    public static void pushAt(Stack<Integer> st, int index, int element){
        if (index < 0 || index > st.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if(st.size() == index){
            st.push(element);
            return;
        }
        int top = st.pop();
        pushAt(st, index, element);
        st.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);

        pushAt(st, 1, 0);

        System.out.println(st);
    }
}

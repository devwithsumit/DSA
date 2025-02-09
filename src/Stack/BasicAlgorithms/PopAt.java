package Stack.BasicAlgorithms;

import java.util.Stack;

public class PopAt {
    public static void popAtBottom(Stack<Integer> st) {
        if (st.size() == 1) {
            st.pop();
            return;
        }
        int top = st.pop();
        popAtBottom(st);
        st.push(top);
    }

    public static void popAt(Stack<Integer> st, int index) {
        if (index < 0 || index >= st.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (st.size() == index + 1) {
            st.pop();
            return;
        }
        int top = st.pop();
        popAt(st, index);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);

        popAt(st, 2);

        System.out.println(st);

//        popAtBottom(st);
//
//        System.out.println(st);
    }
}

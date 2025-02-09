package Stack.BasicAlgorithms;

import java.util.Stack;

public class DisplayRec {
    public static void display(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int top = st.pop();
        display(st);
        System.out.print(top + ", ");
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        display(st);
        System.out.println(st);
    }
}

package Stack;

import java.util.Stack;

public class Q1_CopyStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int[] arr = {1,2,3,4,5};
        for(int j: arr) st.push(j);

        Stack<Integer> copy = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()){
            temp.add(st.pop());
        }
        System.out.println(temp);
        while(!temp.isEmpty()){
            int x = temp.pop();
            copy.push(x);
            st.push(x);
        }
        System.out.println(st);
        System.out.println(copy);
    }
}

package Stack;

import java.util.Stack;

public class PrefixToInfix{
    public static void main(String[] args) {
        String s = "-9/*+5346";
        // output ->  9-(5+3)*4/6
        Stack<String> val = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch >= 48 && ch <= 57) {
                val.push(Character.toString(ch));
            } else {
                String val1 = val.pop();
                String val2 = val.pop();
                String res = val1 + ch + val2;
                if (ch == '+' || ch == '-') {
                    res = '(' + res + ')';
                }
                val.push(res);
            }
        }
        System.out.println(val.pop());
    }
}

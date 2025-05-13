package Stack;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String s = "9-(5+3)*4/6"; // 4
        //+53
        // -9/*+5346


        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 48 && ch <= 57){
                val.push(Character.toString(ch));
            }else if(op.isEmpty() || ch == '(' || op.peek() == '('){
                op.push(ch);
            }else if(ch == ')'){
                //work
                while(op.peek() != '('){
                    String y = val.pop();
                    String x = val.pop();
                    String res = op.pop() + x + y;
                    val.push(res);
                }
                op.pop();
            }else{
                if(ch == '+' || ch == '-'){
                    String y = val.pop();
                    String x = val.pop();
                    String res = op.pop() + x + y;
                    val.push(res);
                }
                else if (op.peek() == '*' || op.peek() == '/'){
                    String y = val.pop();
                    String x = val.pop();
                    String res = op.pop() + x + y;
                    val.push(res);
                }
                op.push(ch);
            }
        }

        while(val.size() > 1){
            String y = val.pop();
            String x = val.pop();
            String res = op.pop() + x + y;
            val.push(res);
        }
        System.out.println(val.pop());
    }
}

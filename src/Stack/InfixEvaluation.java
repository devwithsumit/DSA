package Stack;

import java.util.Arrays;
import java.util.Stack;

public class InfixEvaluation {
    public static int calc(int x, int y, char op) {
        return switch (op) {
            case '-' -> x - y;
            case '+' -> x + y;
            case '*' -> x * y;
            case '/' -> x / y;
            default -> x;
        };
    }

    public static void main(String[] args) {
        String s = "9-(5+3)*4/6"; // 4

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = ch;
            // if num push as it is and do nothing
            if (num >= 48 && num <= 57) {
                val.push(num - 48);
            } else if (op.isEmpty() || ch == '(' || op.peek() == '(') {
                // if op is empty OR '(' on its peek OR ch == '( it means no operation is possible
                op.push(ch);
            } else if (ch == ')') {
                //solve the bracket first
                // work until '(' comes on peek to solve the bracket first
                while (op.peek() != '(') {
                    int y = val.pop();
                    int x = val.pop();
                    int result = calc(x, y, op.pop());
                    val.push(result);
                }
                //remove '('
                op.pop();
            } else {
                // solve the precedence because * / has more precedence and even if
                // + - comes we goes left to right so we also need solve them first
                if (ch == '-' || ch == '+') {
                    int y = val.pop();
                    int x = val.pop();
                    int result = calc(x, y, op.pop());
                    val.push(result);
                }
                // if ch is * / then solve only if op.peek has * / else push it
                else if (op.peek() == '*' || op.peek() == '/') {
                    int y = val.pop();
                    int x = val.pop();
                    int result = calc(x, y, op.pop());
                    val.push(result);
                }
                //At last push the operator anyway
                op.push(ch);

            }
        }
        while (val.size() > 1) {
            int y = val.pop();
            int x = val.pop();
            int result = calc(x, y, op.pop());
            val.push(result);
        }
        System.out.println(val.pop());
    }
}

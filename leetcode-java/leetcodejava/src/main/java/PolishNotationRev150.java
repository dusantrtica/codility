import org.codehaus.groovy.syntax.Numbers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class PolishNotationRev150 {
    String operators = "+-/*";
    private boolean isOperator(String s) {
        return operators.contains(s);
    }

    private int evaluateBinaryOp(String operator, int op1, int op2) {
        switch (operator) {
            case "*": return op1 * op2;
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "/": return op1/op2;
        }
        return 0;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(isOperator(token)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(evaluateBinaryOp(token, op2, op1));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    @Test
    public void case1() {
        String [] tokens = {"2","1","+","3","*"};
        Assert.assertEquals(9, evalRPN(tokens));
    }

    @Test
    public void case2() {
        String [] tokens = {"4","13","5","/","+"};
        Assert.assertEquals(6, evalRPN(tokens));
    }

    @Test
    public void case3() {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Assert.assertEquals(22, evalRPN(tokens));
    }
}

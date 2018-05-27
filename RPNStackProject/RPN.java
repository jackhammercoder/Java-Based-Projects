/**
 * RPN Class.
 *
 * @author  Jonathan Kisch 
 * @version 1/25/2016 Developed for CPE 103 project 2
 */
import java.util.Scanner;

public class RPN {


    public static double evaluateRPN(String equation) {
    	SimpleLinkedStack<Double> stack = new SimpleLinkedStack<Double>();
    	Scanner input = new Scanner(equation);
        while (input.hasNext()) {
            String value = input.next();
            if (value.equals("+")) {
                double one = stack.pop();
                double two = stack.pop();
                double ans = two + one;
                stack.push(ans);
            } else if (value.equals("-")) {
                double one = stack.pop();
                double two = stack.pop();
                double ans = two - one;
                stack.push(ans);
            } else if (value.equals("*")) {
                double one = stack.pop();
                double  two = stack.pop();
                double ans = two * one;
                stack.push(ans);
            } else if (value.equals("/")) {
                double one = stack.pop();
                double two = stack.pop();
                double ans = two / one;
                stack.push(ans);
            } else {
            	double push = Double.parseDouble(value);
            	stack.push(push);
            }

        }
        input.close();
        return stack.pop(); // could use peek as well, did
                                                // this in case I wanted to
                                                // reuse stack somewhere else.

    }

    public static String toRPN(String expression) {
    	SimpleLinkedStack<String> stack = new SimpleLinkedStack<String>();
    	Scanner input = new Scanner(expression);
        String RPN = "";
        while (input.hasNext()) {
            String value = input.next();
            if (value.equals("+")) {                                         /////*********** checks if the value is a + operator
                if (stack.size() == 0 || stack.peek().equals("(")) {
                    stack.push(value);
                  
                } else {
                    while (stack.size() != 0 && (!stack.peek().equals("("))) {
                        String add_to_RPN = stack.pop();
                        RPN = RPN + add_to_RPN + " ";
                    }
                    stack.push(value);
                }
            }
            else if (value.equals("-")) {                                    /////*********** checks if the value is a - operator
                if (stack.size() == 0 || stack.peek().equals("(")) {
                    stack.push(value);
                  
                } else {
                    while (stack.size() != 0 && (!stack.peek().equals("("))) {
                        String add_to_RPN = stack.pop();
                        RPN = RPN + add_to_RPN + " ";
                    }
                    stack.push(value);
                }
            }
            else if (value.equals("*")) {                                    /////*********** checks if the value is a * operator
                if (stack.size() == 0 || stack.peek().equals("(") || stack.peek().equals("+") || stack.peek().equals("-")) {
                    stack.push(value);
                }
                else {
                    while (stack.size() != 0 && (!stack.peek().equals("(") && !stack.peek().equals("-") && !stack.peek().equals("+"))) {
                        String add_to_RPN = stack.pop();
                        RPN = RPN + add_to_RPN + " ";
                    }
                    stack.push(value);
                }

            }
            else if (value.equals("/")) {                                    /////*********** checks if the value is a / operator
                if (stack.size() == 0 || stack.peek().equals("(") || stack.peek().equals("+") || stack.peek().equals("-")) {
                    stack.push(value);
                } else {
                    while (stack.size() != 0 && (!stack.peek().equals("(") && !stack.peek().equals("-") && !stack.peek().equals("+"))) {
                        String add_to_RPN = stack.pop();
                        RPN = RPN + add_to_RPN + " ";
                    }
                    stack.push(value);
                }
            }
            else if (value.equals("(")){                                    /////*********** checks if the value is a (
                stack.push(value);
            }
            else if (value.equals(")")){                                    /////*********** checks if the value is a )
                while(!stack.peek().equals("(")){
                    String add_to_RPN = stack.pop();
                    RPN = RPN + add_to_RPN + " ";
                }
                stack.pop();
            }
            else{                                                            /////*********** checks if the value is a double/int
                RPN = RPN + value + " ";
            }
        }
        while (stack.size() > 0){
            String add_to_RPN = stack.pop();
            RPN = RPN + add_to_RPN + " ";
        }
        RPN = RPN.trim();
        input.close();
        return RPN;
    }
    public static double evaluateInfix(String expression){
    	String RPNconvert = RPN.toRPN(expression);
    	return RPN.evaluateRPN(RPNconvert);
    }
}

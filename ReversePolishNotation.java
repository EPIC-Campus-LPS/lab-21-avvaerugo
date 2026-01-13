package lab21;

import java.util.Stack;

public class ReversePolishNotation {
	public static int evaluatePostfix(String input) {
		String[] inputs = input.split(" ");
		Stack<Integer> stack = new Stack<>();
		for (String i : inputs) {
			try {
				stack.push(Integer.parseInt(i));
			} catch (NumberFormatException e) {
				if (i.equals("+")) {
					int temp = stack.pop();
					stack.push(stack.pop() + temp);
				}
				else if (i.equals("-")) {
					int temp = stack.pop();
					stack.push(stack.pop() - temp);
				}
				else if (i.equals("*")) {
					int temp = stack.pop();
					stack.push(stack.pop() * temp);
				}
				else if (i.equals("/")) {
					int temp = stack.pop();
					stack.push(stack.pop() / temp);
				}
			}
		}
		if (stack.size() == 1) {
			return stack.pop();
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public static String infixToPostfix(String input) {
		String[] inputs = input.split(" ");
		Stack<String> stack = new Stack<>();
		String out = "";
		for (String i : inputs) {
			try {
				Integer.parseInt(i);
				out += i + " ";
			} catch (NumberFormatException e) {
				stack.push(i);
			}
		}
		return out.substring(0,out.length() - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(evaluatePostfix("7 2 + 9 / 3 5 * -"));
		System.out.println(evaluatePostfix("5 1 3 + + 3 / 20 *"));
	}
}

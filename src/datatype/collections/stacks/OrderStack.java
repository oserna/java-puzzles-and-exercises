package datatype.collections.stacks;

import java.util.Stack;

public class OrderStack {
	
	public static java.util.Stack<Integer> order(java.util.Stack<Integer> stack){
		java.util.Stack<Integer> orderedStack = new Stack<>();
		while(!stack.isEmpty()){
			Integer integer = stack.pop();
			while(!orderedStack.isEmpty() && integer > orderedStack.peek()){
				stack.push(orderedStack.pop());
			}
			orderedStack.push(integer);
		}
		return orderedStack;
		
	}
	
	public static void main(String[] args) {
		java.util.Stack<Integer> test = new Stack<Integer>(){{
			push(2);
			push(5);
			push(3);
			push(1);
		}};
		Stack<Integer> order = OrderStack.order(test);
		for (Integer integer : order) {
			System.out.println(integer);
		}
		
	}

}

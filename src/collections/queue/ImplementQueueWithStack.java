package collections.queue;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class ImplementQueueWithStack {

	@Test
	public void testQueueFromStack(){
		QueueBasedOnStack test = new QueueBasedOnStack();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		
		int poll = test.poll();
		System.out.println(poll);
	}
	
	
	class QueueBasedOnStack{
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> aux = new Stack<>();
		
		void add(int i){
			stack.push(i);
		}
		
		int poll(){
			while(!stack.isEmpty()){
				aux.push(stack.pop());
			}
			int popped = aux.pop();
			while(!aux.isEmpty()){
				stack.push(aux.pop());
			}
			return popped;
		}
		
	}

	

}

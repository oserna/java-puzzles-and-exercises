package collections.stacks;

public class Stack<T> {
	
	private Node top = null;
	
	public void push(T element){
		Node newNode = new Node(element);
		newNode.next = top;
		top = newNode;
	}
	
	public T pop(){
		Node toReturn = top;
		top = toReturn.next;
		return toReturn.content;
				
	}
	
	public T peek(){
		return top.content;
	}

	public class Node{
		private T content;
		private Node next = null;
		public Node(T content){
			this.content = content;
		}
		public Node getNext() {
			return next;
		}
		public T getContent() {
			return content;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();
		
	}

}

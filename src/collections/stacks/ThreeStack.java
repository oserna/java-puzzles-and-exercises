package collections.stacks;

public class ThreeStack {
	
	private int stackSize = 10;
	
	private int [] stacks = new int[stackSize*3];
	private int [] tops = new int[]{0,0,0};
		
	public boolean push(int stack, int element){
		int top = tops[stack-1];
		if (top>=stackSize) {
			return false;
		}
		stacks[top] = element;
		tops[stack-1] = ++top;
		return true;
	}
	
	public int pop(int stack){
		int top = tops[stack-1];
		int element = stacks[top-1];
		stacks[top-1] = 0;
		tops[stack-1] = --top;
		return element;
	}
	
	
	public static void main(String[] args) {
		ThreeStack stack = new ThreeStack();
		stack.push(1,1);
		stack.push(1,2);
		stack.push(1,3);
		
		System.out.println();
		
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		
		System.out.println();
		
	}

}

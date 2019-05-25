package datatype.collections.stacks;

import java.util.Arrays;

public class HandmadeStack {
	
	private static final int DEFAULT_CAPACITY = 8;
		
	private Integer [] stack = null;
	private int currentIndex = 0;
	
	public HandmadeStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public HandmadeStack(int init) {
		stack = new Integer [init];
	}
	
	public int size(){
		return currentIndex;
	}

	public synchronized Integer pop(){
		if(currentIndex == 0)
			return null;
		
		Integer pop = stack[currentIndex-1];
		stack[currentIndex-1] = null;
		currentIndex--;
		return pop;
	} 
	
	
	public synchronized void push(Integer element){
		if(isFull()){
			resize();
		}
		stack[currentIndex] = element;
		currentIndex ++;
	}
	
	public boolean isFull(){
		return currentIndex == stack.length;
	}
	
	private void resize(){
		stack = Arrays.copyOf(stack, stack.length + DEFAULT_CAPACITY);
	}

}

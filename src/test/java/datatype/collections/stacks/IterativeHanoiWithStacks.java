package datatype.collections.stacks;

import java.util.ArrayList;
import java.util.List;


public class IterativeHanoiWithStacks {
	
	private int numDiscs = 0;
		
	private List<HanoiStack> stacks = new ArrayList<HanoiStack>(){{
		add(new HanoiStack(1));
		add(new HanoiStack(2));
		add(new HanoiStack(3));
	}};	
	
	public IterativeHanoiWithStacks(int numDiscs) {
		this.numDiscs = numDiscs;
		for (int i = numDiscs; i >= 1; i--) {
			stacks.get(0).push(new Disc(i));
		}
	}
	
	
	private void hanoi(){
		HanoiStack smallestDiscLastPosition = stacks.get(0);
		while (stacks.get(2).size() != numDiscs ) {
			smallestDiscLastPosition = moveDisc(smallestDiscLastPosition);
			if(stacks.get(2).size() == numDiscs ){
				break;
			}
			moveDisc(next(smallestDiscLastPosition));
		}
		System.out.println("Done");
	}
	
	private HanoiStack moveDisc(HanoiStack from){
		
		HanoiStack to = next(from);
		while(!moveDiscBetweenStacks(from, to)){
			to = next(to);
			if(from == to){
				return moveDisc(next(from));
			}
		}
		return to;
		 
	}
	
	private boolean moveDiscBetweenStacks(HanoiStack from, HanoiStack to){
		if (from.isEmpty()) {
			return false;
		}
		if(to.isEmpty()){
			System.out.println("Moving disc "+from.peek().getNum()+" from Stack "+from.getOrder()+" to Stack "+to.getOrder());
			to.push(from.pop());
			return true;			
		}
		Disc topDiscFrom= from.peek();
		Disc topDiscTo = to.peek();
		if (topDiscFrom.getNum() < topDiscTo.getNum()) {			
			System.out.println("Moving disc "+topDiscFrom.getNum()+" from Stack "+from.getOrder()+" to Stack "+to.getOrder());
			to.push(from.pop());
			return true;
		}
		return false;
	}
	
	private HanoiStack next(HanoiStack from){
		HanoiStack to = null;
		if (numDiscs % 2 == 0) {
			to = nextRight(from);
		}else{
			to = nextLeft(from);
		}
		return to;
		
	}
	
	
	private HanoiStack nextLeft(HanoiStack stack){
		int order = stack.getOrder();
		if (order == 1) {
			return stacks.get(stacks.size()-1);
		}
		return stacks.get(order-2);		
	}
	
	private HanoiStack nextRight(HanoiStack stack){
		int order = stack.getOrder();
		if (order == stacks.size()) {
			return stacks.get(0);
		}
		return stacks.get(order);		
	}
	
	public static void main(String[] args) {
		IterativeHanoiWithStacks hanoi = new IterativeHanoiWithStacks(3);
		hanoi.hanoi();
	}
	
	
	public static class Disc{
		
		private int num;

		private Disc(int num) {
			super();
			this.num = num;
		}
		
		public int getNum() {
			return num;
		}
		  
	}
	
	public static class HanoiStack extends java.util.Stack<Disc>{
		
		private int order;

		private HanoiStack(int order) {
			super();
			this.order = order;
		}
		
		public int getOrder() {
			return order;
		}
		
		@Override
		public synchronized String toString() {
			return "Torre "+order;
		}
		
	}
		
}
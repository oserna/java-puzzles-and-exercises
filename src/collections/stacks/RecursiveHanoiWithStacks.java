package collections.stacks;


public class RecursiveHanoiWithStacks {
	
	private HanoiStack stack_A = new HanoiStack("A");
	private HanoiStack stack_B = new HanoiStack("B");
	private HanoiStack stack_C = new HanoiStack("C");
	
	
	public RecursiveHanoiWithStacks(int numDiscs) {
		for (int i = numDiscs; i >= 1; i--) {
			stack_A.push(new Disc(i));
		}
		
	}
	
	public void execute(){
		hanoi(stack_A.size(), stack_B, stack_A, stack_C);
		System.out.print("Discs in the target tower: "+stack_C.size());
	}
	
	
	private void hanoi(int discsToMove, HanoiStack aux, HanoiStack from, HanoiStack to){
		if(discsToMove == 1){
			moveDiscBetweenStacks(from, to);
		}else{
			
			hanoi(discsToMove-1 , to, from, aux);
			
			moveDiscBetweenStacks(from, to);
			
			hanoi(discsToMove-1 , from, aux, to);			
		}
		
	}
	
	private void moveDiscBetweenStacks(HanoiStack from, HanoiStack to){
		Disc popped= from.pop();
		System.out.println("Moving disc "+popped.getNum()+" from Stack "+from.getName()+" to Stack "+to.getName());
		to.push(popped);
	}
	
	public static void main(String[] args) {
		RecursiveHanoiWithStacks hanoi = new RecursiveHanoiWithStacks(3);
		hanoi.execute();
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
		
		private String name;

		private HanoiStack(String name) {
			super();
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		@Override
		public synchronized String toString() {
			return name;
		}
		
	}
		
}
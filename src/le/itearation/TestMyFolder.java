package le.itearation;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


import org.junit.Assert;
import org.junit.Test;

public class TestMyFolder {

	@Test
	public void testPreviousFoldFucntion() {

		
		//the queue
		Queue<Order> orders = new ArrayBlockingQueue<>(5);
		orders.add(new Order("ING",1000));
		orders.add(new Order("ANZ",500));
		orders.add(new Order("ING",400));
		orders.add(new Order("SANTANDER",700));
		orders.add(new Order("BBVA",1200));
		
		MyFolder<Order, Integer> folder = new MyFolder<>();
	
		Function2<Order, Integer, Integer> function = new AmountCalculator("ING");
		
		Integer totalAmount = folder.fold(0, orders, function);
		
		Assert.assertEquals(1400, totalAmount.intValue());
		
		
	}
	
	
	@Test
	public void testNewFoldFunction() {

		
		//the queue
		Queue<Order> orders = new ArrayBlockingQueue<>(5);
		orders.add(new Order("ING",1000));
		orders.add(new Order("ANZ",500));
		orders.add(new Order("ING",400));
		orders.add(new Order("SANTANDER",700));
		orders.add(new Order("BBVA",1200));
		
		MyFolder<Order, Integer> folder = new MyFolder<>();
	
		Function2<Order, Integer, Integer> function = new AmountCalculator("ING");
		
		Integer totalAmount = folder.foldWithoutRecursion(0, orders, function);
		
		Assert.assertEquals(1400, totalAmount.intValue());
		
		
	}
	
	/**
	 * Function2 like the Spark
	 * @author oserna
	 *
	 */
	class AmountCalculator implements Function2<Order, Integer, Integer>{
		
		private String company;
		
		public AmountCalculator(String company) {
			this.company = company;
		}

		@Override
		public Integer apply(Order order, Integer previousAmount) {
			if (order.getCompany().equals(this.company)) {				
				return order.getAmount() + previousAmount; 
			}
			return previousAmount;
		}
		
	}
	
	class Order{
		
		private String company;
		private int amount;
		
		public Order(String company, int amount) {
			this.company = company;
			this.amount = amount;
		}

		
		public String getCompany() {
			return company;
		}
		
		public int getAmount() {
			return amount;
		}
	}
	
	

}

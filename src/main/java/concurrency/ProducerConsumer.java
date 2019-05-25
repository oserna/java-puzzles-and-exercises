package concurrency;

import java.util.Vector;

public class ProducerConsumer {
	
	
	public static void main(String[] args) {
		System.out.println("Scenario started");
		ProducerConsumer.Broker broker = new Broker();
		Thread consumer = new Thread(new Consumer(broker));
		consumer.start();
		Thread producer = new Thread(new Producer(broker));
		producer.start();
		System.out.println("Scenario finished");
	}
	
	static class Producer implements Runnable{
		
		private Broker broker;
		private int counter = 0;
		private int max = 10;
		private boolean running;
		
		public Producer(Broker broker) {
			this.broker = broker;
		}

		@Override
		public void run() {
			this.running = true;
			System.out.println("Producer started");
			while (running) {
				counter ++;
				try {
					broker.produce("message "+counter);
					System.out.println("Producer, message "+counter+" has been sent");
					if (counter == max) {
						running = false;
						broker.produce("end");
						System.out.println("Producer, final message has been sent");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			System.out.println("Producer finished "+counter);
		}
		
		
		
	}
	
	static class Broker{
		
		private Vector<String> vectorAsQueue;
		private long waitTimeout = 10000;
		private long capacity = 5;
				
		public Broker() {
			this.vectorAsQueue = new Vector();
		}
		
		public synchronized void produce(String message) throws Exception{
			if (this.vectorAsQueue.size() == capacity) {
				System.out.println("Producer is going to sleep");
				this.notify();
				this.wait(waitTimeout);
			}
			this.vectorAsQueue.add(message);
		}
		
		public synchronized String consume() throws Exception{
			if (this.vectorAsQueue.isEmpty()) {
				System.out.println("Consumer is going to wait");
				this.wait(waitTimeout);
			}
			String message = this.vectorAsQueue.get(0);
			this.vectorAsQueue.remove(0);
			this.notify();
			return message;
		}
		
	}
	
	static  class Consumer implements Runnable{
		
		private Broker broker;
		
		public Consumer(Broker broker) {
			this.broker = broker;
		}

		
		@Override
		public void run() {
			System.out.println("Consumer started");
			try {
				String message = null;
				while (!(message = broker.consume()).equals("end")) {
					System.out.println("Consumer, "+message+" has been consumed");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumer finished");
		}
		
	}

}

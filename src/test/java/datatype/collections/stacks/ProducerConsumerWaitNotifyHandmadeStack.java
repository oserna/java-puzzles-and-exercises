package datatype.collections.stacks;

import java.util.Random;
import java.util.concurrent.ExecutionException;


public class ProducerConsumerWaitNotifyHandmadeStack {

	private static int MAX_NUMBERS_TO_GENERATE = 300;

	private static int MAX_INTERVAL_VALUE_TO_GENERATE = 1000;

	private static int MAX_INTERVAL_VALUE_TO_SLEEP = 5000;

	private static int MAX_PRODUCER_CYCLES = 5;

	class Producer implements Runnable {

		private Broker broker = null;

		public Producer(Broker broker) {
			this.broker = broker;
		}

		@Override
		public void run() {

			boolean running = true;

			int cycles = 0;
			while (running) {

				try {
					synchronized (broker) {
						
						for (int i = 0; i < random(MAX_NUMBERS_TO_GENERATE); i++) {
							broker.produce(random(MAX_INTERVAL_VALUE_TO_GENERATE));
						}
	
						cycles++;
	
						if (cycles > MAX_PRODUCER_CYCLES) {
							broker.produce(-1);
							running = false;
						}
	
						broker.notify();
						
						if(running){							
							broker.wait();
						}	
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	class Consumer implements Runnable {

		private Broker broker = null;

		public Consumer(Broker broker) {
			this.broker = broker;
		}

		@Override
		public void run() {

			boolean running = true;

			try {
				while (running) {

					synchronized (broker) {
						
						int numbers = 0;
						int total = 0;
						Integer pop = -1;
						while ((pop = broker.consume()) != null) {

							if (pop == -1) {
								running = false;
								continue;
							}

							numbers++;
							total = total + pop;
						}

						if (numbers > 0)
							System.out.println("Consumed, nums: " + numbers
									+ ", amount: " + total + ", average: "
									+ total / numbers);

						broker.notify();
						if(running){							
							broker.wait();
						}
					}

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	class Broker {

		private HandmadeStack stack = null;

		private int published = 0;
		private int consumed = 0;

		public Broker(HandmadeStack stack) {
			this.stack = stack;
		}

		public void produce(Integer integer) {
			stack.push(integer);
			published++;
		}

		public Integer consume() {			
			Integer pop = stack.pop();
			if (pop != null) {
				consumed++;
			}
			return pop;
		}

		public int getPublished() {
			return published;
		}

		public int getConsumed() {
			return consumed;
		}
	}

	private static int random(int max) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(max);
	}

	public static void main(String[] args) throws InterruptedException,ExecutionException {

		Broker broker = new ProducerConsumerWaitNotifyHandmadeStack().new Broker(new HandmadeStack());

		Thread thread = new Thread(new ProducerConsumerWaitNotifyHandmadeStack().new Consumer(broker));
		thread.start();

		Thread thread2 = new Thread(new ProducerConsumerWaitNotifyHandmadeStack().new Producer(broker));
		thread2.start();

		thread.join();
		thread2.join();

		if (broker.getPublished() == broker.getConsumed()) {
			System.out.println("OK, published: " + broker.getPublished()
					+ " datatype.numbers, consumed: " + broker.getConsumed()
					+ "datatype/numbers");
			return;
		}

		System.out.println("NO OK");

	}

}
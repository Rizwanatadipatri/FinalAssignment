package in.ineuron.in;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Producer_Consumer10 {

	private static final int MAX_SIZE = 10;
	private static final int MAX_NUMBER = 100;
	private static final int NUM_ITERATIONS = 20;

	private Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Producer_Consumer10 example = new Producer_Consumer10();
		example.start();
	}

	private void start() {
		Thread producerThread = new Thread(new Producer());
		Thread consumerThread = new Thread(new Consumer());

		producerThread.start();
		consumerThread.start();

		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class Producer implements Runnable {
		private Random random = new Random();

		@Override
		public void run() {
			for (int i = 0; i < NUM_ITERATIONS; i++) {
				try {
					produce();
					Thread.sleep(random.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private void produce() throws InterruptedException {
			synchronized (queue) {
				while (queue.size() == MAX_SIZE) {
					System.out.println("Queue is full, waiting for consumer...");
					queue.wait();
				}

				int number = random.nextInt(MAX_NUMBER);
				queue.add(number);
				System.out.println("Produced: " + number);
				queue.notifyAll();
			}
		}
	}

	private class Consumer implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < NUM_ITERATIONS; i++) {
				try {
					consume();
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private void consume() throws InterruptedException {
			synchronized (queue) {
				while (queue.isEmpty()) {
					System.out.println("Queue is empty, waiting for producer...");
					queue.wait();
				}

				int number = queue.poll();
				System.out.println("Consumed: " + number);
				queue.notifyAll();
			}
		}
	}
}

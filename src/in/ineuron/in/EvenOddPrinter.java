package in.ineuron.in;

public class EvenOddPrinter {

	public static void main(String[] args) {
		Thread evenThread = new Thread(new EvenRunnable());
		Thread oddThread = new Thread(new OddRunnable());

		evenThread.start();
		oddThread.start();
	}
}

class EvenRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 2; i <= 10; i += 2) {
			System.out.println("Even: " + i);
		}
	}
}

class OddRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 9; i += 2) {
			System.out.println("Odd: " + i);
		}
	}
}

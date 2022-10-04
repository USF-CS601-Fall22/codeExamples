package multithreading.synchronization;

/**
 * CalculatePrimes -- calculate as many primes as we can in ten seconds .
 * Source:
 * http://www.ibm.com/developerworks/java/tutorials/j-threads/j-threads.html
 */
public class CalculatePrimes extends Thread {

	public static final int MAX_PRIMES = 1000000;
	public static final int TEN_SECONDS = 50; //10000;

	public volatile boolean finished = false;
	//public volatile int finished1 = 1;
	//public volatile int finished2 = 3;


	@Override
	public void run() {
		int[] primes = new int[MAX_PRIMES];
		int count = 0;

		for (int i = 2; count < MAX_PRIMES; i++) {

			// Check to see if the timer has expired
			if (finished) {
				break;
			}

			//if (finished1 == finished2)
			//	break;

			boolean prime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					prime = false;
					break;
				}
			}

			if (prime) {
				primes[count++] = i;
				System.out.println("Found prime: " + i);
			}
		}
	}

	public static void main(String[] args) {
		CalculatePrimes calculator = new CalculatePrimes();
		calculator.start();

		CalculatePrimes calculator1 = new CalculatePrimes();
		calculator1.start();

		try {
			//System.out.println(Thread.currentThread().getName());
			Thread.sleep(TEN_SECONDS);
		} catch (InterruptedException e) {
			System.out.println("The thread was interrupted.");
		}

		calculator.finished = true;
	}
}
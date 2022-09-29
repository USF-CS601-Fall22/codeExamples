package multithreading.basics;

/** A simple example demonstrating three threads (main, Thread1, Thread2). 
 *  Shows how to create threads, how to start them, and the use of "join".
 *  Also shows that operations of Thread1 and Thread2 can be "interleaved".
 */
public class PrintTaskExample {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new PrintTask(3), "Thread1");
		Thread t2 = new Thread(new PrintTask(3), "Thread2");
		t1.start();
		t2.start();

		System.out.println(" Done ");
		// main thread will wait for t1 and t2 to finish before printing Done
		/*t1.join();
		t2.join();

		System.out.print(" Done "); // Done will be printed in the end if we use join()
		*/
	}
}

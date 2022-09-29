package multithreading.synchronization;

public class NoSynchronization {
	private int x = 0;

	private class AdditionWorker implements Runnable {
		public void run() {
			for (int i = 0; i < 1000; i++)
				x++;
		}

	}

	private class SubtractionWorker implements Runnable {
		public void run() {
			for (int i = 0; i < 1000; i++)
				x--;
		}
	}

	public void createThreads() throws InterruptedException {
		Thread t1 = new Thread(new AdditionWorker());
		Thread t2 = new Thread(new SubtractionWorker());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		//System.out.println(x);
		if (x != 0)
			System.out.print(x + " ");
		// System.out.println("Done");
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i< 1000; i++) {
			NoSynchronization ns = new NoSynchronization();
			ns.createThreads();
		}
	}

}

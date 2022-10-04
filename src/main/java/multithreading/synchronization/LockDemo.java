package multithreading.synchronization;

/**
 * @author Prof. Engle 
 * 	       This class demonstrates the impact different types of
 *         lock objects have on whether multiple threads may run synchronized
 *         blocks of code simultaneously. OuterClass is courtesy of Prof. Engle.
 */
public class LockDemo {

	// Two worker threads:
	private final Thread worker1;
	private final Thread worker2;

	// Different types of locks
	private final static Object staticLock = new Object();
	private final Object outerLock;
	private final Object multiLock;

	public LockDemo(String name) {
		outerLock = new Object();
		multiLock = new Object();

		/*
		 * Comment in/out different examples and see how the behavior changes.
		 */

		// TT TT FF FF
		// Each worker uses a different lock
		// So they do not need to compete for the locks - each of them can obtain a lock at the same time
		worker1 = new Worker(outerLock);
		worker2 = new Worker(multiLock);

		// TT FF TT FF
		// Both workers 1 and 2 of this instance of LockDemo get the same lock
		// So workers need to compete for the lock
		//worker1 = new Worker(outerLock);
		//worker2 = new Worker(outerLock);
		
		// TT FF TT FF
		// Same case as before. Workers 1 and 2 of this instance of LockDemo
		// compete for one lock, "this"
		//worker1 = new Worker(this);
		//worker2 = new Worker(this);

		// TF TF TF TF
		// There is only one lock for all workers for all instances of LockDemo
		// So they all need to compete for this lock
		// worker1 = new Worker(staticLock);
		// worker2 = new Worker(staticLock);

		// TT TT FF FF
		// Each worker is initialized with a brand new lock
		// So there is no competition between threads, they can each grab their own lock
		//worker1 = new Worker(new Object());
		//worker2 = new Worker(new Object());

		worker1.setName(name + "1");
		worker2.setName(name + "2");

		worker1.start();
		worker2.start();
	}

	public void joinAll() throws InterruptedException {
		worker1.join();
		worker2.join();
	}

	private class Worker extends Thread {

		private final Object lock;

		public Worker(Object lock) {
			this.lock = lock;
			// this.lock = new Object();
		}

		@Override
		public void run() {
			synchronized (lock) {
				System.out.println(this.getName() + ": " + Thread.holdsLock(lock));

				try {
					// The thread will keep its lock while sleeping!
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}

			System.out.println(this.getName() + ": " + Thread.holdsLock(lock));

		}
	}

	public static void main(String[] args) throws InterruptedException {
		LockDemo demo1 = new LockDemo("A");
		LockDemo demo2 = new LockDemo("B");

		demo1.joinAll();
		demo2.joinAll();

		/*
		 * We have the following threads TRYING to run at the same time:
		 *
		 * +---LockDemo A---+  +---LockDemo B---+
		 * | +-A1-+ +-A2-+  |  | +-B1-+ +-B2-+
		 *
		 * Whether A1, A2, B1, B2 are able to run simultaneously (e.g. threads
		 * are able to enter the "locked rooms" setup by each thread) depends on
		 * the type of lock used.
		 */
	}
}

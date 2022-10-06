package multithreading.waitNotify.blockingQueueExample;

import java.util.LinkedList;
import java.util.List;

/** BlockingQueue example - demonstrates the use of wait() and notify().
 * From http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 */
public class BlockingQueue {
	private List<Integer> queue = new LinkedList<>();
	private int capacity;

	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Waits until there is space in the queue, then adds an element to the queue
	 * @param element the element to be added to the queue
	 * @throws InterruptedException
	 */
	public synchronized void enqueue(Integer element) throws InterruptedException {
		// FILL IN CODE:
		// if the queue is full, you need to wait
		// otherwise, add an element to the queue and notify everyone who is waiting on the queue

	}

	/**
	 * Waits until the queue has something to dequeue, then dequeues it and returns the element.
	 * @return the first element from the queue
	 * @throws InterruptedException
	 */
	public synchronized Integer dequeue() throws InterruptedException {
		Integer elem  = null;
		// If the queue is empty, need to wait
		// When the queue is not empty, we can dequeue an element and
		// notify everyone who is waiting on this queue

		return elem;
	}
}

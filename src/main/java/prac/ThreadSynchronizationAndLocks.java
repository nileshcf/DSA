package prac;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;

/**
 * Comprehensive guide to Thread Synchronization, Locks, and Thread Safety
 *
 * Key Concepts:
 * 1. Intrinsic Locks (synchronized keyword)
 * 2. ReentrantLock (explicit locks)
 * 3. Deadlocks and prevention
 * 4. Thread safety mechanisms
 */

public class ThreadSynchronizationAndLocks {

	// ============================================
	// PART 1: INTRINSIC LOCKS (synchronized keyword)
	// ============================================

	/**
	 * Example 1: Basic Counter without synchronization (UNSAFE - Race Condition)
	 */
	static class UnsafeCounter {
		private int count = 0;

		public void increment() {
			count++; // NOT thread-safe - race condition!
		}

		public int getCount() {
			return count;
		}
	}

	/**
	 * Example 2: Using synchronized method (Monitor Lock)
	 * Pros: Simple, automatic lock release
	 * Cons: Limited flexibility, blocking nature
	 */
	static class SafeCounterWithSynchronized {
		private int count = 0;

		// Synchronized method - locks on 'this' object
		public synchronized void increment() {
			count++;
		}

		public synchronized int getCount() {
			return count;
		}
	}

	/**
	 * Example 3: Using synchronized block (more granular control)
	 * Can synchronize on any object (lock object)
	 */
	static class OptimizedCounter {
		private int count = 0;
		private Object lockObject = new Object();

		public void increment() {
			synchronized (lockObject) {
				count++;
			}
		}

		public int getCount() {
			synchronized (lockObject) {
				return count;
			}
		}
	}

	// ============================================
	// PART 2: ReentrantLock (Explicit Locks)
	// ============================================

	/**
	 * Example 4: ReentrantLock - Flexible and Powerful
	 * Pros: Programmatic control, tryLock(), interruptible, fairness
	 * Cons: Manual unlock required (must use finally or try-with-resources)
	 */
	static class CounterWithReentrantLock {
		private int count = 0;
		private Lock lock = new ReentrantLock();

		public void increment() {
			lock.lock();
			try {
				count++;
			} finally {
				lock.unlock(); // CRITICAL - prevents deadlock if exception occurs
			}
		}

		public int getCount() {
			lock.lock();
			try {
				return count;
			} finally {
				lock.unlock();
			}
		}
	}

	/**
	 * Example 5: ReentrantLock with tryLock() - Non-blocking attempt
	 * Useful for preventing indefinite waits
	 */
	static class NonBlockingCounter {
		private int count = 0;
		private Lock lock = new ReentrantLock();

		public boolean tryIncrement() {
			if (lock.tryLock()) {
				try {
					count++;
					return true;
				} finally {
					lock.unlock();
				}
			}
			return false; // Lock was not acquired
		}

		public boolean tryIncrementWithTimeout(long timeout, TimeUnit unit) {
			try {
				if (lock.tryLock(timeout, unit)) {
					try {
						count++;
						return true;
					} finally {
						lock.unlock();
					}
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return false;
		}

		public int getCount() {
			lock.lock();
			try {
				return count;
			} finally {
				lock.unlock();
			}
		}
	}

	/**
	 * Example 6: ReentrantLock with Fairness Policy
	 * Fair locks prevent thread starvation - threads acquire locks in FIFO order
	 * Tradeoff: Slight performance penalty
	 */
	static class FairCounterWithLock {
		private int count = 0;
		private Lock fairLock = new ReentrantLock(true); // true = fair lock

		public void increment() {
			fairLock.lock();
			try {
				count++;
			} finally {
				fairLock.unlock();
			}
		}

		public int getCount() {
			fairLock.lock();
			try {
				return count;
			} finally {
				fairLock.unlock();
			}
		}
	}

	// ============================================
	// PART 3: DEADLOCK EXAMPLES
	// ============================================

	/**
	 * Example 7: DEADLOCK SCENARIO - Circular Resource Dependency
	 * Thread A: Locks Resource1, waits for Resource2
	 * Thread B: Locks Resource2, waits for Resource1
	 * Result: Both threads are permanently stuck!
	 */
	static class DeadlockExample {
		static class Account {
			private int balance;
			private Object lock = new Object();

			public Account(int initialBalance) {
				this.balance = initialBalance;
			}

			public void transferUnsafe(Account targetAccount, int amount) {
				synchronized (this) {
					System.out.println(Thread.currentThread().getName() +
						" acquired lock on " + this);
					try {
						Thread.sleep(100); // Simulate processing time
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}

					synchronized (targetAccount) {
						System.out.println(Thread.currentThread().getName() +
							" acquired lock on " + targetAccount);
						if (this.balance >= amount) {
							this.balance -= amount;
							targetAccount.balance += amount;
						}
					}
				}
			}

			public int getBalance() {
				synchronized (this) {
					return balance;
				}
			}
		}
	}

	/**
	 * Example 8: DEADLOCK PREVENTION - Enforce Strict Lock Ordering
	 * Solution: Always acquire locks in a consistent, global order
	 */
	static class DeadlockPreventionExample {
		static class Account implements Comparable<Account> {
			private int id;
			private int balance;
			private ReentrantLock lock = new ReentrantLock();

			public Account(int id, int initialBalance) {
				this.id = id;
				this.balance = initialBalance;
			}

			@Override
			public int compareTo(Account other) {
				return Integer.compare(this.id, other.id);
			}

			public void transferSafe(Account targetAccount, int amount) {
				// Determine lock order by account ID (consistent ordering)
				Account first, second;
				if (this.id < targetAccount.id) {
					first = this;
					second = targetAccount;
				} else {
					first = targetAccount;
					second = this;
				}

				first.lock.lock();
				try {
					second.lock.lock();
					try {
						System.out.println(Thread.currentThread().getName() +
							" transferring $" + amount);
						if (this.balance >= amount) {
							this.balance -= amount;
							targetAccount.balance += amount;
						}
					} finally {
						second.lock.unlock();
					}
				} finally {
					first.lock.unlock();
				}
			}

			public int getBalance() {
				lock.lock();
				try {
					return balance;
				} finally {
					lock.unlock();
				}
			}
		}
	}

	// ============================================
	// PART 4: THREAD-SAFE COLLECTIONS
	// ============================================

	/**
	 * Example 9: Producer-Consumer Pattern with synchronized
	 * Demonstrates wait() and notify()
	 */
	static class ProducerConsumerQueue {
		private java.util.Queue<Integer> queue = new java.util.LinkedList<>();
		private int capacity;

		public ProducerConsumerQueue(int capacity) {
			this.capacity = capacity;
		}

		public void produce(int value) throws InterruptedException {
			synchronized (queue) {
				while (queue.size() >= capacity) {
					queue.wait(); // Release lock, wait for notify
				}
				queue.add(value);
				System.out.println("Produced: " + value);
				queue.notifyAll(); // Wake up waiting consumers
			}
		}

		public int consume() throws InterruptedException {
			synchronized (queue) {
				while (queue.isEmpty()) {
					queue.wait();
				}
				int value = queue.poll();
				System.out.println("Consumed: " + value);
				queue.notifyAll(); // Wake up waiting producers
				return value;
			}
		}
	}

	// ============================================
	// PART 5: KEY DIFFERENCES - synchronized vs ReentrantLock
	// ============================================

	/**
	 * Comparison Table:
	 *
	 * Feature                  | synchronized  | ReentrantLock
	 * -------------------------+---------------+--------------------
	 * Lock Type                | Intrinsic     | Explicit
	 * Fairness                 | No            | Optional (configurable)
	 * tryLock()                | No            | Yes
	 * Interruptible            | No            | Yes
	 * Timeout Support          | No            | Yes (tryLock)
	 * Conditions (wait/notify) | Yes           | Yes (Condition)
	 * Manual Release           | Automatic     | Manual (required)
	 * Exception Safety         | Automatic     | Must use finally/try-with
	 * Performance              | Good          | Slightly lower
	 * Reentrancy               | Yes           | Yes
	 */

	// ============================================
	// PART 6: THREAD SAFETY BEST PRACTICES
	// ============================================

	/**
	 * Example 10: Thread-Safe Immutable Object
	 * No locks needed - state cannot change
	 */
	static final class ImmutablePerson {
		private final String name;
		private final int age;

		public ImmutablePerson(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}

	// ============================================
	// DEMONSTRATION
	// ============================================

	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== THREAD SYNCHRONIZATION AND LOCKS ===\n");

		// Test 1: Unsafe Counter
		System.out.println("1. UNSAFE COUNTER (Race Condition):");
		testUnsafeCounter();
		System.out.println();

		// Test 2: Synchronized Counter
		System.out.println("2. SYNCHRONIZED COUNTER (Thread-Safe):");
		testSynchronizedCounter();
		System.out.println();

		// Test 3: ReentrantLock Counter
		System.out.println("3. REENTRANT LOCK COUNTER (Thread-Safe):");
		testReentrantLockCounter();
		System.out.println();

		// Test 4: Non-blocking Counter
		System.out.println("4. NON-BLOCKING COUNTER (with tryLock):");
		testNonBlockingCounter();
		System.out.println();

		// Test 5: Fair Lock
		System.out.println("5. FAIR LOCK COUNTER:");
		testFairLockCounter();
		System.out.println();

		// Test 6: Producer-Consumer
		System.out.println("6. PRODUCER-CONSUMER PATTERN:");
		testProducerConsumer();
	}

	private static void testUnsafeCounter() throws InterruptedException {
		UnsafeCounter counter = new UnsafeCounter();
		int NUM_THREADS = 10;
		int INCREMENTS_PER_THREAD = 1000;

		java.util.ArrayList<Thread> threads = new java.util.ArrayList<>();
		for (int i = 0; i < NUM_THREADS; i++) {
			threads.add(new Thread(() -> {
				for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
					counter.increment();
				}
			}));
		}

		for (Thread t : threads)
			t.start();
		for (Thread t : threads)
			t.join();

		int expected = NUM_THREADS * INCREMENTS_PER_THREAD;
		System.out.println("Expected: " + expected + ", Actual: " + counter.getCount());
		System.out.println("Result: " + (counter.getCount() == expected ? "SAFE" : "UNSAFE - RACE CONDITION!"));
	}

	private static void testSynchronizedCounter() throws InterruptedException {
		SafeCounterWithSynchronized counter = new SafeCounterWithSynchronized();
		int NUM_THREADS = 10;
		int INCREMENTS_PER_THREAD = 1000;

		java.util.ArrayList<Thread> threads = new java.util.ArrayList<>();
		for (int i = 0; i < NUM_THREADS; i++) {
			threads.add(new Thread(() -> {
				for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
					counter.increment();
				}
			}));
		}

		for (Thread t : threads)
			t.start();
		for (Thread t : threads)
			t.join();

		int expected = NUM_THREADS * INCREMENTS_PER_THREAD;
		System.out.println("Expected: " + expected + ", Actual: " + counter.getCount());
		System.out.println("Result: " + (counter.getCount() == expected ? "SAFE" : "UNSAFE"));
	}

	private static void testReentrantLockCounter() throws InterruptedException {
		CounterWithReentrantLock counter = new CounterWithReentrantLock();
		int NUM_THREADS = 10;
		int INCREMENTS_PER_THREAD = 1000;

		java.util.ArrayList<Thread> threads = new java.util.ArrayList<>();
		for (int i = 0; i < NUM_THREADS; i++) {
			threads.add(new Thread(() -> {
				for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
					counter.increment();
				}
			}));
		}

		for (Thread t : threads)
			t.start();
		for (Thread t : threads)
			t.join();

		int expected = NUM_THREADS * INCREMENTS_PER_THREAD;
		System.out.println("Expected: " + expected + ", Actual: " + counter.getCount());
		System.out.println("Result: " + (counter.getCount() == expected ? "SAFE" : "UNSAFE"));
	}

	private static void testNonBlockingCounter() throws InterruptedException {
		NonBlockingCounter counter = new NonBlockingCounter();
		int NUM_THREADS = 5;

		java.util.ArrayList<Thread> threads = new java.util.ArrayList<>();
		for (int i = 0; i < NUM_THREADS; i++) {
			threads.add(new Thread(() -> {
				for (int j = 0; j < 100; j++) {
					if (counter.tryIncrement()) {
						System.out.println(Thread.currentThread().getName() + " incremented successfully");
					} else {
						System.out.println(Thread.currentThread().getName() + " could not acquire lock");
					}
				}
			}));
		}

		for (Thread t : threads)
			t.start();
		for (Thread t : threads)
			t.join();

		System.out.println("Final count: " + counter.getCount());
	}

	private static void testFairLockCounter() throws InterruptedException {
		FairCounterWithLock counter = new FairCounterWithLock();
		int NUM_THREADS = 10;
		int INCREMENTS_PER_THREAD = 100;

		java.util.ArrayList<Thread> threads = new java.util.ArrayList<>();
		for (int i = 0; i < NUM_THREADS; i++) {
			threads.add(new Thread(() -> {
				for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
					counter.increment();
				}
			}));
		}

		for (Thread t : threads)
			t.start();
		for (Thread t : threads)
			t.join();

		System.out.println("Final count: " + counter.getCount());
		System.out.println("With fair lock, all threads get equal chances to acquire lock");
	}

	private static void testProducerConsumer() throws InterruptedException {
		ProducerConsumerQueue queue = new ProducerConsumerQueue(3);

		Thread producer = new Thread(() -> {
			try {
				for (int i = 1; i <= 6; i++) {
					queue.produce(i);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "Producer");

		Thread consumer = new Thread(() -> {
			try {
				for (int i = 0; i < 6; i++) {
					queue.consume();
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "Consumer");

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();

		System.out.println("Producer-Consumer completed successfully");
	}
}


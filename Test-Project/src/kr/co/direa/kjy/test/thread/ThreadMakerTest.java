package kr.co.direa.kjy.test.thread;

public class ThreadMakerTest {
	public static void main(String[] args) throws InterruptedException {
		int threadCount = 0;
		while (!Thread.interrupted()) {
			threadCount++;
			System.out.println("Count: " + threadCount);
			String name = String.valueOf(threadCount);
			new Thread(()->{
			      System.out.println(Thread.currentThread());
			      try {
					Thread.sleep(Long.MAX_VALUE);
				} catch (InterruptedException e) {
					e.printStackTrace();
					// Restore interrupted state...
					Thread.currentThread().interrupt();
				}
			}, "Test-Thread-" +name).start();
			Thread.sleep(1000); // Create thread per 0.1 seconds
			
			/* I will use lambda.
			 * new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(Long.MAX_VALUE);
					} catch (InterruptedException e) {
						e.printStackTrace();
						// Restore interrupted state...
						Thread.currentThread().interrupt();
					}
				}
			}).start();*/
		}
	}

}

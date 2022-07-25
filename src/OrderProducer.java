import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable {

	private BlockingQueue<String> queue;

	public OrderProducer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			queue.put("MacBook");
			queue.put("MacBook pro");

			queue.put("MacBook pro max");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

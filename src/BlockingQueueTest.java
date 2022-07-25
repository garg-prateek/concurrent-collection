import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);
		OrderProducer orderProducer = new OrderProducer(queue);
		OrderConsumer orderConsumer = new OrderConsumer(queue);
		
		new Thread(orderProducer).start();
		new Thread(orderConsumer).start();
	}

}

package kr.com.training;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex28_2_TicketSystem {
	private static final int QUEUE_CAPACITY = 10;
	private static final int NUM_PROCEESORS = 3;

	public static void main(String[] args) {
		BlockingQueue<Ticket> ticketQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

		ExecutorService executor = Executors.newFixedThreadPool(NUM_PROCEESORS);

		for (int i = 0; i < NUM_PROCEESORS; i++) {
			executor.submit(new TicketProcessor(ticketQueue));
		}

		for (int i = 1; i <= 100; i++) {
			try {
				Ticket ticket = new Ticket(i, "Description : " + i);
				ticketQueue.put(ticket);
				System.out.println("티켓 및 큐가 생성된 티켓 ID : " + ticket.getId());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

	}

}

class Ticket {
	private int id;
	private String description;

	public Ticket(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

}

class TicketProcessor implements Runnable {
	private BlockingQueue<Ticket> queue;

	public TicketProcessor(BlockingQueue<Ticket> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Ticket ticket = queue.take();

				System.out.printf("%s - 처리할 티켓 ID : %d, Description : %s \n", Thread.currentThread().getName(),
						ticket.getId(), ticket.getDescription());

				Thread.sleep(1000);
				System.out.printf("티켓 ID: %d가 처리되었습니다.\n", ticket.getId());
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}
}

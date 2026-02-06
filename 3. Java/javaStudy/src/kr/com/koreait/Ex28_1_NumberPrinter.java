package kr.com.koreait;

public class Ex28_1_NumberPrinter implements Runnable {
	private Ex28_1_Counter counter;
	private int start;
	private int end;

	Ex28_1_NumberPrinter(Ex28_1_Counter counter, int start, int end) {
		this.counter = counter;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "쓰레드 시작");
		for (int i = start; i <= end; i++) {
			counter.increment();
			System.out.println(Thread.currentThread().getName() + " : " + counter.getCount()); // Thread.currentThread().getName()
																								// // 접근 가능한 이유는 스태틱으로
																								// 이루어져 있어서

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}

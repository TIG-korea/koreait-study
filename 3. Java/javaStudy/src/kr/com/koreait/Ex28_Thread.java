package kr.com.koreait;

public class Ex28_Thread {

	public static void main(String[] args) throws InterruptedException {
//		Ex28_Test t1 = new Ex28_Test("쓰레드1");
//		t1.start(); // 새로운 스레드를 생성하며 실행
//		t1.run(); // 현재 스레드에서 실행 
//		t1.join(); // 쓰레드1의 순서가 끝날떄까지 쓰레드2 대기 (실행 순서 보장)
//		System.out.println("쓰레드1 종료");
//		
//		Ex28_Test t2 = new Ex28_Test("쓰레드2");
//		t2.start();
//		t2.join();
//		System.out.println("쓰레드2 종료");

//		<Thread 클래스 상속받아서 사용할 떄>
//	Ex28_Test t1 = new Ex28_Test("쓰레드1");
//	Ex28_Test t2 = new Ex28_Test("쓰레드2");
//
//	t1.setOther(t2);
//	t2.setOther(t1);
//		
//		t1.start();
//		t2.start();

		// <Runnable 인터페이스 구현해서 사용할 때>

////			1. Runnable을 물려 받은 객체 생성
//		Ex28_Test et1 = new Ex28_Test();
//		Ex28_Test et2 = new Ex28_Test();
//
////			2. Thread 객체 생성
//		Thread t1 = new Thread(et1, "쓰레드1");      // public Thread(Runnable task, String name)
//		Thread t2 = new Thread(et2, "쓰레드2");
//
//		et1.setOther(t2);
//		et2.setOther(t1);
//		t1.start();
//		t2.start();

		// 경쟁 조건
		Ex28_1_Counter counter = new Ex28_1_Counter();
		Ex28_1_NumberPrinter np1 = new Ex28_1_NumberPrinter(counter, 1, 100);
		Ex28_1_NumberPrinter np2 = new Ex28_1_NumberPrinter(counter, 1, 100);

		Thread t1 = new Thread(np1, "쓰레드-1");
		Thread t2 = new Thread(np2, "쓰레드-2");
		t1.start();
		t2.start();

	}
}

// Thread 클래스를 상속 받으면 자바에서는 단일 상속만 지원하기 떄문에
// 다른 필요한 클래슬르 상속받을 수 없는 단점이 있음
//class Ex28_Test extends Thread {
class Ex28_Test implements Runnable {
	private Thread other; // 필드

//	Ex28_Test(String name){
//		super(name);                      // 생성자  ,  인자넣기
//	}

	@Override
	public void run() {
		System.out.println("쓰레드 시작");
		System.out.println("현재 쓰레드 : " + Thread.currentThread().getName()); // 메서드

		if (other != null) {
			System.out.println(other.getName() + "의 종료 기다리는중");
			try {
				other.join();
			} catch (InterruptedException e) { // Interrupted 컴퓨터한테 보내는 신호 ex ) 1번 보내면 중지 ,,, 2번 보내면 시작
				e.printStackTrace();
			}
			System.out.println(other.getName() + "쓰레드가 종료됨!");
		}
	}

	public void setOther(Thread other) {
		this.other = other; // getter / settter
	}

}

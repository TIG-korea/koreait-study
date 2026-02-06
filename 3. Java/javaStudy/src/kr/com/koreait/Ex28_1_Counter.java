package kr.com.koreait;

public class Ex28_1_Counter {
	private int count = 0;

	public synchronized void increment() { // synchronized : 먼저 공유데이터나 메서드에 점유하고 있는 상태인 경우 block으로 처리
		count++;
	}

	public int getCount() {
		return count;
	}

}

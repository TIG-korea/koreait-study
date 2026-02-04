package kr.com.training;

public class Ex23_2_SuperMarket {
	private int milkCount;
	
	public void goSuperMarket(Ex23_2_AvocadoCondition avo) // 다형성 활용
	{
		if(avo.hasAvocado()) {
			milkCount = 6;
		} else {
			milkCount = 1;
		}
	}
	
	public int getMilkCount() {
		return milkCount;
		
	}
	
	
}

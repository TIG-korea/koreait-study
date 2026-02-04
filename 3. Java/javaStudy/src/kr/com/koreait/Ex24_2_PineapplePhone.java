package kr.com.koreait;

public class Ex24_2_PineapplePhone implements Ex24_2_Phone{
	@Override
	public void openingLogo() {
		System.out.println("@@@");
	}
	
	@Override
	public void powerOn() {
		System.out.println("파인애플폰 켜짐");
	}
	
	@Override
	public void powerOff() {
		System.out.println("파인애플폰 꺼짐");
	}
	

}

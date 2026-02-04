package kr.com.koreait;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex24_Abstract {

	public static void main(String[] args) {

		Ex24_1_PineapplePhone p = new Ex24_1_PineapplePhone();
		p.powerOn();
		
		Ex24_2_PineapplePhone p2 = new Ex24_2_PineapplePhone();
		p2.openingLogo();
		p2.powerOff();
		p2.powerOn();
		System.out.println(Ex24_2_PineapplePhone.MAX_BATTERY_CAPACITY);
		
		
	}

}

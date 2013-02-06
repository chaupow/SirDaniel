package general;


import lejos.nxt.Button;
import lejos.nxt.LCD;

public class SMTest {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Button.waitForAnyPress();
		Settings.calibrateLight();	
		SuperMotor.calibrate();
		
		Button.waitForAnyPress();
		p2_Bridge.P2 p2 = new p2_Bridge.P2();
		p2.start();
		
		
		/*
		Button.waitForAnyPress();
		Settings.calibrateLight();
		SuperMotor.calibrate();
		
		p6_slider.P6 p6 = new p6_slider.P6();
		p6.start();
		*/
		}
	
	

}

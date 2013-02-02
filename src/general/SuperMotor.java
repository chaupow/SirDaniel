package general;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;


public final class SuperMotor {

	static NXTMotor motorC = new NXTMotor(MotorPort.C);

	
	public static void turnTo(int angle) {
		
		//TODO Umrechnung
		Motor.C.rotateTo(angle);
	
		}
	
	
	public static void calibrate() {
		
		long lastTime = System.currentTimeMillis();
		
		int power = 30;
		
		boolean stalled = false;
		int tachoCountC = -1;

		
		while (!stalled) {
			long timePassed = System.currentTimeMillis() - lastTime;
			
		if( timePassed > 100) { 
			motorC.setPower(-power);
			
			int currentCountC = motorC.getTachoCount();
		
			if (currentCountC == tachoCountC ) {
				stalled = true;
				LCD.drawString("I stalled...", 0, 6);
				LCD.refresh();
			} else {
				LCD.drawString("I not stalled...", 0, 6);
				LCD.refresh();
			}
			
			tachoCountC = currentCountC;
			lastTime = System.currentTimeMillis();
		}

		}
		
		Motor.C.resetTachoCount();
	}
	
	
}


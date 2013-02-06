package general;

import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;


public final class SuperMotor {

	static NXTMotor motorC = new NXTMotor(MotorPort.C);
	
	static int halfRotation = 740; 
	private static SuperMotor instance = null;

	public static SuperMotor getInstance() {
		if(instance == null) {
			instance = new SuperMotor();
		}
		return instance;
	}
	
	//Singleton!
	private SuperMotor() {
	}
	
	
	public static void turnTo(int angle, boolean ImmediateReturn) {
		
		float roundedAngle = (angle/180.0f)*halfRotation;		
		
		Motor.C.rotateTo((int)roundedAngle, ImmediateReturn);
		
		}
	
	public static void setSpeed(float speed){
		
		Motor.C.setSpeed(speed);
		
	}
	public static void calibrate(){
		calibrateRight();
		calibrateLeft();
	}
	
	/**Returns the angle of the sensorarm. 0 degree represent it positioned right of, 90 degree in front of and 180 degree left of the roboter.**/
	public static int getAngleOfArm(){
		
		int tachoCount = motorC.getTachoCount();
		float ratio = tachoCount/(float) halfRotation;
		float angle = ratio*180;
		
//		LCD.drawString("TachoCount: " + tachoCount, 0, 2);
//		LCD.drawString("ratio: " + ratio, 0,3);
//		LCD.drawString("angle" + angle, 0, 4);
//		
		return (int) (angle);
	}
	
	
	/**Faehrt den Schwenkarm nach rechts und setzt dort den Tacho auf Null**/
	private static void calibrateRight() {
		
		long lastTime = System.currentTimeMillis();
		long timePassed;
		int power = 29;
		
		boolean stalled = false;
		int tachoCountC = -1;

		//Fahre nachrechts bis du anstoesst und setze diesen wert auf null
		while (!stalled) {
			timePassed = System.currentTimeMillis() - lastTime;
			
		if( timePassed > 100) { 
			motorC.setPower(-power);
			
			int currentCountC = motorC.getTachoCount();
		
			if (currentCountC == tachoCountC ) {
				stalled = true;
//				LCD.drawString("I stalled...", 0, 6);
//				LCD.refresh();
			} else {
//				LCD.drawString("I not stalled...", 0, 6);
//				LCD.refresh();
			}
			
			tachoCountC = currentCountC;
			lastTime = System.currentTimeMillis();
		}

		}
//		LCD.drawString("I reseted the TachoCount",1,1);
		motorC.resetTachoCount();
		motorC.setPower(0);
		
	}
	
	/**Faehrt den Schwenkarm nach links und speichert dessen TachoCount**/
	private static void calibrateLeft(){
		long lastTime = System.currentTimeMillis();
		long timePassed;
		int power = 29;
		boolean stalled = false;
		int tachoCountC = -100;

		//fahre so lange nach links, bis du anstoesst und setze diesen wert auf 180;
		while (!stalled) {
			timePassed = System.currentTimeMillis() - lastTime;
			
			if( timePassed > 100) { 
				motorC.setPower(power);
			
				int currentCountC = motorC.getTachoCount();
		
				if (currentCountC == tachoCountC ) {
					stalled = true;
//					LCD.drawString("I stalled...", 0, 6);
//					LCD.refresh();
				} else {
//					LCD.drawString("I not stalled...", 0, 6);
//					LCD.refresh();
				}	
			
				tachoCountC = currentCountC;
				lastTime = System.currentTimeMillis();
			}
		}
//		LCD.drawString("I set the halfRotation", 1, 2);
		halfRotation = motorC.getTachoCount();

	}
	
	
}


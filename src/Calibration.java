import lejos.nxt.LCD;
import lejos.nxt.Motor;

public class Calibration {
	
	static int saveSpeed = 24;
	
	public static void calibrateUltrasonicMotor() {
		Motor.C.setSpeed(saveSpeed);
		Motor.C.forward();
		while(true) {
			LCD.clear();
			LCD.drawInt(Motor.C.getRotationSpeed(), 5, 5);
			LCD.refresh();
		}
		
	}

}

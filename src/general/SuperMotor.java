package general;
import lejos.nxt.Motor;


public final class SuperMotor {
	
	public static void turnTo(int angle) {
		
		Motor.C.rotateTo(angle);
	
		}
	
	public static void calibrate() {
		
		//TODO Threshold anpassen
		Motor.C.setStallThreshold(5, 1);
		while (!Motor.C.isStalled()) {

			//TODO richtige Richtung herausfinden
			Motor.C.backward();
		}
		
		Motor.C.resetTachoCount();
	}
}


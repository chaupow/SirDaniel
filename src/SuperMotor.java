import lejos.nxt.Motor;


public final class SuperMotor {

	static boolean right = true;
	
	
	public static void turn() {
		if (right) {
			// turn Ultrasonic forward and Touch up
			Motor.C.rotateTo(130);
			right = false;
		} else {
			// turn Ultrasonic right and Touch down
			Motor.C.rotateTo(0);
			right = true;
		}
	}
}

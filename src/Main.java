import lejos.nxt.*;

public class Main {

	static NXTRegulatedMotor right = Motor.A;
	static NXTRegulatedMotor left = Motor.B;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
	    Button.waitForAnyPress();
	}
	
	
	/*static void driveForward() {
		
		right.setSpeed(900);
		left.setSpeed(900);
		
	}
	
	/*Stoppt die Motoren der Kettenraeder*/
	static void stop() {
		
		right.stop();
		left.stop();
	}
}

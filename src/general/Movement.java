package general;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public final class Movement extends DifferentialPilot{
	
	private static Movement instance = null;

	public static Movement getInstance() {
		if(instance == null) {
			instance = new Movement();
		}
		return instance;
	}
	
	//Singleton!
	private Movement() {
		super(35, 35, 72, Motor.A, Motor.B, true);
	}
	
	final static float speedup = 1.66f; // = 40 / 24
	final static float wheelRadius = 19; // in millimeters 
	final static float robotRadius = 72; // in millimeters
	final static float empiric = 1.27f;
	final static float measuredSpeedAt3 = 0.29f;
	static int degrees;
	
	// speed has a range of 1(slow) to 6(fast)
//	public void backward(int speed) {
//		speed = convertSpeed(speed);
////		Motor.A.setSpeed(speed);
////		Motor.B.setSpeed(speed);
////		Motor.A.forward();
////		Motor.B.forward(); 
//		setSpeed(speed);
//		backward();
//	}
	
	// speed has a range of 1(slow) to 6(fast)
//	public void forward(int speed) {
//		speed = convertSpeed(speed);
////		Motor.A.setSpeed(speed);
////		Motor.B.setSpeed(speed);
////		Motor.A.backward(true);
////		Motor.B.backward();
//		setSpeed(speed);
//		forward();
//	}
	
	// angle has a range of 0 to 360
	public void turn_right(int angle) {

		Motor.A.stop(true);
		Motor.B.stop();
		degrees = convert(angle/2);
		Motor.A.rotate(-degrees, true);
		Motor.B.rotate(degrees, false);
	}
		
	// angle has a range of 0 to 360
//	public void turn_right(int angle, int speed) {
//		int currentSpeed = Motor.A.getSpeed();
//		setSpeed(speed);
//		turn_right(angle);
//		setSpeed(currentSpeed);
//	}
	
	// angle has a range of 0 to 360
	public void turn_left(int angle) {

		Motor.B.stop(true);
		Motor.A.stop();
		degrees = convert(angle/2);
		Motor.B.rotate(-degrees, true);
		Motor.A.rotate(degrees, false);
	}
	
	// angle has a range of 0 to 360
//	public void turn_left(int angle, int speed) {
//		int currentSpeed = Motor.A.getSpeed();
//		setSpeed(speed);
//		turn_left(angle);
//		setSpeed(currentSpeed);
//	}

	public void setSpeed(int speed) {
//		Motor.A.setSpeed(convertSpeed(speed));
		setTravelSpeed(convertSpeed(speed));
//		Motor.B.setSpeed(convertSpeed(speed));
	}
	
	public void setRotationSpeed(int speed) {
		setRotateSpeed(convertSpeed(speed));		
	}
	
	// return value in m/s
	public float getVelocity() {
		return measuredSpeedAt3;
	}
	
//	public void stop() {
//		Motor.A.stop(true);
//		Motor.B.stop();
//	}
	
	  // convert horizontal angle to rotation angle
	  private static int convert(int angle) {
		  return (int) (empiric * (360 * speedup * robotRadius * Math.toRadians(angle) / (wheelRadius * 2 * Math.PI)));
	  }
	
	  private static int convertSpeed(int speed) {
		  return speed * 180;
	  }
}

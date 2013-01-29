import lejos.nxt.Motor;


public class Movement {
	
	final static float speedup = 1.8f;
	final static int wheelRadius = 16; // in millimeters 
	final static int robotRadius = 120; // in millimeters
	int degrees;

	// speed has a range of 1(slow) to 6(fast)
	public static void forward(int speed) {
		speed = convertSpeed(speed);
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.forward();
		Motor.B.forward();
	}
	
	// speed has a range of 1(slow) to 6(fast)
	public static void backward(int speed) {
		speed = convertSpeed(speed);
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.backward();
		Motor.B.backward();
	}
	
	// angle has a range of 0 to 360
	public static void turn_right(int angle) {
		Motor.B.stop();
		Motor.A.stop();
		
		Motor.B.rotate(convert(angle));
		Motor.A.rotate(-1* convert(angle));
	}
	
	// angle has a range of 0 to 360
	public static void turn_left(int angle) {
		Motor.A.stop();
		Motor.B.stop();
		
		Motor.A.rotate(convert(angle));
		Motor.B.rotate(-1*convert(angle));
	}

	public static void stop() {
		Motor.A.stop();
		Motor.B.stop();
	}
	
	public static void setSpeed(int speed) {
		Motor.A.setSpeed(convertSpeed(speed));
		Motor.B.setSpeed(convertSpeed(speed));
	}
	
  // convert horizontal angle to rotation angle
  public static int convert(int angle) {
	  return (int) (robotRadius * Math.toRadians(angle) / (360 * speedup * wheelRadius * 2 * Math.PI));
  }

  public static int convertSpeed(int speed) {
	  return speed * 180;
  }
}

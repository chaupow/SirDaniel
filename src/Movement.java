import lejos.nxt.Motor;


public class Movement {
	
	final static float speedup = 1.8f;
	final static int wheelRadius = 16; // in millimeters 
	final static int robotRadius = 120; // in millimeters
	int degrees;

	// speed has a range of 1(slow) to 6(fast)
	public void forward(int speed) {
		speed = convertSpeed(speed);
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.forward();
		Motor.B.forward();
	}
	
	// speed has a range of 1(slow) to 6(fast)
	public void backward(int speed) {
		speed = convertSpeed(speed);
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Motor.A.backward();
		Motor.B.backward();
	}
	
	// angle has a range of 0 to 360
	public void turn_right(int angle) {
		Motor.B.stop();
		Motor.A.stop();
		degrees = convert(angle);
		Motor.B.rotate(degrees);
		Motor.A.rotate(-degrees);
	}
	
	// angle has a range of 0 to 360
	public void turn_left(int angle) {
		Motor.A.stop();
		Motor.B.stop();
		degrees = convert(angle);
		Motor.A.rotate(degrees);
		Motor.B.rotate(-degrees);
	}

	public void stop() {
		Motor.A.stop();
		Motor.B.stop();
	}
	
	public void setSpeed(int speed) {
		Motor.A.setSpeed(convertSpeed(speed));
		Motor.B.setSpeed(convertSpeed(speed));
	}
	
  // convert horizontal angle to rotation angle
  public int convert(int angle) {
	  return (int) (robotRadius * Math.toRadians(angle) / (360 * speedup * wheelRadius * 2 * Math.PI));
  }

  public int convertSpeed(int speed) {
	  return speed * 180;
  }
}

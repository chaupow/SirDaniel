import lejos.nxt.LCD;
import lejos.nxt.Motor;

public final class Movement {
	
	final static float speedup = 1.66f; // = 40 / 24
	final static float wheelRadius = 19; // in millimeters 
	final static float robotRadius = 72; // in millimeters
	final static float empiric = 1.25f;
	static int degrees;
//	NXTRegulatedMotor a;
//	NXTRegulatedMotor b;
	
//	public Movement(NXTRegulatedMotor a, NXTRegulatedMotor b) {
//		this.a = a;
//		this.b = b;
//	}

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
			LCD.drawString("rechts", 0, 1);
			Motor.A.stop();
			Motor.B.stop();
			degrees = convert(angle/2);
			Motor.A.rotate(degrees, true);
			Motor.B.rotate(-degrees, false);
		}
	
	// angle has a range of 0 to 360
	public static void turn_left(int angle) {
		LCD.drawString("links", 0, 2);
		Motor.A.stop();
		degrees = convert(angle/2);
		Motor.B.rotate(degrees, true);
		Motor.A.rotate(-degrees, false);
	}
	
	

	public static void stop() {
		Motor.A.stop();
		Motor.B.stop();
	}
	
	public static void setSpeed(int speed) {
		Motor.A.setSpeed(convertSpeed(speed));
		Motor.B.setSpeed(convertSpeed(speed));
	}
	
	public static boolean isMoving(){
		return (Motor.A.isMoving() && Motor.B.isMoving());
	}
	
  // convert horizontal angle to rotation angle
  private static int convert(int angle) {
	  return (int) (empiric * (360 * speedup * robotRadius * Math.toRadians(angle) / (wheelRadius * 2 * Math.PI)));
  }

  private static int convertSpeed(int speed) {
	  return speed * 180;
  }
}

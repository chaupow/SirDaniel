package p8_Line;
import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import p4_LineFollower.Config;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class P8_AvoidObstacle implements Behavior {
	
	boolean suppressed = false;
	UltrasonicSensor sonic;
	Movement movement = Movement.getInstance();
	int threshold = 20;
	
	public P8_AvoidObstacle(UltrasonicSensor sonic) {
		this.sonic = sonic;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() < threshold && SuperMotor.getAngleOfArm() < 100 && SuperMotor.getAngleOfArm() > 80);
	}
	
	public void action() {
		P8_Config.leftTurn = true;
		movement.turn_left(70);
		
		while (!Motor.C.isMoving() && SensorCache.getInstance().normalizedLightValue < P8_Config.lightThreshold && !suppressed) {
			movement.steer(-50, -5, true);
		}
	}

	public void suppress() {
		suppressed = true;
	}
		
}

package p3_LineFollower;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Movement;


public class P3_EndLine implements Behavior{
	Movement movement;
	LightSensor light;
	
	public P3_EndLine(LightSensor light) {
		this.movement = Movement.getInstance();
		this.light = light;
	}
		
	@Override
	public boolean takeControl() {
		return (P3.end && !P3.stop && !P3.search && light.getNormalizedLightValue() >= P3.threshold);
	}

	@Override
	public void action() {
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("End Line", 1, 1);
		
		movement.setSpeed(2);
		movement.forward();
		Delay.msDelay(2000);
		movement.stop();
		P3.stop = true;
	}

	@Override
	public void suppress() {
	}

}

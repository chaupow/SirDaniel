package p3_LineFollowerDeprecated;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Movement;


public class P3_CheckGap implements Behavior{
	LightSensor light;
	Movement movement;
	
	public P3_CheckGap(LightSensor light) {
		this.movement = Movement.getInstance();
		this.light = light;
	}

	@Override
	public boolean takeControl() {
		return (P3.numberOfSearches == 1) && !P3.search && !P3.end;
	}

	@Override
	public void action() {
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("Checking Gap", 1, 1);
		
		movement.setSpeed(1);
		movement.travel(30);
		P3.search = true;;
	}

	@Override
	public void suppress() {
		
	}

}

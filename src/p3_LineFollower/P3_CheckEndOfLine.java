package p3_LineFollower;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Movement;


public class P3_CheckEndOfLine implements Behavior{

	LightSensor light;
	Movement movement;
	
	public P3_CheckEndOfLine(LightSensor light) {
		this.movement = Movement.getInstance();
		this.light = light;
	}
	
	@Override
	public boolean takeControl() {
		return (P3.numberOfSearches == 2) && !P3.end;
	}

	@Override
	public void action() {
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("Checking end of Line", 1, 1);
		
		movement.setSpeed(1);
		movement.backward();
		Delay.msDelay(5000);
		
		//TODO LCD raus
		LCD.drawString("Moved backwards", 1, 2);
		movement.stop();
		if (light.getNormalizedLightValue() >= P3.threshold) {
			P3.end = true;
		}
		else
			P3.search = true;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}

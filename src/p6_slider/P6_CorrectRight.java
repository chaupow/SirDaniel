package p6_slider;

import general.Movement;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class P6_CorrectRight implements Behavior {
	
	UltrasonicSensor sonic;
	int min_dist;
	
	public P6_CorrectRight(UltrasonicSensor sonic, int min_dist){
		this.sonic = sonic;
		this.min_dist = min_dist;		
	}
	
	@Override
	public boolean takeControl() {
		return (sonic.getDistance() < min_dist);
	}

	@Override
	public void action() {
		
		Movement.getInstance().steer(-30, -5, true);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}

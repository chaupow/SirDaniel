package p6_slider;

import general.Movement;
import general.Settings;
import lejos.nxt.LCD;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class P6_Correct implements Behavior {
	
	UltrasonicSensor sonic;
	int dist = 0;
	int angle = 0;
	
	public P6_Correct(UltrasonicSensor sonic, int min_dist){
		this.sonic = sonic;	
		dist = sonic.getDistance();
		angle = dist - min_dist;
		
	}
	
	@Override
	public boolean takeControl() {
		return (angle != 0 );
	}

	@Override
	public void action() {
		
		if (angle < 0) {

			LCD.drawString("Dist: " + dist, 0, 0);
			LCD.drawString("Steering left ", 0, 1);
			Movement.getInstance().steer(30, -2*angle, true);
		} else {
			LCD.drawString("Dist: " + dist, 0, 4);
			LCD.drawString("Steering right ", 0, 5);
			
			Movement.getInstance().steer(-30, -2*angle, true);
		}
	
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}

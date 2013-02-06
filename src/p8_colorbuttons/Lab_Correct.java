package p8_colorbuttons;

import general.Movement;
import lejos.nxt.LCD;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Lab_Correct implements Behavior {
	
	UltrasonicSensor sonic;
	int min_dist = 0;
	int dist = 0;
	ColorButtons cb;
	
	public Lab_Correct(UltrasonicSensor sonic, int min_dist, ColorButtons cb){
		this.sonic = sonic;
		this.min_dist = min_dist;		
		this.cb = cb;
	}
	
	@Override
	public boolean takeControl() {
		
		dist = sonic.getDistance() - min_dist;

		return (dist != 0)&&cb.lab;
	}

	@Override
	public void action() {
		
		if (dist < 0) {

			LCD.drawString("Dist: " + dist, 0, 0);
			LCD.drawString("Steering left ", 0, 1);
			Movement.getInstance().steer(-25, 2*dist, true);
		} else {
			LCD.drawString("Dist: " + dist, 0, 4);
			LCD.drawString("Steering right ", 0, 5);
			
			Movement.getInstance().steer(25, 2*dist, true);
		}
	
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}

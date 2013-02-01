package p4_slider;

import lejos.robotics.subsumption.Behavior;
import general.Movement;

public class P4_PushButton implements Behavior {

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Movement.getInstance().setSpeed(3);
		Movement.getInstance().backward();
		
		while(!Movement.getInstance().isStalled()) {
			Thread.yield();
		}
		
		Movement.getInstance().forward();
		
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	

}

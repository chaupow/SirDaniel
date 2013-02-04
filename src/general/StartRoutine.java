package general;

import lejos.robotics.subsumption.Behavior;

public class StartRoutine implements Behavior {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		Movement.getInstance().setTravelSpeed(2);
		Movement.getInstance().travel(200);
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	
}

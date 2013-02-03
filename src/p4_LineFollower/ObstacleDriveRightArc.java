package p4_LineFollower;

import general.Movement;
import lejos.robotics.subsumption.Behavior;


public class ObstacleDriveRightArc implements Behavior {
	
	boolean suppressed;
	
	public ObstacleDriveRightArc(int speed) {
		Movement.getInstance().setSpeed(speed);
	}
	
	public boolean takeControl(){
		return Config.foundObstacle;
	}
	
	public void suppress(){
		
		suppressed= true;
	}
	
	public void action(){
		
		//Movement.getInstance().arcForward(-1000);
		suppressed = false;
		Movement.getInstance().setTravelSpeed(100);

		Movement.getInstance().arc(-800, -360, true);
		
		while(!suppressed){
			Thread.yield();
		}
		
	}

}

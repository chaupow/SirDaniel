import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class ScanFloor implements Behavior {
	
	private boolean suppressed = false;
	
	//TODO find angle
	private int floorAngle = 30;
	
	public boolean takeControl() {
		return true;
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	public void action() {
		suppressed = false;
				
		while (!suppressed && floorAngle < 180){
			
			Movement.turn_right(floorAngle);
			Movement.turn_left(floorAngle*2);
			Movement.turn_right(floorAngle);
			
			floorAngle += 60;
		}
	}
	

}

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
		Motor.C.rotateTo(floorAngle);
		while( !suppressed )
	        Thread.yield();
	}
	

}

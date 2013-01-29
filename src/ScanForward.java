import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class ScanForward implements Behavior {
	
	private boolean suppressed = false;
	
	//TODO find angle
	private int forwardAngle = 180;
	
	public boolean takeControl() {
		return true;
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	public void action() {
		suppressed = false;
		Motor.C.rotateTo(forwardAngle);
		while( !suppressed )
	        Thread.yield();
	}
	

}

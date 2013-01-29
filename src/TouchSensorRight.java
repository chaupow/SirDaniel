
import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class TouchSensorRight implements Behavior{
	
	private TouchSensor touch;
	private boolean suppressed = false;
	
	public boolean takeControl() {
	
		return touch.isPressed();
	}
	
	public void action() {
		
		//anhalten
		
		//zurueckfahren
		
		// nach links drehen
	}
	
	public void suppress() {
		suppressed = true;		
	}

}

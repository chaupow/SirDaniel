
import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class TouchSensorRight implements Behavior{
	
	private TouchSensor touch;
	boolean suppressed = false;
	
		
	public TouchSensorRight(SensorPort port, int degree) {
		touch = new TouchSensor(port);
	}
	
	public boolean takeControl() {
	
		return touch.isPressed();
	}
	
	public void action() {
		
		//anhalten
		Movement.stop();
		
		//zurueckfahren
		Movement.backwards(1);
		Delay.msDelay(1000);
		Movement.stop();		
		
		// nach links drehen
		
		Movement.turn_left();
		
	}
	
	public void suppress() {
		suppressed = true;		
	}

}


import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class TouchSensorRight implements Behavior{
	
	private TouchSensor touch;
	boolean suppressed = false;
	int degree;
	
		
	public TouchSensorRight(SensorPort port, int degree) {
		touch = new TouchSensor(port);
		this.degree = degree;
	}
	
	public boolean takeControl() {
	
		return touch.isPressed();
	}
	
	public void action() {
		suppressed = false;
		//anhalten
		Movement.stop();
		
		//zurueckfahren
		Movement.backward(1);
		Delay.msDelay(1000);
		Movement.stop();		
		
		// nach links drehen
		
		Movement.turn_left(degree);
		
	}
	
	public void suppress() {
		suppressed = true;		
	}

}

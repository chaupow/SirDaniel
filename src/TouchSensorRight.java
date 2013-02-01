
import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class TouchSensorRight implements Behavior{
	
	private TouchSensor touch;
	boolean suppressed = false;
	int degree;
	Movement movement = Movement.getInstance();
	
		
	public TouchSensorRight(SensorPort port, int degree) {
		touch = new TouchSensor(port);
		this.degree = degree;
	}
	
	public boolean takeControl() {
	
		return touch.isPressed();
	}
	
	public void action() {
		suppressed = false;
		//stop
		movement.stop();
		
		//Driving backwards
		movement.setSpeed(1);
		movement.backward();
		Delay.msDelay(1000);
		
		
		// nach links drehen
	    movement.turn_left(degree);
		
		//clean up
		movement.stop();
		
	}
	
	public void suppress() {
		suppressed = true;		
	}

}

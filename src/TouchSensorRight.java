
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
		//stop
		Movement.stop();
		
		//Driving backwards
		System.out.println("Driving backwards");
		Movement.backward(1);
		Delay.msDelay(1000);
		
		
		// nach links drehen	
		System.out.println("Turning left");
		Movement.turn_left(degree);
		
		while(Movement.isMoving() && !suppressed) 
			Thread.yield();
		
		//clean up
		Movement.stop();
		
	}
	
	public void suppress() {
		suppressed = true;		
	}

}

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class TouchSensorLeft implements Behavior{
	
	TouchSensor touch;
	boolean suppressed = false;
	int degree;
	Movement movement = Movement.getInstance();
	
	public TouchSensorLeft(SensorPort port, int degree) {
		
		touch = new TouchSensor(port);
		this.degree = degree;
	}
	
	public boolean takeControl(){
		return touch.isPressed();
	}
	
	public void suppress(){
		suppressed = true;
	}
	
	
	public void action(){
		suppressed = false;
		//stop
		movement.stop();
		
		//Driving backwards
		movement.setSpeed(1);
		movement.backward();
		Delay.msDelay(1000);
		
		//Turn
		movement.turn_right(degree);
	
	}
	
	

}

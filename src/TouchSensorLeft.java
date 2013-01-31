import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class TouchSensorLeft implements Behavior{
	
	TouchSensor touch;
	boolean suppressed = false;
	int degree;
	Movement movement = new Movement();
	
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
		movement.backward(1);
		Delay.msDelay(1000);
		
		//Turn
		movement.turn_right(degree);
	
		
		//clean up
		movement.stop();
	}
	
	

}

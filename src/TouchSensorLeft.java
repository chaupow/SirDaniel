import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class TouchSensorLeft implements Behavior{
	
	TouchSensor touch;
	boolean suppressed = false;
	int degree;
	
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
		Movement.stop();
		
		//Driving backwards
		Movement.backward(1);
		Delay.msDelay(1000);
		
		//Turn
		Movement.turn_right(degree);
		while(Movement.isMoving() && !suppressed) 
			Thread.yield();
		
		//clean up
		Movement.stop();
	}
	
	

}

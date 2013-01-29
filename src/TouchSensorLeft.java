import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class TouchSensorLeft implements Behavior{
	
	TouchSensor touch;
	boolean suppressed = false;
	
	public TouchSensorLeft(SensorPort port) {
		
		touch = new TouchSensor(port);
	}
	
	public boolean takeControl(){
		return touch.isPressed();
	}
	
	public void action(){
		//anhalten
		Movement.stop();
		
		//rückwärtsfahren
		Movement.backwards(1);
		Delay.msDelay(1000);
		Movement.stop();
		
		//Rechtskurve
		Movement.turn_right(60);
	}
	
	public void suppress(){
		suppressed = true;
	}

}

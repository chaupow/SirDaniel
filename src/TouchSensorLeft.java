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
	
	
	public void action(){
		suppressed = false;
		//anhalten
		Movement.stop();
		
		//rückwärtsfahren
		Movement.backward(1);
		Delay.msDelay(1000);
		Movement.stop();
		
		//Rechtskurve
		Movement.turn_right(degree);
	}
	
	public void suppress(){
		suppressed = true;
	}

}

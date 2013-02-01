package p2_Bridge;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import general.Movement;

public class TouchSensorBridge implements Behavior {
	Movement movement = Movement.getInstance();

	TouchSensor touch;
	
	public TouchSensorBridge(SensorPort touchPort){
		touch = new TouchSensor(touchPort);
	}
	
	public boolean takeControl(){
		return (!touch.isPressed());
	}
	
	public void suppress(){
		
	}
	
	public void action(){
		//movement.stop();
		movement.turn_left(10);
	}
}

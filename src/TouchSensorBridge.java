
import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class TouchSensorBridge implements Behavior {
	Movement movement = new Movement();

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

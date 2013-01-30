
import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class TouchSensorBridge implements Behavior {
	
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
			//Movement.stop();
			Movement.turn_left(10);
		}
}

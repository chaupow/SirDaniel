import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class TouchSensorLeft implements Behavior{
	
	TouchSensor touch;
	boolean suppressed = false;
	
	public boolean takeControl(){
		return touch.isPressed();
	}
	
	public void action(){
		//anhalten
		
		//r�ckw�rtsfahren
		
		
		//Rechtskurve
	}
	
	public void suppress(){
		suppressed = true;
	}

}

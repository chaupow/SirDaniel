import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class AvoidAbyss implements Behavior {
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);
	private int floorDistance = 8;
	
	public boolean takeControl() {
		int distance = sonar.getDistance();
		return  (distance > floorDistance);
	}
	
	public void suppress() {
		
	}
	
	public void action() {
		LCD.clear();
		LCD.drawInt(sonar.getDistance(), 0, 0);
		LCD.refresh();
	}
}

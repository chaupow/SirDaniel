import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import general.Movement;

public class test {

	public static void main (String[] args) {
		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
		while(true) {
			
			LCD.drawString("Dist: " + sonic.getDistance(), 1, 1);
			Delay.msDelay(400);
			LCD.clear();
		}
	}
}

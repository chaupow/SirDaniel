import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Movement;
import general.SensorCache;

public class test implements Behavior{
	SensorCache sc = SensorCache.getInstance();

	public static void main (String[] args) {
		Behavior b = new test();
		Behavior [] bA =  {b};
		Arbitrator a = new Arbitrator(bA);
		a.start();
		
	}

	@Override
	public boolean takeControl() {
		LCD.drawString("Light: " + sc.normalizedLightValue, 1, 1);
		return true;
	}

	@Override
	public void action() {

	}

	@Override
	public void suppress() {
	}
}

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P3 implements Behavior{
	static public boolean foundLineForFirstTime = false; // false!
	static public int numberOfSearches = 0;
	static public boolean stop = false;
	static public boolean search = true;
	static public boolean end = false;
	
	LightSensor light;
	
	static public int threshold = 410;

	public P3() {
		this.light = new LightSensor(SensorPort.S4);
	}
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		Behavior b2 = new P3FollowLine(light);
		Behavior b3 = new P3SearchLine(light);
		Behavior b4 = new P3EndLine();
		Behavior b5 = new P3SearchLineAtStart(light);
		Behavior [] bArray = {b5, b4, b5, b3, b2};
		Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}

	@Override
	public void suppress() {
		stop = true;
	}
	
}

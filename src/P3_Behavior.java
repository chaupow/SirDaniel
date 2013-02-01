import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P3_Behavior implements Behavior{
	static public boolean foundLineForFirstTime = false; // false!
	static public int numberOfSearches = 0;
	static public boolean stop = false;
	static public boolean search = true;
	static public boolean end = false;
	static public boolean isbumped = false;
	
	LightSensor light;
	TouchSensor bumper;
	UltrasonicSensor sonic;
	Movement movement;
	
	static public int threshold = 410;

	public P3_Behavior() {
		this.light = new LightSensor(SensorPort.S4);
		this.bumper = new TouchSensor(SensorPort.S2);
		this.sonic = new UltrasonicSensor(SensorPort.S3);
		this.movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		Behavior follow = new P3_FollowLine(light, movement);
		Behavior search = new P3_SearchLine(light, movement);
		Behavior end = new P3_EndLine(movement);
		Behavior searchStart = new P3_SearchLineAtStart(light, movement);
		Behavior gap = new P3_CheckGap(light, movement);
		Behavior checkEnd = new P3_CheckEndOfLine(light, movement);
		Behavior random = new P3_Random(movement);
		Behavior obstacle = new P3_DriveAroundObstacle(bumper, light, sonic, movement);
		Behavior [] bArray = {random, searchStart, end, gap, checkEnd, search, follow, obstacle};
		Arbitrator arby = new Arbitrator(bArray, true);
	    arby.start();
	}

	@Override
	public void suppress() {
	}
	
}

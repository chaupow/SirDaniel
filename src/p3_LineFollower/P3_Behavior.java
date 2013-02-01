package p3_LineFollower;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SirDanielArbitrator;

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
	SirDanielArbitrator arby;
	Thread t;
	
	static public int threshold = 410;

	public P3_Behavior() {
		
		this.light = new LightSensor(SensorPort.S4);
		this.bumper = new TouchSensor(SensorPort.S2);
		this.sonic = new UltrasonicSensor(SensorPort.S3);
		this.movement = Movement.getInstance();
		
		Behavior follow = new P3_FollowLine(light);
		Behavior search = new P3_SearchLine(light);
		Behavior end = new P3_EndLine();
		Behavior searchStart = new P3_SearchLineAtStart(light);
		Behavior gap = new P3_CheckGap(light);
		Behavior checkEnd = new P3_CheckEndOfLine(light);
		Behavior random = new P3_Random();
		Behavior obstacle = new P3_DriveAroundObstacle(bumper);
		Behavior [] bArray = {random, searchStart, end, gap, checkEnd, search, follow, obstacle};
		arby = new SirDanielArbitrator(bArray, true);
	}
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		
		t = new Thread(arby);
	    t.run();
	}

	@Override
	public void suppress() {
		
		arby.stop();
	}
	
}

package p4_LineFollower;

import general.SensorCache;
import general.SirDanielArbitrator;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Obstacle {
	UltrasonicSensor sonic;
	
	public Obstacle() {
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		Behavior random = new Random();
		Behavior setRandom = new RandomDetect(2);
		Behavior crossGap = new GapCrossGap();
		Behavior follow = new FollowLine();
		Behavior search = new SearchLine();
		Behavior detectObstacle = new ObstacleDetect();
		Behavior [] bArray = {crossGap, follow, search};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		t.start();
	}
}

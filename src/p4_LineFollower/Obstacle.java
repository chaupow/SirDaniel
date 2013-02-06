package p4_LineFollower;

import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Obstacle {
	UltrasonicSensor sonic;
	int min_dist = 8;
	int max_dist = 20;
	int shouldBe = 10;
	int minimumDifference = 50;
	
	public Obstacle() {
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
public void run() {
		
		Behavior random = new Random();
		Behavior setRandom = new RandomDetect(3);
		Behavior checkEnd = new CheckEnd();
		Behavior setCheckEnd = new CheckEndDetect(2); 
		Behavior crossGap = new GapCrossGap();
		Behavior follow = new FollowLine();
		Behavior search = new SearchLine();
		Behavior forward = new p4_LineFollower.DriveForward();
		Behavior setForward = new DriveForwardDetect(2);
		Behavior detectObstacle = new ObstacleDetect(sonic);
		Behavior quitObstacle = new ObstacleQuit();
		Behavior [] bArray = {crossGap, follow, setCheckEnd, checkEnd, setForward, forward, setRandom, random, search, detectObstacle, quitObstacle};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		t.start();
	}
	
	public static void main(String [] args) {
		SuperMotor.calibrate();
		Button.waitForAnyPress();
		Obstacle gap = new Obstacle();
		gap.run();
	}
}

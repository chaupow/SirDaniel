package p4_LineFollower;


import p1_labyrinth.P1_CorrectLeft;
import p1_labyrinth.P1_CorrectRight;
import p1_labyrinth.P1_TurnLeft;
import p1_labyrinth.P1_TurnRight;
import general.DriveForward;
import general.SensorCache;
import general.SirDanielArbitrator;
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
		Behavior correctRight = new ObstacleCorrectRight(sonic,  max_dist);
		Behavior correctLeft = new ObstacleCorrectLeft(sonic, min_dist);
		Behavior turnRight = new ObstacleTurnRight(sonic, shouldBe, minimumDifference);
		Behavior turnLeft = new ObstacleTurnLeft();
		Behavior [] bArray = {crossGap, follow, setCheckEnd, checkEnd, setForward, forward, setRandom, random, search, detectObstacle, correctRight, correctLeft, turnRight, turnLeft};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		t.start();
	}
}

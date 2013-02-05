package p0_Race;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.SirDanielArbitrator;

public class Race {
	
	private SirDanielArbitrator arby;
	
	public void start() {
		
		UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
		int speed = 1;
		int rotationSpeed = 1;
		int min_dist = 10;
		int shouldBe = 10;
		int minimumDifference = 30;
		
		Behavior forward = new P0_DriveForward(200);
		Behavior correct = new P0_Correct(sonar, min_dist);
		Behavior turnRight = new P0_TurnRight(sonar, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P0_TurnLeft(speed, rotationSpeed);
		Behavior avoidObstacle = new AvoidObstacle();
		Behavior [] b = {forward, correct, turnRight, turnLeft, avoidObstacle};
		
		arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread(arby);
		
		System.out.println("Race started");
		t.start();
	}
	
	public void stop() {
		arby.stop();
	}
}
package p0_Race;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Section;
import general.SirDanielArbitrator;

public class Race implements Section {
	
	private SirDanielArbitrator arby;
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	
	private static final int SPEED = 1;
	private static final int ROTATION_SPEED = 1;
	private static final int MINIMUM_DISTANCE = 10;
	private static final int TARGET_DISTANCE = 10;
	private static final int CURVE_DIFFERENCE = 30;
	
	public void start() {
		
		Behavior forward = new P0_DriveForward(200);
		Behavior correct = new P0_Correct(sonar, MINIMUM_DISTANCE);
		Behavior turnRight = new P0_TurnRight(sonar, SPEED, ROTATION_SPEED, TARGET_DISTANCE, CURVE_DIFFERENCE);
		Behavior turnLeft = new P0_TurnLeft(SPEED, ROTATION_SPEED);
		Behavior avoidObstacle = new AvoidObstacle();
		Behavior endOfRace = new EndRace();
		Behavior [] b = {forward, correct, turnRight, turnLeft, avoidObstacle, endOfRace};
		
		arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread(arby);
		
		System.out.println("Race started");
		t.start();
	}
	
	public void stop() {
		arby.stop();
	}
}
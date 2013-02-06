package p0_Race;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Section;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class Race implements Section {
	
	private SirDanielArbitrator arby;
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);
	
	private static final int SPEED = 1;
	private static final int ROTATION_SPEED = 1;
	private static final int MINIMUM_DISTANCE = 10;
	private static final int TARGET_DISTANCE = 10;
	private static final int CURVE_DIFFERENCE = 30;
	
	public void start() {
		LCD.clear();
		SuperMotor.turnTo(0, false);
		Constants.alreadyStopped = false;
		
		Behavior forward = new P0_DriveForward(200);
		Behavior correct = new P0_Correct(sonar, MINIMUM_DISTANCE);
		Behavior turnRight = new P0_TurnRight(sonar, SPEED, ROTATION_SPEED, TARGET_DISTANCE, CURVE_DIFFERENCE);
		Behavior turnLeft = new P0_TurnLeft(SPEED, ROTATION_SPEED);
		Behavior avoidObstacle = new AvoidObstacle();
		Behavior endOfRace = new EndRace();
		Behavior [] b = {forward, correct, turnRight, turnLeft, avoidObstacle, endOfRace};
		
		arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread(arby);
		
		Button.waitForAnyPress();
		
		//TODO aendern in 10000 = 10 sek.
		Delay.msDelay(1000);
		
		System.out.println("Race started");
		t.start();
	}
	
	public void stop() {
		System.out.println("Race really stopped.");
		arby.stop();
	}
}
package p0_Race;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Calibration;
import general.DriveForward;
import general.Movement;
import general.Settings;
import general.SirDanielArbitrator;
import p1_labyrinth.*;

public class Race implements Behavior {
		
	int speed = 1;
	int rotationSpeed = 1;
	int min_dist = 10;
	int shouldBe = 10;
	int minimumDifference = 30;
	
	private SirDanielArbitrator arby;
	private Thread t;
		
	
	public Race(UltrasonicSensor sonic) {
		
		Behavior forward = new P0_DriveForward(200);
		Behavior correct = new P0_Correct(sonic, min_dist);
		Behavior turnRight = new P0_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P0_TurnLeft(speed, rotationSpeed);
		Behavior avoidObstacle = new AvoidObstacle();
		Behavior [] b = {forward, correct, turnRight, turnLeft, avoidObstacle};
		this.arby = new SirDanielArbitrator(b,true);
		t = new Thread(arby);
		
		Constants.alreadyStopped = false;
	}
	
   public static void race(){
	   
	   UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
		int speed = 1;
		int rotationSpeed = 1;
		int min_dist = 10;
		int shouldBe = 10;
		int minimumDifference = 30;
		
		Calibration.labyrinth = true;
		Constants.alreadyStopped = false;
		
		Behavior forward = new DriveForward(1);
		Behavior correct = new P1_Correct(sonic, min_dist);
		Behavior turnRight = new P0_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P0_TurnLeft(speed, rotationSpeed);
		Behavior avoidObstacle = new AvoidObstacle();
		Behavior [] b = {forward, correct, turnRight, turnLeft, avoidObstacle};
		SirDanielArbitrator arby = new SirDanielArbitrator(b,true);
		
		Movement.getInstance().setTravelSpeed(360);
		//Thread t = new Thread(arby);
		//Button.waitForAnyPress();
		//t.start();
		arby.run();
   }

@Override
public boolean takeControl() {
	// TODO Auto-generated method stub
//	return Settings.race;
	return true;
}

@Override
public void action() {
	// TODO Auto-generated method stub
	LCD.drawString("I'm going to race", 0, 5);
	t.start();
}

@Override
public void suppress() {
//	Settings.race = false;
}
	
}

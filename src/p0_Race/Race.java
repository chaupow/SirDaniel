package p0_Race;
import p6_slider.P6_Correct;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Calibration;
import general.DriveForward;
import general.Movement;
import general.SirDanielArbitrator;
import p1_labyrinth.*;

public class Race {
			
		
   public static void main(String [] args) {
	   
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
		Behavior turnRight = new P1_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P0_TurnLeft(speed, rotationSpeed);
		Behavior avoidObstacle = new AvoidObstacle();
		Behavior [] b = {forward, correct, turnRight, turnLeft, avoidObstacle};
		SirDanielArbitrator arby = new SirDanielArbitrator(b,true);
		
		Movement.getInstance().setTravelSpeed(360);
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		t.start();
		
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
		Behavior turnRight = new P1_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
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
	
}

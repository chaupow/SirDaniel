package p1_labyrinth;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.DriveForward;
import general.SirDanielArbitrator;

public class P1 {
		
	
   public static void main(String [] args) {
	   
	    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
		int speed = 1;
		int rotationSpeed = 2;
		int min_dist = 10;
		int max_dist = 15;
		int shouldBe = 10;
		int minimumDifference = 30;
		
		//Behavior driveForward = new DriveForward(speed);
		Behavior driveRightArc = new P1_DriveRightArc(speed);
		//Behavior correctRight = new P1_CorrectRight(sonic, speed, rotationSpeed,  max_dist);
		Behavior correctLeft = new P1_CorrectLeft(sonic, speed, rotationSpeed, min_dist);
		Behavior turnRight = new P1_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P1_TurnLeft(speed, rotationSpeed);
		Behavior [] b = {driveRightArc, correctLeft, turnRight, turnLeft};
		SirDanielArbitrator arby = new SirDanielArbitrator(b);
		
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		t.start();
		
   }


}

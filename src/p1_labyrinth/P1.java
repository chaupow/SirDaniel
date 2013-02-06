package p1_labyrinth;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P1 {
	
	SirDanielArbitrator arby;
	
   public void start() {
	   System.out.println("Labyrinth started.");
	    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	    
	    SuperMotor.turnTo(0, false);
	    
		int speed = 1;
		int rotationSpeed = 1;
		int min_dist = 10;
		int shouldBe = 10;
		int minimumDifference = 30;
		
		//Calibration.labyrinth = true;
//		Settings.labyrinth = true;
		
		Behavior forward = new P1_DriveForward(180);
		Behavior correct = new P1_Correct(sonic, min_dist);
		Behavior turnRight = new P1_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P1_TurnLeft(speed, rotationSpeed);
		Behavior endLabyrinth = new P1_EndLabyrinth();
		Behavior [] b = {forward,correct, turnRight, turnLeft, endLabyrinth};
		arby = new SirDanielArbitrator(b,true);
		Thread t =  new Thread(arby);
		t.start();
	}
   
   public void stop() {
	   System.out.println("Labyrinth stopped.");
	   arby.stop();
   }



}

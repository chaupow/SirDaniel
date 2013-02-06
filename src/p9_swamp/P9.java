package p9_swamp;
import p1_labyrinth.P1_Correct;
import p1_labyrinth.P1_DriveForward;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

import general.SirDanielArbitrator;
import general.SuperMotor;

public class P9 {
	
	private SirDanielArbitrator arby;
	private UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	
	private int min_dist = 15;

	
   public void start() {
	   System.out.println("Swamp started.");
    
	    SuperMotor.turnTo(0, false);
	    
		//Calibration.labyrinth = true;
//		Settings.labyrinth = true;
		
		Behavior forward = new P1_DriveForward(200);
		Behavior correct = new P1_Correct(sonic, min_dist);
		Behavior [] b = {forward,correct};
		arby = new SirDanielArbitrator(b,true);
		Thread t =  new Thread(arby);
		t.start();
	}
   
   public void stop() {
	   System.out.println("Swamp stopped.");
	   arby.stop();
   }



}

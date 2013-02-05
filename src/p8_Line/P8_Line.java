package p8_Line;

import p6_slider.P6_Correct;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Calibration;
import general.DriveForward;
import general.Movement;
import general.SensorCache;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P8_Line {
	   public static void main(String [] args) {
		    
			UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
			
			Behavior findLine = new P8_FindLine();
			Behavior foundLine = new P8_FoundLine();
			Behavior lost = new P8_Lost();
			Behavior findEnd = new P8_FindEnd();
			Behavior avoidObstacle = new P8_AvoidObstacle(sonic);
			
			Behavior [] b = {foundLine, findLine, findEnd, lost, avoidObstacle};
//			Arbitrator arby = new Arbitrator(b, true);
			SirDanielArbitrator arby = new SirDanielArbitrator(b,true);
			
			Movement.getInstance().setTravelSpeed(360);
//			P8_Config.lost = false;
			P8_Config.numberOfSearches = 0;
			Thread t = new Thread(arby);			
			Button.waitForAnyPress();
			SuperMotor.setSpeed(380);
			SuperMotor.calibrate();
			SuperMotor.turnTo(90, false);
			t.start();
//			arby.start();
			LCD.drawString("rausgesprungen", 0, 0);
			Button.waitForAnyPress();
			
	   }



}

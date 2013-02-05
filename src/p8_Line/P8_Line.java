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
		    
			
			
			Behavior findLine = new P8_FindLine();
			Behavior foundLine = new P8_FoundLine();
			
			Behavior [] b = {foundLine, findLine};
//			Arbitrator arby = new Arbitrator(b, true);
			SirDanielArbitrator arby = new SirDanielArbitrator(b,true);
			
			Movement.getInstance().setTravelSpeed(360);
			Thread t = new Thread(arby);			
			Button.waitForAnyPress();
			SuperMotor.setSpeed(380);
			SuperMotor.calibrate();
			SuperMotor.turnTo(90, false);
			t.start();
//			arby.start();
			
	   }



}

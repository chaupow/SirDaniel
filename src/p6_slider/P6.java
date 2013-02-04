package p6_slider;

import p1_labyrinth.P1_DriveRightArc;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Calibration;
import general.DriveForward;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P6 {
	static UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	static int min_dist = 8;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Calibration.slider = true;
		SuperMotor.calibrate();
		SuperMotor.turnTo(0, false);
		Calibration.NumberOfTurns = 0;
		
		//TODO Linefollower rein
		Behavior correct = new P6_Correct(sonic, min_dist);
		Behavior backwards = new P6_travelBackwards();
		Behavior button = new P6_PushButton();
		
		Behavior [] b = { correct, backwards, button};
		SirDanielArbitrator arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread (arby);
		Button.waitForAnyPress();
		t.start();
	}

}

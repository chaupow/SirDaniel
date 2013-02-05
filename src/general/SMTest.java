package general;

import java.util.Vector;

import p4_LineFollower.FollowLine;
import p4_LineFollower.SearchLine;

import start_routine.LightCalibration;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TachoMotorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class SMTest {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
		
		Behavior b1 = new p0_Race.Race(sonic);
		Behavior labyrinth = new p1_labyrinth.P1(sonic);
		Behavior b2 = new DriveForward(2);
		Behavior [] b = {b2,labyrinth,b1};
		
		SirDanielArbitrator arby = new SirDanielArbitrator(b);
		BarcodeReader barcodes = new BarcodeReader();
		
		Button.waitForAnyPress();
		SuperMotor.calibrate();

		Settings.calibrateLight();
		
		SuperMotor.turnTo(90, false);
		
		Button.waitForAnyPress();

		Thread barcode = new Thread(barcodes);
		barcode.start();
		
		Thread t = new Thread(arby);
		t.start();
		
		
		
		}
	
	

}

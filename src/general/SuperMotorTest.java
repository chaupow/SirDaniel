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

public class SuperMotorTest {

	static UltrasonicSensor sonic;
	static int min_dist = 10;


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Behavior follow = new FollowLine();
		Behavior search = new SearchLine();
		//Behavior calibrate = new LightCalibration();
		Behavior lineCount = new LineCounting();
		
		Movement.getInstance().setTravelSpeed(70);
		
		Behavior [] b = {lineCount,search, follow};
		SirDanielArbitrator arby = new SirDanielArbitrator(b);
		
		//Thread t = new Thread(arby);
		Button.waitForAnyPress();
		//t.start();
		arby.run();
	
	}
	
	

}

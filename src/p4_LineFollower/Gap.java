package p4_LineFollower;

import general.SensorCache;
import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Gap {
	SensorCache sensorCache;
	
	public Gap() {
		SuperMotor.calibrate();
		SuperMotor.turnTo(90, false);
		this.sensorCache = SensorCache.getInstance();
	}
	
	public void run() {
		
		Behavior random = new Random();
		Behavior setRandom = new RandomDetect(3);
		Behavior checkEnd = new CheckEnd();
		Behavior setCheckEnd = new CheckEndDetect(2); 
		Behavior crossGap = new GapCrossGap();
		Behavior follow = new FollowLine();
		Behavior search = new SearchLine();
		Behavior forward = new DriveForward();
		Behavior setForward = new DriveForwardDetect(2);
		Behavior [] bArray = {crossGap, follow, setCheckEnd, checkEnd, setForward, forward, setRandom, random, search};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		t.start();
	}
	
	public static void main(String [] args) {
		Button.waitForAnyPress();
		Gap gap = new Gap();
		gap.run();
	}
}

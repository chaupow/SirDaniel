package p4_LineFollower;

import general.SensorCache;
import general.SirDanielArbitrator;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Plate {
	UltrasonicSensor sonic;
	
	public Plate() {
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		Behavior random = new Random();
		Behavior setRandom = new RandomDetect(1);
		Behavior search = new SearchLine(); 
		Behavior follow = new FollowLine();
		Behavior openPlate = new PlateOpen();
		Behavior onPlate = new PlateOnPlate();
		Behavior correctPlate = new PlateCorrectPlate(sonic);
		Behavior rotatePlate = new PlateRotate();
		Behavior start = new PlateStart();
		Behavior [] bArray = {search, follow, openPlate, onPlate, correctPlate, rotatePlate, start};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		t.start();
	}
}

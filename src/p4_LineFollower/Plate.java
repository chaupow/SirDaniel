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
	SensorCache sensorCache;
	UltrasonicSensor sonic;
	
	public Plate() {
		this.sensorCache = SensorCache.getInstance();
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		Behavior random = new Random();
		Behavior search = new SearchLine(sensorCache); 
		Behavior follow = new FollowLine(sensorCache);
		Behavior openPlate = new PlateOpen(sensorCache);
		Behavior onPlate = new PlateOnPlate(sensorCache);
		Behavior correctPlate = new PlateCorrectPlate(sensorCache, sonic);
		Behavior rotatePlate = new PlateRotate(sensorCache);
		Behavior start = new PlateStart(sensorCache);
		Behavior [] bArray = {random, search, follow, openPlate, onPlate, correctPlate, rotatePlate, start};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		t.start();
	}
}

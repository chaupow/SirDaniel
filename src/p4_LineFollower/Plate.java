package p4_LineFollower;

import general.SirDanielArbitrator;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Plate {
	LightSensor light;
	TouchSensor bumper;
	UltrasonicSensor sonic;
	
	public Plate() {
		this.light = new LightSensor(SensorPort.S4);
		this.bumper = new TouchSensor(SensorPort.S2);
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		Behavior random = new Random();
		Behavior search = new SearchLine(light); 
		Behavior follow = new FollowLine(light);
		Behavior openPlate = new PlateOpen(bumper);
		Behavior onPlate = new PlateOnPlate(bumper);
		Behavior correctPlate = new PlateCorrectPlate(bumper, sonic);
		Behavior rotatePlate = new PlateRotate(bumper);
		Behavior start = new PlateStart(light);
		Behavior [] bArray = {random, search, follow, openPlate, onPlate, correctPlate, rotatePlate, start};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		t.start();
	}
}

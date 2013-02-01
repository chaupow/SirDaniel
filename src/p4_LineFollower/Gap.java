package p4_LineFollower;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Gap {
	LightSensor light;
	TouchSensor bumper;
	UltrasonicSensor sonic;
	
	public Gap() {
		this.light = new LightSensor(SensorPort.S4);
		this.bumper = new TouchSensor(SensorPort.S2);
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		Behavior follow = new FollowLine(light);
		Behavior search = new SearchLine(light);
	}
}

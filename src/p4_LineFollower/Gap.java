package p4_LineFollower;

import general.SensorCache;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class Gap {
	SensorCache sensorCache;
	UltrasonicSensor sonic;
	
	public Gap() {
		this.sensorCache = SensorCache.getInstance();
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		Behavior crossGap = new GapCrossGap();
		Behavior random = new Random();
		Behavior follow = new FollowLine(sensorCache);
		Behavior search = new SearchLine(sensorCache);
	}
}

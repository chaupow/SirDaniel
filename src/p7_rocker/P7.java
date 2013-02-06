package p7_rocker;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P7 {
	
	SirDanielArbitrator arby;
	UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	
	public void start() {
		
		
		Behavior rocker = new p7_rocker(140,100,sonic);		
		Behavior [] b = {rocker};
		
		SuperMotor.turnTo(90, false);
		
		arby = new SirDanielArbitrator(b);
		Thread t = new Thread(arby);
		
		t.start();
		
	}
	
	
	public void stop() {
		arby.stop();
	}

}

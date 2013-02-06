package p9_btGate;

import general.Movement;
import general.Section;
import general.SirDanielArbitrator;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class P9 implements Section {
	
	private UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	private SirDanielArbitrator arby;
	
	private final static int DISTANCE_THRESHOLD = 15;
	public boolean inFrontOfGate; 
	
	public void start() {
		Movement.getInstance().setTravelSpeed(300);
		
		Behavior throughGate = new P9_DriveThrough(sonic, DISTANCE_THRESHOLD, this);
		Behavior openGate = new P9_OpenGate(this);
		Behavior wait = new P9_Wait();
		Behavior [] bArray = {wait, throughGate, openGate};
		arby = new SirDanielArbitrator(bArray, true);
		
		Thread t = new Thread(arby);
		
		System.out.println("Gate started");
		t.start();
	}
	
	public void stop() {
		arby.stop();
	}
}

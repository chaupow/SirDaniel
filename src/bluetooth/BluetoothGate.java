package bluetooth;

import general.Movement;
import general.SirDanielArbitrator;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class BluetoothGate {
	UltrasonicSensor sonic;
	int distanceThreshold = 15;
	public boolean inFrontOfGate; 
	
	public BluetoothGate() {
		this.sonic = new UltrasonicSensor(SensorPort.S3);
	}
	
	public void run() {
		Behavior throughGate = new DriveThroughGate(sonic, distanceThreshold, this);
		Behavior openGate = new OpenGate(this);
		Behavior wait = new WaitForGate();
		Behavior [] bArray = {wait, throughGate, openGate};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		t.start();
	}
	
	public static void main (String [] args) {
		Movement.getInstance().setTravelSpeed(300);
		BluetoothGate blGate = new BluetoothGate();
		Button.waitForAnyPress();
		blGate.run();
	}
}

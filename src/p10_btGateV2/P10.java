package p10_btGateV2;

import p10_btGate.P10_DriveThrough;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.Section;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P10 implements Section {
	
	private SirDanielArbitrator arby;

	@Override
	public void start() {
		
		SuperMotor.turnTo(180, false);
		
		Behavior gate = new P10_Gate();
		Behavior adjust = new P10_Adjust();
		Behavior [] b = {gate, adjust};
		
		arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread(arby);
		
		System.out.println("Gate started");
		t.start();
		
	}

	@Override
	public void stop() {
		arby.stop();
	}

}

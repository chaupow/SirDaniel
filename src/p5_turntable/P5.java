package p5_turntable;

import p8_Line.P8_Line;
import lejos.robotics.subsumption.Behavior;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P5 {
	
	private SirDanielArbitrator arby;
	
	private static P5 instance = null;

	public static P5 getInstance() {
		if(instance == null) {
			instance = new P5();
		}
		return instance;
	}

	public void start(boolean afterLine) {
		
		// called by StateMachine
		if (!afterLine) {
			P8_Line.getInstance().start(0); // 0 == called by turntable
		} else {
			// called by Line
			SuperMotor.turnTo(0, false);
			
			Behavior turntable = new P5_Turntable();
			Behavior [] b = {turntable};
			
			arby = new SirDanielArbitrator(b, true);
			
			Thread t = new Thread(arby);
			
			System.out.println("Turntable started");
			t.start();
		}
	}

	public void stop() {
		arby.stop();
		P8_Line.getInstance().start(1);
	}
}


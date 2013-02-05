package p5_turntable;

import lejos.robotics.subsumption.Behavior;
import general.Section;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P5 implements Section {
	
	private SirDanielArbitrator arby;
	private boolean afterLine = false;

	@Override
	public void start() {
		
		SuperMotor.turnTo(0, false);
		
		Behavior turntable = new P5_Turntable();
		Behavior [] b = {turntable};
		
		arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread(arby);
		
		System.out.println("Race started");
		t.start();
	}

	@Override
	public void stop() {
		arby.stop();
	}
	
	public void setAfterLine(boolean value) {
		afterLine = value;
	}
	
	public boolean getAfterLine() {
		return afterLine;
	}
	
}


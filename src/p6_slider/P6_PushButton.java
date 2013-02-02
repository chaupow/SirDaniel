package p6_slider;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Calibration;
import general.Movement;

public class P6_PushButton implements Behavior {
	
	private NXTMotor motorA = new NXTMotor(MotorPort.A);
	private NXTMotor motorB = new NXTMotor(MotorPort.B);

	// set the interval. 
	private int DELAY = 100;
	private long lastTime = System.currentTimeMillis();
	
	// make sure he doesn't stall at the beginning
	private int tachoCountA = -1;
	private int tachoCountB = -1;

	@Override
	public boolean takeControl() {
		int power = Calibration.MOVEMENT_POWER;
		
		boolean stalled = false;
		long timePassed = System.currentTimeMillis() - lastTime;
		
		if( timePassed > DELAY) { 
			motorA.setPower(power);
			motorB.setPower(power);
			
			int currentCountA = motorA.getTachoCount();
			int currentCountB = motorB.getTachoCount();
		
			if (currentCountA == tachoCountA || currentCountB == tachoCountB) {
				stalled = true;
				LCD.drawString("I stalled...", 0, 6);
				LCD.refresh();
			} else {
				LCD.drawString("I not stalled...", 0, 6);
				LCD.refresh();
			}
			
			tachoCountA = currentCountA;
			tachoCountB = currentCountB;
			lastTime = System.currentTimeMillis();
		}
		return stalled;
	}

	@Override
	public void action() {
		general.Movement.getInstance().setSpeed(3);
		general.Movement.getInstance().forward();
		Delay.msDelay(2000);
		general.Movement.getInstance().stop();
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	

}

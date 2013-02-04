package p6_slider;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import general.Calibration;
import general.Movement;
import general.SensorCache;

public class P6_PushButton implements Behavior {
	
	private NXTMotor motorA = new NXTMotor(MotorPort.A);
	private NXTMotor motorB = new NXTMotor(MotorPort.B);

	// set the interval. 
	
	// make sure he doesn't stall at the beginning
	
	private boolean back;
	private boolean front;
	
	@Override
	public boolean takeControl() {
		back = SensorCache.getInstance().backPressed;
		front = SensorCache.getInstance().bumperPressed;
		return ((front || back) && Calibration.slider && SensorCache.getInstance().normalizedLightValue < 250);
		
			}

	@Override
	public void action() {		
		
		if (front) {
			
			if (!back){
				Movement.getInstance().turn_left(90);
				Calibration.NumberOfTurns++;
			}
		} else {
			if (Calibration.NumberOfTurns >= 2) {
				general.Movement.getInstance().setTravelSpeed(300);
				//TODO reicht das so, auch wenn man am Schieber haegen bleibt?
				Calibration.slider = false;
				Movement.getInstance().travel(2000, true);
	
			}
		}
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	

}

package p8_colorbuttons;

import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class P8_FindColor implements Behavior{
	ColorButtons cb;
	Movement movement = Movement.getInstance();
	SensorCache sc;
	boolean suppressed;
	
	public P8_FindColor (ColorButtons cb) {
		this.cb = cb;
		this.sc = SensorCache.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		return cb.colorsSet;
	}

	@Override
	public void action() {
		
		LCD.clear();
		LCD.drawString("FindColor",1, 1);
		suppressed = false;
		// 0-green, 1-yellow, 2-red
		if (cb.requestedColor == 0)
			cb.blackLines = P8_Config.green;
		else if (cb.requestedColor == 1)
			cb.blackLines = P8_Config.yellow;
		else if (cb.requestedColor == 2)
			cb.blackLines = P8_Config.red;
		
		System.out.println(cb.blackLines+" "+cb.requestedColor);
		/////////
		boolean onBlack = false;
		movement.backward();
		while (!suppressed) {
			 if (SensorCache.getInstance().normalizedLightValue < P8_Config.lightBlackThreshold && !onBlack) {
				 onBlack = true;
				 cb.blackLines++;
				 LCD.clear();
				 LCD.drawString("I counted a black line "+cb.blackLines, 1, 1);
				 LCD.drawString(cb.blackLines+"", 1, 2);
				 movement.stop();
				 LCD.clear();
				 movement.backward();
			 }
			 else if (SensorCache.getInstance().normalizedLightValue > P8_Config.lightBlackThreshold+50 && onBlack) {
				 onBlack = false;
			 }
		}
		movement.stop();
	}

	@Override
	public void suppress() {
		suppressed= true;
	}

}

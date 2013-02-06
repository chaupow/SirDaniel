package p8_colorbuttons;

import java.util.Arrays;

import general.Movement;
import general.SensorCache;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class P8_DefineColors implements Behavior{
	Movement movement = Movement.getInstance();
	int [] colorArray = new int [190];
	boolean suppressed;
	ColorButtons cb;
	
	public P8_DefineColors(ColorButtons cb){
		this.cb = cb;
	}
	
	@Override
	public boolean takeControl() {
		return cb.defineColor < 3;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Define", 1, 1);
		movement.setTravelSpeed(80);
		LCD.clear();
		LCD.drawString("DefineColor", 1, 1);
		
		suppressed = false;
		movement.forward();
		
		int i = 0;
		Delay.msDelay(100);
		while (i < colorArray.length && !suppressed) {
			Delay.msDelay(1);
			colorArray[i] = SensorCache.getInstance().normalizedLightValue;
			i++;
		}
		movement.stop();
		Arrays.sort(colorArray);
		cb.average[cb.defineColor] = (int) ((colorArray[colorArray.length/2] 
									+colorArray[colorArray.length/2-1]
									+colorArray[colorArray.length/2+1])/(float)3.0);
		
		
		
		movement.forward();
		while (!suppressed) {
			Thread.yield();
		}
		cb.defineColor++;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}

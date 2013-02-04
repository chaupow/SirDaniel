package general;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class LineCounting implements Behavior {
	
	private final int THRESHOLD = 100;
	private final int TIME_FOR_SUFFIX = 2000;
	
	private int min = 1000;
	private int max = 0;
	private boolean rising = true;
	private int tempLineCount = 0;
	private int finalLineCount = 0;
	private long lastTimestamp = -1;

	@Override
	public boolean takeControl() {
		int currentValue = SensorCache.getInstance().normalizedLightValue;
		long currentTimestamp = SensorCache.getInstance().timestamp;
		
		if (rising) {
			if (currentValue > max) {
				max = currentValue;
			}
			if (currentValue < max) {
				rising = false;
				min = max;
				LCD.drawString("falling", 0 , 1);
				LCD.refresh();
			}
		} else {
			if (currentValue < min) {
				min = currentValue;
			}
			if (currentValue > min) {
				rising = true;
				LCD.drawString("dist:" + (max-min), 0 , 3);
				if (max-min > THRESHOLD) {
					lastTimestamp = currentTimestamp;
					tempLineCount++;
				}
				max = min;
				LCD.drawString("rising", 0 , 1);
				LCD.refresh();
			}
		}
		
		if (currentTimestamp - lastTimestamp > TIME_FOR_SUFFIX) {
			finalLineCount = tempLineCount;
			tempLineCount = 0;
		}
		
		LCD.drawString("temp#:" + tempLineCount, 0 , 0);
		LCD.refresh();
		
		return finalLineCount >= 3;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		Delay.msDelay(2000);
		finalLineCount = 0;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	
}
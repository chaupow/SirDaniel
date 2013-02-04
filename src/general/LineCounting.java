package general;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class LineCounting implements Behavior {
	
	private final int THRESHOLD = 300;
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
			}
		} else {
			if (currentValue < min) {
				min = currentValue;
			}
			if (currentValue > min) {
				rising = true;
				if (max-min > THRESHOLD) {
					lastTimestamp = currentTimestamp;
					tempLineCount++;
				}
				max = min;
			}
		}
		
		if (currentTimestamp - lastTimestamp > TIME_FOR_SUFFIX) {
			finalLineCount = tempLineCount;
			tempLineCount = 0;
		}
		return finalLineCount >= 3;
	}

	@Override
	public void action() {
		System.out.println("Lines found: "+finalLineCount);
		
		if (finalLineCount == 3) {
			
		} else if (finalLineCount == 4) {
			// setup
			// call
		} else if (finalLineCount == 5) {
			// setup
			// call
		} else if (finalLineCount == 6) {
			// setup
			// call
		} else if (finalLineCount == 7) {
			// setup
			// call
		} else if (finalLineCount == 8) {
			// setup
			// call
		} else if (finalLineCount == 9) {
			// setup
			// call
		} else if (finalLineCount == 10) {
			// setup
			// call
		} else if (finalLineCount == 11) {
			// setup
			// call
		} else if (finalLineCount == 12) {
			// setup
			// call
		} else {
			System.out.println("This shouldn't happen.");
		}
		
		// reset line count after calling the actions.
		finalLineCount = 0;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	
}
package general;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class LineCounting implements Behavior {
	
	private final int THRESHOLD = 100;
	private final int TIME_FOR_SUFFIX = 1000;
	
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
					LCD.drawString("Temp: " + tempLineCount, 0, 4);
				}
				max = min;
			}
		}
		
		if (currentTimestamp - lastTimestamp > TIME_FOR_SUFFIX) {
			finalLineCount = tempLineCount;
			tempLineCount = 0;
			LCD.drawString("Final: " + finalLineCount, 0, 5);
		}
		return (finalLineCount >= 3);
	}

	@Override
	public void action() {
		
		LCD.drawString("Lines: " + finalLineCount, 0, 1);
		Button.waitForAnyPress();
		
		if (finalLineCount == 3) {
			//Bluetoothtor
		} else if (finalLineCount == 4) {
			// setup
			SuperMotor.turnTo(0, false);
			// call
		} else if (finalLineCount == 5) {
			// Bridge
			// setup
			SuperMotor.turnTo(180, false);
			// call
		} else if (finalLineCount == 6) {
			//Haengebruecke einfacher LineFollow
			// setup
			// call
		} else if (finalLineCount == 7) {
			// setup Labyrinth
			SuperMotor.turnTo(0, false);
			// call
		} else if (finalLineCount == 8) {
			// setup Farbenlesen
			// call
		} else if (finalLineCount == 9) {
			// setup LineFollow mit allem
			// call
		} else if (finalLineCount == 10) {
			// setup wippe
			Calibration.rocker = true;
			// call
		} else if (finalLineCount == 11) {
			// setup drehteller
			// call
		} else if (finalLineCount == 12) {
			// setup rollen/slider
			SuperMotor.turnTo(0, false);
			// call
		} else if (finalLineCount == 13) {
			// setup start 
			/*warte bis button gedrückt wurde, zähle bis zehn, starte Rennen*/
			Delay.msDelay(10000);
			// call
		} else if (finalLineCount == 14) {
			// setup Endboss!
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
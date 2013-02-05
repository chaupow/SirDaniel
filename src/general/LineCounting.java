package general;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class LineCounting implements Behavior {
	
	private boolean suppressed = false;
	
	private final int THRESHOLD = 100;
	private final int TIME_FOR_SUFFIX = 1000;
	
	private int min = 1000;
	private int max = 1000;
	private boolean rising = false;
	private int tempLineCount = 0;
	private int finalLineCount = 0;
	private long lastTimestamp = -1;
	private LightSensor light; 
	private int currentValue = 0;
	private long currentTimestamp = 0;
	
	public LineCounting(){
		light = SensorCache.getInstance().light;
	}

	@Override
	public boolean takeControl() {
		
		/*currentValue = cache.normalizedLightValue;
		currentTimestamp = cache.timestamp;
		
		if (rising) {
			if (currentValue >= max) {
				max = currentValue;
			} else {
				rising = false;
				min = max;
			}			
		} else {
			if (currentValue <= min) {
				min = currentValue;
			} else {
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
	return (finalLineCount >= 3);*/
		return (Calibration.readCode && light.getNormalizedLightValue() > 300);
	
	}

	@Override
	public void action() {
		
		LCD.drawString("Lines: " + finalLineCount, 0, 1);
		Button.waitForAnyPress();
		
		Movement.getInstance().forward();	
		
		while (! suppressed) {
			currentValue = light.getNormalizedLightValue();
			currentTimestamp = SensorCache.getInstance().timestamp;
			if (rising && !suppressed) {
				if (currentValue >= max) {
					max = currentValue;
				} else {
					rising = false;
					min = max;
				}			
			} else {
				if (currentValue <= min && !suppressed) {
					min = currentValue;
				} else {
					rising = true;
					if (max-min > THRESHOLD) {
						lastTimestamp = currentTimestamp;
						tempLineCount++;
					}
					max = min;
				}
			}
			
			if (!suppressed && currentTimestamp - lastTimestamp > TIME_FOR_SUFFIX) {
				finalLineCount = tempLineCount;
				tempLineCount = 0;
				suppress();

			}
		}
		
		Movement.getInstance().stop();
		
		switch(finalLineCount){
		
		case 3: //bluetooth tor
				break;
		case 4: //sumpf
				break;
		case 5:	Calibration.bridge = true; //TODO Aendern, iwie noch anderes flag weil Bridge DriveRLeftArc das flag erst true setzt
				break;
		case 6:	//haengebruecke 
				break;
		case 7:	Calibration.labyrinth = true;
				break;
		case 8: //Farben
				break;
		case 9: //Linienfolger mit allem
				break;
		case 10: Calibration.rocker = true;
				break;
		case 11: //Drehteller
				break;
		case 12: Calibration.slider = true;
				break;
		case 13: //start
				break;
		case 14: //Endgegner
				Calibration.readCode = false;
				break;
		}
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		suppressed = true;
		
	}
	
	
}
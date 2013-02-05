package general;

import lejos.nxt.Button;

public class BarcodeReader implements Runnable {
	
	private int TIME_FOR_SUFFIX = 500;
	private int THRESHOLD = 100;
	
	@Override
	public void run() {
	
		System.out.println("Looking for Barcodes.");
		
		// always look for barcodes
		while(true) {
			
			boolean rising = true;
			int min = 1000;
			int max = 0;
			
			int currentValue;
			long currentTimestamp = System.currentTimeMillis();
			long lastTimestamp = System.currentTimeMillis();
			int lineCount = 0;

			while (currentTimestamp - lastTimestamp < TIME_FOR_SUFFIX) {
				
				// TODO use getLightValue() instead?
				currentValue = SensorCache.getInstance().light.getNormalizedLightValue();
				currentTimestamp = System.currentTimeMillis();
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
						//System.out.println("T:" + (max-min));
						if (max-min > THRESHOLD) {
							lastTimestamp = currentTimestamp;
							lineCount++;
						}
						max = min;
					}
				}		
			}
			
			if (lineCount >= 3) {
				startBehavior(lineCount);
			}
		}
	}
		
	
	private void startBehavior(int number) {
		// TODO do cool stuff here
		System.out.println("Called Behavior: " + number);
		//general.Settings.initRace();
		//general.Settings.race = true;
		Button.waitForAnyPress();
		general.Settings.initLabyrinth();
		general.Settings.labyrinth = true;
		
	}

}

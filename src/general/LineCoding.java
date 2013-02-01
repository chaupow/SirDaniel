package general;
import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class LineCoding implements Behavior {
	private LightSensor light = new LightSensor(SensorPort.S4);
	
	/* delay depends on the current speed of the robot. */
	// TODO check speed
	private int delay = (int)(Calibration.stripeWidth / (0.30));
	
	/* remember the time of the last measurement. */
	private long lastTime = System.currentTimeMillis();
	
	private int lineCounter = 0;
	private boolean foundLineLastTime = false;
	

	@Override
	public boolean takeControl() {
		long timePassed = System.currentTimeMillis() - lastTime;
		if( timePassed > delay) {
			int currentLightValue = light.getLightValue();
			LCD.drawString("curLigth: ", 0, 2);
			LCD.drawInt(currentLightValue, 10, 2);
		
			int distanceBlack = Math.abs(Calibration.backgroundBrightness-currentLightValue);
			int distanceWhite = Math.abs(Calibration.lineBrightness-currentLightValue);
			
			/* check whether the current measurement is black or white. */
			boolean lineFound;
			if (distanceBlack <= distanceWhite) {
				lineFound = false;
			} else {
				lineFound = true;
			}
			
			LCD.drawString("curDet: ", 0, 3);
			LCD.drawString(new Boolean(lineFound).toString(), 10, 3);
			LCD.drawString("lastDet: ", 0, 4);
			LCD.drawString(new Boolean(foundLineLastTime).toString(), 10, 4);
			
			/* if alternating measurements occurred increase light counter. */
			if (lineFound != foundLineLastTime) {
				lineCounter++;
			} else {
				lineCounter = 0;
			}
			foundLineLastTime = lineFound;
			
			LCD.refresh();
			lastTime = System.currentTimeMillis();
		}
		return true;
	}

	@Override
	public void action() {
		this.printDebug();
		// TODO call next level.
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	private void printDebug() {
		LCD.drawString("lines: ", 0, 0);
		LCD.drawInt(lineCounter, 7, 0);
		LCD.drawString("----------------", 0, 1);
		LCD.refresh();
	}
}
import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

import java.util.Vector;

public class FindSliderFrequency implements Behavior {
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);
	private Vector<Integer> observations = new Vector<Integer>();
	
	private int sampleFrequency = 4;
	private int sampleForSeconds = 10;
	private int numberOfSamples = sampleFrequency * sampleForSeconds;
	private float calculatedFrequency;
	

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		while(observations.size() < numberOfSamples) {
			observations.addElement(sonar.getDistance());
			this.printDebug("sampling...");
			Delay.msDelay(1000/sampleFrequency);
		}
		
		int min = 255;
		int max = 0;
		for (int i = 0; i < observations.size(); i++) {
			if (observations.elementAt(i) < min) {
				min = observations.elementAt(i);
			}
			if (observations.elementAt(i) > max) {
				max = observations.elementAt(i);
			}
		}
		
		int mean = (min + max) / 2;
		int counter = 0;
		for (int i = 0; i < observations.size(); i++) {
			if (observations.elementAt(i) < mean) {
				counter = counter + 1;
			}
		}
		calculatedFrequency = ((float) numberOfSamples / (float)counter) / (float)sampleFrequency;
		this.printDebug("finished.");
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	private void printDebug(String action) {
		LCD.drawString("freq: ", 0, 0);
		LCD.drawString(String.valueOf(calculatedFrequency), 7, 0);
		LCD.drawString("#: ", 0, 1);
		LCD.drawInt(observations.size(), 7, 1);
		LCD.drawString(getLastObservations(5), 0, 2);
		LCD.drawString(action, 0, 3);
		LCD.refresh();
	}
	
	private String getLastObservations(int amount) {
		int iteratorStart = observations.size() - amount;
		String result = "";
		if (iteratorStart < 0 ) {
			iteratorStart = 0;
		}
		for (int i = iteratorStart; i < observations.size(); i++) {
			result += observations.elementAt(i);
			result += " ";
		}
		return result;
	}
}

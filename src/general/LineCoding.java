package general;

import java.util.Vector;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class LineCoding implements Behavior {	
	private Vector<Integer> values = new Vector<Integer>();
	private int lines = 0;

	
	@Override
	public boolean takeControl() {
		values.addElement(SensorCache.getInstance().normalizedLightValue);
		
		Vector<Integer> filtered = new Vector<Integer>(values.size());
		
		// first element
		filtered.addElement(0);
		
		for (int i = 1; i < (values.size()-1); i++) {
			int calculatedValue = (values.elementAt(i-1) - 2*(values.elementAt(i)) + values.elementAt(i+1));
			filtered.addElement(calculatedValue);
		}
		
		// second element
		filtered.addElement(0);
		
		// find lines
		int counter = 0;
		int lastDetection = filtered.size();
		
		for (int i = (filtered.size()-1); i > 0 ; i--) {
			int distance = Math.abs(filtered.elementAt(i)-filtered.elementAt(i-1));
			if (distance > Calibration.THRESHOLD) {
				lastDetection = i;
				counter = counter + 1;
			}
		}
		LCD.drawString("Counter: ", 0, 0);
		LCD.drawInt(counter, 10, 0);
		LCD.refresh();
		
		int numberOfLines = -1;
		if (!(lastDetection < filtered.size() - Calibration.SUFFIX_BLACK)) {
			numberOfLines = counter / 2;
		}
		
		LCD.drawString("Lines: ", 0, 1);
		LCD.drawInt(numberOfLines, 10, 1);
		LCD.refresh();
		
		boolean act = false;
		if (numberOfLines >= 1) {
			act = true;
			values.clear();
		}
		
		// clean up
		counter = 0;
		return act;
	}

	@Override
	public void action() {
		System.out.println("Lines: " + lines);
		lines = 0;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
}
package general;

import java.util.LinkedList;
import java.util.Vector;

import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class LineCoding implements Behavior {
	
	private final int THRESHOLD = 200;
	private final int COMPARE_VALUES = 5;
	
	private long deltaTime = -1;
	private int lineCount = -1;
	
	private Vector<Long> flanks = new Vector<Long>();
	private LinkedList<Integer> values = new LinkedList<Integer>();

	@Override
	public boolean takeControl() {
		
		// get the light value
		int currentValue = SensorCache.getInstance().normalizedLightValue;
		if (values.size() >= COMPARE_VALUES) {
			values.remove(0);
		}
		values.add(currentValue);
		long currentTimestamp = SensorCache.getInstance().timestamp;

		boolean foundFlank = isFlank();
		
		// add to list of flanks
		if (foundFlank && flanks.isEmpty()) {
			flanks.addElement(currentTimestamp);
			lineCount = 0;
		} else if (foundFlank && (flanks.size() == 1)) {
			flanks.addElement(currentTimestamp);
			deltaTime = currentTimestamp - flanks.elementAt(0);
		} else if (foundFlank && (flanks.size() > 1)) {
			long currentDelta = currentTimestamp-flanks.elementAt(flanks.size()-1);
			if (isValid(currentDelta)) {
				flanks.addElement(currentTimestamp);
			}
		}
		
		if (flanks.size() >= 2 && currentTimestamp - (flanks.elementAt(flanks.size()-1)) > 3 * deltaTime) {
			lineCount = flanks.size() / 2;
			if (flanks.size() % 2 == 0) {
				flanks.clear();
			} else {
				//TODO lšschen des letzten Elements.
				for (int i = 0; i < flanks.size()-1; i++) {
					flanks.removeElementAt(0);
				}
			}
		}
		
		LCD.drawString("delta " + deltaTime, 0, 0);
		LCD.drawString("flanks " + flanks.size(), 0, 1);
		LCD.drawString("light.val " + currentValue, 0, 2);
		if (flanks.size() >= 2) {
			LCD.drawString("cur delta " + (currentTimestamp - (flanks.elementAt(flanks.size()-1))), 0, 3);
		} else {
			LCD.drawString("Not enough flanks.", 0, 3);
		}
		LCD.drawString(printValues(), 0, 4);
		
		
		return (lineCount >= 3);
	}

	@Override
	public void action() {
		System.out.println("Line detected.");
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
	private String printValues() {
		String result = "";
		for (int i = 0; i < values.size(); i++) {
			result += values.get(i);
			result += " ";
		}
		return result;
	}
	
	private boolean isValid(long currentDelta) {
		long bounds = deltaTime / 2;
		return (currentDelta < deltaTime + bounds && currentDelta > deltaTime - bounds);
	}
	
	private boolean isFlank() {
		boolean isFlank = false;
		
		if (!values.isEmpty()) {
			int min = 1000;
			int minPos = 0;
			int max = 0;
			int maxPos = 0;
			
			for (int i = 0; i < values.size(); i++) {
				if (values.get(i) <= min) {
					min = values.get(i);
					minPos = i;
				}
				if (values.get(i) >= max) {
					max = values.get(i);
					maxPos = i;
				}
			}
			int distance = Math.abs(max - min);
			
			if (distance > THRESHOLD) {
				isFlank = true;
				for (int i = 0; i < Math.max(minPos, maxPos); i++) {
					values.remove(0);
				}
			}
		}
		return isFlank;
	}
	
	
	
}
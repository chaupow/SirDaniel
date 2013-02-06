package p8_colorbuttons;

import java.util.Arrays;

import general.Movement;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Behavior;

public class P8_SetColors implements Behavior{
	ColorButtons cb;
	
	public P8_SetColors (ColorButtons cb) {
		this.cb = cb;
	} 

	@Override
	public boolean takeControl() {
		return cb.defineColor == 3 && !cb.colorsSet;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Set COlor", 1, 1);
		Movement.getInstance().stop();
		P8_Config.green = 0;
		P8_Config.red = 0;
		P8_Config.yellow = 0;
		for (int k = 0; k < 3; k++) {
			if (cb.average[k] < cb.average[P8_Config.green])
				P8_Config.green = k;
			if (cb.average[k] > cb.average[P8_Config.yellow])
				P8_Config.yellow = k;
		}
		for (int j = 0; j < 3; j++) {
			if (j != P8_Config.green && j != P8_Config.yellow)
				P8_Config.red = j;
		}
		LCD.clear();
		LCD.drawString("green:"+P8_Config.green+cb.average[P8_Config.green], 1, 1);
		LCD.drawString("yellow:"+P8_Config.yellow+cb.average[P8_Config.yellow], 1, 2);
		LCD.drawString("red:"+P8_Config.red+cb.average[P8_Config.red], 1, 3);
		
		cb.colorsSet = true;
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}

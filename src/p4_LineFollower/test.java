package p4_LineFollower;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.util.Delay;
import general.SensorCache;
import general.SuperMotor;

public class test {
	public static void main(String [] args) {
		while(true) {
			Delay.msDelay(500);
			LCD.drawString(""+(new LightSensor(SensorPort.S4)).getNormalizedLightValue(), 1, 2);
			LCD.refresh();
		}
		
	
	}
}

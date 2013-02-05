import general.Movement;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;


public class LightTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LightSensor light = new LightSensor(SensorPort.S4);
//		
//		while (true) {
//			
//			LCD.drawInt(light.getNormalizedLightValue(), 1, 1);
//			LCD.refresh();
//		}
		
		Button.waitForAnyPress();
		 
		Movement m = Movement.getInstance();
//		m.setTravelSpeed(180);
//		m.forward();
//		Delay.msDelay(1000);
//		LCD.drawString("" + m.getVelocity(), 0, 0);
//		m.stop();
//		
		m.setTravelSpeed(360);
//		m.forward();
//		Delay.msDelay(1000);
//		LCD.drawString("" + m.getVelocity(), 0, 1);
//		m.setTravelSpeed(720);
//		m.stop();
//
//		m.forward();
//		Delay.msDelay(1000);
//		LCD.drawString("" + m.getVelocity(), 0, 2);
//		m.setTravelSpeed(1080);
//
//		m.forward();
//		Delay.msDelay(1000);
//		LCD.drawString("" + m.getVelocity(), 0, 3);
//		m.stop();
		
		
			/* sonicValues should contain the last max_Values sonic values
			 * [0] should be the newest value, [max_Values - 1] should be the oldest
			 * value.
			 * How often do the values get recorded? 100 per s? => valuesPerSecond
			 * How many meters equal 1 unit of sonic value? 0.01 m/s? => metersPerUnit
			 */
			/* between two values, we can calculate the difference in sonic units*/
			int valueDifference;
			/* From the difference we can calculate the velocity relative to the 
			 * object in front of us 
			 */
			float velocity;
			/* then we calculate the average over the last max_Values entries to minimize
			 * measurement errors.
			 */
			int max_Values = 10;
			float metersPerUnit = 0.01f;
			float valuesPerSecond = 13.3f;
			UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
			int[] sonicValues = new int[max_Values];
			float averageVelocity = 0;
			int j = 0;
			m.forward();
			
			while (j < 10) {
			
			sonic.getDistances(sonicValues, 0, max_Values);
			valueDifference = sonicValues[0] - sonicValues[1]; 
			/* metersPerUnit and valuesPerSecond need to be defined either 
			 * locally or globally. Might be useful in other classes as well. 
			 */
			velocity = valueDifference * metersPerUnit / valuesPerSecond;
			averageVelocity = velocity;
			
			for (int i = 1; i < max_Values - 1; i++) {
				/* sonicValues will be filled with maxValues sonic values */
				sonic.getDistances(sonicValues, 0, max_Values);
				valueDifference = sonicValues[i] - sonicValues[i + 1]; 
				/* metersPerUnit and valuesPerSecond need to be defined either 
				 * locally or globally. Might be useful in other classes as well. 
				 */
				velocity = valueDifference * metersPerUnit / valuesPerSecond;
				averageVelocity = (averageVelocity + velocity) / 2;
			}
			
			LCD.drawString("" + (m.getVelocity() - averageVelocity), 0, j);
			j++;
	}
		Button.waitForAnyPress();
	}

}

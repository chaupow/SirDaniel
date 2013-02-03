import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;


public class LightTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightSensor light = new LightSensor(SensorPort.S4);
		
		while (true) {
			
			LCD.drawInt(light.getNormalizedLightValue(), 1, 1);
			LCD.refresh();
		}

	}

}

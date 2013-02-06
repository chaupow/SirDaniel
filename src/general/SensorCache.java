package general;

import lejos.nxt.TouchSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class SensorCache {

	private static SensorCache instance = null;

	public static SensorCache getInstance() {
		if(instance == null) {
			instance = new SensorCache();
		}
		return instance;
	}
	
	//Singleton!
	private SensorCache() {
		//light.setFloodlight(true);
		pollSensors();
	}
	
	public TouchSensor bumper = new TouchSensor(SensorPort.S2);
	public TouchSensor back = new TouchSensor(SensorPort.S1);
	public LightSensor light = new LightSensor(SensorPort.S4);
	
	
	public int normalizedLightValue;
	public int lightValue;
	public boolean bumperPressed;
	public boolean backPressed;
	public long timestamp;
	
	public void pollSensors() {
		
		timestamp = System.currentTimeMillis();
		lightValue = light.getLightValue();
		normalizedLightValue = light.getNormalizedLightValue();
		bumperPressed = bumper.isPressed();
		backPressed = back.isPressed();
	}
	
	

}

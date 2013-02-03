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
	
	private TouchSensor bumper = new TouchSensor(SensorPort.S2);
	private TouchSensor bridge = new TouchSensor(SensorPort.S1);
	private LightSensor light = new LightSensor(SensorPort.S4);
	
	public int normalizedLightValue;
	public boolean bumperPressed;
	public boolean bridgePressed;
	
	public void pollSensors() {
		normalizedLightValue = light.getNormalizedLightValue();
		bumperPressed = bumper.isPressed();
		bridgePressed = bridge.isPressed();
	}
	
	

}

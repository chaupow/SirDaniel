import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3SearchLineAtStart implements Behavior{
	LightSensor light;
	
	public P3SearchLineAtStart(LightSensor light) {
		this.light = light;
	}
	
	@Override
	public boolean takeControl() {
		return !P3.foundLineForFirstTime && !P3.stop && !P3.end;
	}

	@Override
	public void action() {
		LCD.clear();
		LCD.drawString("Searching a Line at the beginning", 1, 1);
		Movement.forward(2);
		while(!P3.foundLineForFirstTime) {
			if (light.getNormalizedLightValue() >= P3.threshold){
				P3.foundLineForFirstTime = true;
			}
		}
		Movement.turn_right(100);
	}

	@Override
	public void suppress() {
		P3.foundLineForFirstTime = true;
	}

}

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.Behavior;


public class P3_SearchLineAtStart implements Behavior{
	LightSensor light;
	Movement movement;
	
	public P3_SearchLineAtStart(LightSensor light) {
		this.movement = Movement.getInstance();
		this.light = light;
	}
	
	@Override
	public boolean takeControl() {
		return !P3.foundLineForFirstTime && !P3.end;
	}

	@Override
	public void action() {
		//TODO LCD raus
		LCD.clear();
		LCD.drawString("Searching a Line ", 1,1);
		LCD.drawString("at the beginning", 1, 2);
		
		movement.setSpeed(2);
		movement.forward();
		while(!P3.foundLineForFirstTime) {
			if (light.getNormalizedLightValue() >= P3.threshold){
				P3.foundLineForFirstTime = true;
			}
		}
		movement.turn_right(100);
	}

	@Override
	public void suppress() {
		P3.foundLineForFirstTime = true;
	}

}

package p6_slider;
import p8_Line.P8_Line;
import general.ClaudisMain;
import general.SensorCache;
import general.Settings;
import lejos.robotics.subsumption.Behavior;

public class P6_EndSlider implements Behavior {

	@Override
	public boolean takeControl() {
		return (SensorCache.getInstance().normalizedLightValue > Settings.LIGHT_THRESHOLD && Config.NumberOfTurns >= 2);
	}

	@Override
	public void action() {
		System.out.println("Slider Ende");
		P6.getInstance().stop();
		P8_Line.getInstance().start(1);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}
	
}

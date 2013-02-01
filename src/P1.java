import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P1 {
	
   public static void main(String [] args) {
	   
	   Behavior p1 = new P1_Behavior();
	   Behavior [] b = {p1};
	   Arbitrator arby = new Arbitrator(b, true);
	   
	   Button.waitForAnyPress();
	   arby.start();
   }


}

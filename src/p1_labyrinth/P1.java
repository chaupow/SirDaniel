package p1_labyrinth;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import general.SirDanielArbitrator;

public class P1 {
	
   public static void main(String [] args) {
	   
	   Behavior p1 = new P1_Behavior();
	   Behavior [] b = {p1};
	   SirDanielArbitrator arby = new SirDanielArbitrator(b, true);
	   
	   Thread t = new Thread(arby);
	   Button.waitForAnyPress();
	   t.start();
   }


}

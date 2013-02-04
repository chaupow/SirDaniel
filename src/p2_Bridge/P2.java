package p2_Bridge;
import general.Calibration;
import general.SirDanielArbitrator;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P2 {
	
   public static void main(String [] args) {
	   
	  
	   // constant values
	   Behavior driveRight = new P2_DriveRight();
	   Behavior avoidAbyss = new P2_AvoidAbyss();
	   
	   Behavior [] b = {driveRight, avoidAbyss};
	   SirDanielArbitrator arby = new SirDanielArbitrator(b);
	   
	   Thread t = new Thread(arby);
	   Button.waitForAnyPress();
	   t.start();
	   Button.waitForAnyPress();
   }


}

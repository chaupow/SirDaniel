package p2_Bridge;
import general.DriveForward;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P2 {
	
   public static void main(String [] args) {
	   
	  
	   // constant values
	 
	   Behavior driveRight = new P2_DriveRight();
	   Behavior avoidAbyss = new P2_AvoidAbyss();
	   
	   Behavior [] b = {driveRight, avoidAbyss};
	   Arbitrator arby = new Arbitrator(b);
	   
	   Button.waitForAnyPress();
	   arby.start();
	   Button.waitForAnyPress();
   }


}

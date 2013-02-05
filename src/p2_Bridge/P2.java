package p2_Bridge;
import general.Calibration;
import general.Settings;
import general.SirDanielArbitrator;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class P2 {
	
	SirDanielArbitrator arby;
	
//   public static void main(String [] args) {
	public void start() {   
//	  Settings.bridge = true;
//	  Calibration.bridge = true;
	   // constant values
	   Behavior driveLeft = new P2_DriveLeft();
	   Behavior avoidAbyss = new P2_AvoidAbyss();
	   Behavior endOfBridge = new P2_EndOfBridge();
	   
	   Behavior [] b = {driveLeft, avoidAbyss, endOfBridge};
	   arby = new SirDanielArbitrator(b, true);
	   
	   Thread t = new Thread(arby);
//	   Button.waitForAnyPress();
	   System.out.println("Bridge started");
	   t.start();
   }
	
	public void stop() {
		arby.stop();
	}


}

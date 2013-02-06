package p2_Bridge;
import general.Calibration;
import general.Movement;
import general.Settings;
import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;


public class P2 {
	
	SirDanielArbitrator arby;
	Movement movement = Movement.getInstance();
	
	public void start() {   
//	  Settings.bridge = true;
//	  Calibration.bridge = true;
		SuperMotor.turnTo(180, true);
		movement.travel(200);
		movement.turn_right(70);
		movement.travel(150);
		movement.setTravelSpeed(200);
		
	   // constant values
	   Behavior driveLeft = new P2_DriveLeft();
	   Behavior avoidAbyss = new P2_AvoidAbyss();
	   Behavior endOfBridge = new P2_EndBridge();
	   
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

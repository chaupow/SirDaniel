package p2_Bridge;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.*;
import general.Calibration;
import general.ClaudisMain;
import general.Movement;
import general.SensorCache;
import general.Settings;

public class P2_EndOfBridge implements Behavior{

	   private boolean suppressed = false;
	  
	   
	   public boolean takeControl() {
		   return (SensorCache.getInstance().normalizedLightValue > 400);
	   }

	   public void suppress() {
	      suppressed = true;
	   }

	   public void action() {
		   System.out.println("Bridge Ende");
		   ClaudisMain.searchBarcode();
	   }
	
}

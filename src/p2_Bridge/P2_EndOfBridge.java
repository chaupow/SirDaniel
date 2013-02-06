package p2_Bridge;

import lejos.robotics.subsumption.*;
import general.ClaudisMain;
import general.SensorCache;

public class P2_EndOfBridge implements Behavior{

	   private boolean suppressed = false;
	   
	   public boolean takeControl() {
		   return (SensorCache.getInstance().lightValue > 90);
	   }

	   public void suppress() {
	      suppressed = true;
	   }

	   public void action() {
		   System.out.println("Bridge Ende");
		   ClaudisMain.searchBarcode();
	   }
	
}

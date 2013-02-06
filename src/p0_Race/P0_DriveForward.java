package p0_Race;

import lejos.robotics.subsumption.Behavior;
import general.Movement;

public class P0_DriveForward implements Behavior {
	   private boolean suppressed = false;
	   
	   public P0_DriveForward(int speed){
		 Movement.getInstance().setSpeed(speed);

	   }
	   
	   public boolean takeControl() {
	      return true;
	   }

	   public void suppress() {
	      suppressed = true;
	   }

	   public void action() {
	     suppressed = false;
	     Movement.getInstance().forward();
	     while( !suppressed ) {
	    	 Thread.yield();
	     }
	     
	   }

}

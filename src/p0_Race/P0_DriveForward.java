package p0_Race;

import lejos.robotics.subsumption.Behavior;
import general.Movement;

public class P0_DriveForward implements Behavior {
	   private boolean suppressed = false;
	   private int speed;
		Movement movement = Movement.getInstance();
	   
	   public P0_DriveForward(int speed){
		   this.speed = speed;
		   
	   }
	   
	   public boolean takeControl() {
	      return true;
	   }

	   public void suppress() {
	      suppressed = true;
	   }

	   public void action() {
	     suppressed = false;
	     movement.setSpeed(speed);
	     movement.forward();
	     while( !suppressed ) {
	    	 Thread.yield();
	     }
	     
	   }

}

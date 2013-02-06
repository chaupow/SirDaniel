package p8_colorbuttons;

import general.Movement;
import lejos.robotics.subsumption.*;

public class Lab_DriveForward  implements Behavior {
   private boolean suppressed = false;
	Movement movement = Movement.getInstance();
	ColorButtons cb;
   
   public Lab_DriveForward(double speed, ColorButtons cb){
	   Movement.getInstance().setTravelSpeed(speed);
	   this.cb = cb;
   }
   
   public boolean takeControl() {
      return (cb.lab);
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     movement.forward();
     while( !suppressed ) {
    	 Thread.yield();
     }
     
   }
}
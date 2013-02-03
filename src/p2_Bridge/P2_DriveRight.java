package p2_Bridge;
import lejos.robotics.subsumption.*;
import general.Movement;

public class P2_DriveRight implements Behavior {
   private boolean suppressed = false;
  
   Movement movement = Movement.getInstance();
   
   public boolean takeControl() {
      return !movement.isMoving();
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     while(!suppressed) {
    	 if (!movement.isMoving()) {
    		 movement.steer(-30, -60, true);
    	 }
//	 
//		 movement.forward();
//		 Thread.yield();
//    	 movement.setSpeed(speed);
//    	 movement.setRotationSpeed(rotationSpeed);
//	     movement.forward();
//	     
//	     if (!suppressed) Delay.msDelay(100);
//	     if (!suppressed) movement.turn_right(angle);
     }    
     movement.stop();
   }
}
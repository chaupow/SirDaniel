package general;
import lejos.robotics.subsumption.*;

public class DriveForward  implements Behavior {
   private boolean suppressed = false;
   private int speed;
	Movement movement = Movement.getInstance();
   
   public DriveForward(int speed){
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
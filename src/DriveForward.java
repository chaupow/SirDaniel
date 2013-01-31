import lejos.nxt.LCD;
import lejos.robotics.subsumption.*;

public class DriveForward  implements Behavior {
   private boolean suppressed = false;
   private int speed;
	Movement movement = new Movement();
   
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
     movement.forward(speed);
     while( !suppressed ) {
    	 Thread.yield();
     }
     movement.stop(); // clean up
     
   }
}
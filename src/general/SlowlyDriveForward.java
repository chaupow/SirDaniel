package general;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.*;

public class SlowlyDriveForward  implements Behavior {
   private boolean suppressed = false;
   private int speed;
	Movement movement = Movement.getInstance();
   
   public boolean takeControl() {
      return true;
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     Motor.A.setSpeed(50);
     Motor.B.setSpeed(50);
     Movement.getInstance().forward();
     while( !suppressed ) {
    	 Thread.yield();
     }
     Motor.A.stop(); // clean up
     Motor.B.stop(); // clean up
     
   }
}
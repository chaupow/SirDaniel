package general;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.*;

public class SlowlyDriveForward  implements Behavior {
   private boolean suppressed = false;
   Movement movement = Movement.getInstance();
   
   public boolean takeControl() {
      return true;
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     Movement.getInstance().setTravelSpeed(25);
     Movement.getInstance().forward();
     while( !suppressed ) {
    	 Thread.yield();
     }
     Motor.A.stop(); // clean up
     Motor.B.stop(); // clean up
     
   }
}
import lejos.nxt.LCD;
import lejos.robotics.subsumption.*;

public class DriveForward  implements Behavior {
   private boolean suppressed = false;
   private int speed;
   
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
     Movement.forward(speed);
     //TODO
     LCD.clear();
     LCD.drawString("Driving forward", 0, 0);
     while( !suppressed ) {
    	 Thread.yield();
     }
     Movement.stop(); // clean up
     
   }
}
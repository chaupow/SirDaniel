package p1_labyrinth;
import general.Calibration;
import general.Movement;
import lejos.robotics.subsumption.*;

public class P1_DriveForward  implements Behavior {
   private boolean suppressed = false;
   private int speed;
	Movement movement = Movement.getInstance();
   
   public P1_DriveForward(int speed){
	   this.speed = speed;
	   
   }
   
   public boolean takeControl() {
      return (Calibration.labyrinth);
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
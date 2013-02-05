package p1_labyrinth;
import general.Movement;
import general.Settings;
import lejos.robotics.subsumption.*;

public class P1_DriveForward  implements Behavior {
   private boolean suppressed = false;
	Movement movement = Movement.getInstance();
   
   public P1_DriveForward(double speed){
	   Movement.getInstance().setTravelSpeed(speed);
   }
   
   public boolean takeControl() {
      return (true);
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
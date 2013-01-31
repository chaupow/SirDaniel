import lejos.nxt.LCD;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class P2_DriveRight implements Behavior {
   private boolean suppressed = false;
   private int speed;
   private int angle;
   private int rotationSpeed;
   
   public P2_DriveRight(int speed, int rotationSpeed, int angle){
	   this.speed = speed;
	   this.angle = angle;
	   this.rotationSpeed = rotationSpeed;
   }
   
   public boolean takeControl() {
      return true;
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     while( !suppressed ) {
	     Movement.forward(speed);
	     if (!suppressed) Delay.msDelay(100);
	     if (!suppressed) Movement.turn_right(angle, rotationSpeed);
     }     
   }
}
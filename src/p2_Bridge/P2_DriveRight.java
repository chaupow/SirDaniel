package p2_Bridge;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;
import general.Movement;

public class P2_DriveRight implements Behavior {
   private boolean suppressed = false;
   private int speed;
   private int angle;
   private int rotationSpeed;
   Movement movement = Movement.getInstance();
   TouchSensor touch;
   
   public P2_DriveRight(int speed, int rotationSpeed, int angle, TouchSensor touch){
	   this.speed = speed;
	   this.angle = angle;
	   this.rotationSpeed = rotationSpeed;
	   this.touch = touch;
   }
   
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
    		 movement.steer(-30, -30, true);
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
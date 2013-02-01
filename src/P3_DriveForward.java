import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.subsumption.*;

public class P3_DriveForward  implements Behavior {
   private boolean suppressed = false;
   private int speed;
   LightSensor light;
   Movement movement;
   
   public P3_DriveForward(int speed, LightSensor light, Movement movement) {
		this.movement = movement;
	   this.speed = speed;
	   this.light = light;
   }
   
   public boolean takeControl() {
      return light.getNormalizedLightValue() < P3_Behavior.threshold;
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
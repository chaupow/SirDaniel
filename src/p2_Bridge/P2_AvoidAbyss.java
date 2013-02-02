package p2_Bridge;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;
import general.Movement;
import general.SensorCache;

public class P2_AvoidAbyss implements Behavior {
   private boolean suppressed = false;
	Movement movement = Movement.getInstance();
   

   public boolean takeControl() {
	   //TODO Lightvalue anpassen, größer oder kleiner?
      return (SensorCache.getInstance().normalizedLightValue < 300);
   }

   public void suppress() {
      this.suppressed = true;
   }

   public void action() {
     suppressed = false;
     
     movement.backward();
     Delay.msDelay(200);
     movement.turn_left(20);
     movement.stop();
     
   }
}
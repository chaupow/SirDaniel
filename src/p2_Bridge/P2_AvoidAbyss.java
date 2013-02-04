package p2_Bridge;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;
import general.Calibration;
import general.Movement;
import general.SensorCache;

public class P2_AvoidAbyss implements Behavior {
   private boolean suppressed = false;

   public boolean takeControl() {
	   //TODO Lightvalue anpassen, größer oder kleiner?
	   
	   LCD.drawString("LV: " + SensorCache.getInstance().normalizedLightValue , 0, 3);
	   
      return (SensorCache.getInstance().normalizedLightValue < 300  && Calibration.bridge);
   }

   public void suppress() {
      this.suppressed = true;
   }

   public void action() {
     suppressed = false;
     
     LCD.drawString("avoiding", 0, 0);
     LCD.drawString("i: " + Calibration.NumberOfTurns, 0, 4);
     Movement.getInstance().turn_right(5);
     Calibration.NumberOfTurns++;
     
     if(Calibration.NumberOfTurns > 15) {
    	 //TODO richtige Distanz!
    	// Movement.getInstance().travel(300);
    	Movement.getInstance().turn_left(75);
    	Calibration.bridge = false;

     }
   }
}
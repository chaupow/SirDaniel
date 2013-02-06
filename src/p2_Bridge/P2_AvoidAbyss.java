package p2_Bridge;

import lejos.nxt.LCD;
import lejos.robotics.subsumption.*;
import general.Calibration;
import general.Movement;
import general.SensorCache;

public class P2_AvoidAbyss implements Behavior {
   private boolean suppressed = false;

   public boolean takeControl() {
	   //TODO Lightvalue anpassen, größer oder kleiner?
	   
//	   LCD.drawString("LV: " + SensorCache.getInstance().normalizedLightValue , 0, 3);
	   
      return (SensorCache.getInstance().lightValue < 20);
   }

   public void suppress() {
      this.suppressed = true;
   }

   public void action() {
     suppressed = false;
     
     LCD.drawString("avoiding", 0, 0);
     Movement.getInstance().turn_right(5);
     Calibration.NumberOfTurns++;
     
     if(Calibration.NumberOfTurns > 15) {
    	 //TODO richtige Distanz!
    	// Movement.getInstance().travel(300);
    	Movement.getInstance().turn_left(55);
    	
    	Movement.getInstance().travel(110);
    	Calibration.NumberOfTurns = 0;
     }
   }
}
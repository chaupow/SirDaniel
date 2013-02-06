package p2_Bridge;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.*;
import general.Calibration;
import general.Movement;
import general.SensorCache;

public class P2_DriveLeft implements Behavior {
   private boolean suppressed = false;
  
   Movement movement = Movement.getInstance();
   
   public boolean takeControl() {
//	   return SensorCache.getInstance().normalizedLightValue > 300;
//      return (Settings.bridge);
	   return true;
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {

	   Calibration.NumberOfTurns = 0;
	   
	   if(SensorCache.getInstance().lightValue > 30) Config.foundBridge = true;

	   suppressed = false;
	   LCD.drawString("driving", 0, 0);
	   movement.arc(400, 360, true);
     
	   while(!suppressed){
		   Thread.yield();
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
}
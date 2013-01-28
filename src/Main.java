 import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;
 
 
 /**
  * Simplest 3 motor commands
  * @author owner.GLASSEY
 *
  */
 public class Main
 {
	 final static int wheelDiameter = 85; // in millimeters 
	  final static int robotRadius = 162; // in millimeters
	 
      public static void main(String[] args)
      {
//           LCD.drawString("Program 1", 0, 0);
//           Button.waitForAnyPress();
//           LCD.clear();
//           Motor.B.backward();
//           LCD.drawString("backward",0,0);
//           Button.waitForAnyPress();
//           LCD.drawString("BACKWARD",0,0);
//           Motor.B.backward();
//           Button.waitForAnyPress();
//           Motor.B.stop();   
    	  
//    	  	 LCD.drawString("Program 2", 0, 0);
//    	  	 Button.waitForAnyPress();
//    	  	 Motor.B.setSpeed(720);
//    	  	 Motor.B.backward();
//    	  	 Delay.msDelay(2000);
//    	  	 LCD.clear();
//    	  	 LCD.drawInt(Motor.B.getTachoCount(), 0, 0);
//    	  	 Motor.B.stop();
//    	  	 LCD.drawInt(Motor.B.getTachoCount(), 0, 1);
//    	  	 Motor.B.backward();
//    	  	 while(Motor.B.getTachoCount() > 0);
//    	  	 LCD.drawInt(Motor.B.getTachoCount(), 0, 2);
//    	  	 Motor.B.stop();
//    	  	 LCD.drawInt(Motor.B.getTachoCount(), 0, 3);
//    	  	 Button.waitForAnyPress();
    	  	
//    	  LCD.drawString("Programm 3", 0, 0);
//    	  Button.waitForAnyPress();
//    	  Motor.B.rotate(1440);
//    	  LCD.clear();
//    	  LCD.drawInt(Motor.B.getTachoCount(), 0, 0);
//    	  Motor.B.rotateTo(0);
//    	  LCD.drawInt(Motor.B.getTachoCount(), 0, 1);
//    	  Button.waitForAnyPress();
    	  
//    	  LCD.drawString("Programm 4", 0, 0);
//    	  Motor.B.rotate(-1440, true);
//    	  while (Motor.B.isMoving()) {
//    	
//    		  LCD.drawInt(Motor.B.getTachoCount(), 0, 1);
//    		  if (Button.readButtons() > 0) Motor.B.stop();
//    		  
//    	  }
//    	  LCD.drawInt(Motor.B.getTachoCount(), 0, 2);
//    	  Button.waitForAnyPress();
    	  
    	  
    	  
    	  LCD.drawString("Programm Fahren", 0, 0);
    	  Button.waitForAnyPress();
    	  
    	  Motor.B.setSpeed(300);
    	  Motor.A.setSpeed(300);
    	  Motor.B.backward();
    	  Motor.A.backward();
    	  
    	  Delay.msDelay(5000);
    	  Motor.B.stop();
    	  Motor.A.stop();
    	  
    	  // turn right
    	  
    	  Motor.A.rotate(convert(90));
    	  
    	  // straight backward
    	  Motor.B.backward();
    	  Motor.A.backward(); 
    	  
    	  Delay.msDelay(3000);
    	  Motor.A.stop();
    	  Motor.B.stop();
    	  
    	  
    	  // turn left
    	  Motor.B.rotate(convert(180));
    	  
    	  Motor.B.backward();
    	  Motor.A.backward();
    	  
    	  Delay.msDelay(3000);
    	  Motor.A.stop();
    	  Motor.B.stop();
    	  
    	// turn left
    	  Motor.B.rotate(convert(45));
    	  
    	  Motor.B.backward();
    	  Motor.A.backward();
    	  
    	  Button.waitForAnyPress();
    	  }
    	  	
//      public static void turn(int angle) {
//    	  if (angle > 0)
//      }
      
      // convert angle to wheel circumference
      public static int convert(int angle) {
    	  return (int) (360 * robotRadius * Math.toRadians(angle) / (wheelDiameter * Math.PI));
      }
      
    	
}
 


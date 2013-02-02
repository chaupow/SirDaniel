package p2_Bridge;
import general.DriveForward;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P2 {
	
   public static void main(String [] args) {
	   
	   SensorPort touchPort = SensorPort.S1;
	
	   TouchSensor touch = new TouchSensor(touchPort);
	   
	   // constant values
	   int speed = 5;
	   int rotationSpeed = 2;
	   int angleRight = 5;
	   int angleLeft = 30;
	   
//	   Behavior driveForward = new DriveForward(1);
	   Behavior driveRight = new P2_DriveRight(speed, rotationSpeed, angleRight, touch);
	   Behavior avoidAbyss = new P2_AvoidAbyss(touch, speed, rotationSpeed, angleLeft);
	   
	   Behavior [] b = {driveRight, avoidAbyss};
	   Arbitrator arby = new Arbitrator(b);
	   
	   Button.waitForAnyPress();
	   arby.start();
	   Button.waitForAnyPress();
   }


}

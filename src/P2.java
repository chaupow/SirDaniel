import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P2 {
	
   public static void main(String [] args) {
	   
	   SensorPort touchPort = SensorPort.S1;
	
	   TouchSensor touch = new TouchSensor(touchPort);
	   
	   // constant values
	   int speed = 3;
	   int rotationSpeed = 2;
	   int angleRight = 5;
	   int angleLeft = 10;
	   
   
	   Behavior driveRight = new P2_DriveRight(speed, rotationSpeed, angleRight);
	   Behavior correctRight = new P1_CorrectRight(sonic, speed, rotationSpeed, shouldBe);
	   Behavior correctLeft = new P1_CorrectLeft(sonic, speed, rotationSpeed, shouldBe);
	   Behavior turnRight = new P1_TurnRight(sonic, touch, speed, rotationSpeed, shouldBe, minimumDifference);
	   Behavior turnLeft = new P1_TurnLeft(touch, speed, rotationSpeed);
	   Behavior [] b = {driveForward, correctRight, correctLeft, turnRight, turnLeft};
	   Arbitrator arby = new Arbitrator(b);
	   arby.start();
   }


}

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class P1 {
	
   public static void main(String [] args) {
	   
	   SensorPort sonicPort = SensorPort.S3;
	   SensorPort touchPort = SensorPort.S2;
		
	   UltrasonicSensor sonic = new UltrasonicSensor(sonicPort);
	   TouchSensor touch = new TouchSensor(touchPort);
	   
	   // constant values
	   int speed = 3;
	   int rotationSpeed = 2;
	   int shouldBe = 10;
	   int minimumDifference = 20;
	   
   
	   Behavior driveForward = new DriveForward(speed);
	   Behavior correctRight = new P1_CorrectRight(sonic, speed, rotationSpeed, shouldBe);
	   Behavior correctLeft = new P1_CorrectLeft(sonic, speed, rotationSpeed, shouldBe);
	   Behavior turnRight = new P1_TurnRight(sonic, touch, speed, rotationSpeed, shouldBe, minimumDifference);
	   Behavior turnLeft = new P1_TurnLeft(touch, speed, rotationSpeed);
	   Behavior [] b = {driveForward, correctRight, correctLeft, turnRight, turnLeft};
	   Arbitrator arby = new Arbitrator(b);
	   arby.start();
   }


}

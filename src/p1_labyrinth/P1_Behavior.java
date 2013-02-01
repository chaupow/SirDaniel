package p1_labyrinth;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.SirDanielArbitrator;
import general.DriveForward;

public class P1_Behavior implements Behavior{
	
	SensorPort sonicPort = SensorPort.S3;
	SensorPort touchPort = SensorPort.S2;
	int speed = 2;
	int rotationSpeed = 2;
	int min_dist = 8;
	int max_dist = 20;
	int shouldBe = 10;
	int minimumDifference = 50;
	SirDanielArbitrator arby;
	
	UltrasonicSensor sonic;
	TouchSensor touch;
	Thread t;
	
	public P1_Behavior(){
		
		sonic = new UltrasonicSensor(SensorPort.S3);
		touch = new TouchSensor(SensorPort.S2);
		
		Behavior driveForward = new DriveForward(speed);
		Behavior correctRight = new P1_CorrectRight(sonic, speed, rotationSpeed,  max_dist);
		Behavior correctLeft = new P1_CorrectLeft(sonic, speed, rotationSpeed, min_dist);
		Behavior turnRight = new P1_TurnRight(sonic, touch, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P1_TurnLeft(touch, speed, rotationSpeed);
		Behavior [] b = {driveForward, correctRight, correctLeft, turnRight, turnLeft};
		arby = new SirDanielArbitrator(b, true);
	}
	
	public boolean takeControl(){
		//TODO richtiges s
		return true;
	}
	
	public void suppress(){
		arby.stop();
	}
	
   public void action() {
	   t = new Thread(arby);
	   t.run();
   }


}

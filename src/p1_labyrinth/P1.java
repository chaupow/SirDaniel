package p1_labyrinth;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.LineCounting;
import general.Movement;
import general.Settings;
import general.SirDanielArbitrator;

public class P1 implements Behavior {
		
	 private Thread t;
	 private SirDanielArbitrator arby;
	 private int speed = 1;
	 private int rotationSpeed = 1;
	 private int min_dist = 10;
	 private int shouldBe = 10;
	 private int minimumDifference = 30;
			
	public P1(UltrasonicSensor sonic){
		
		Behavior forward = new P1_DriveForward(200);
		Behavior correct = new P1_Correct(sonic, min_dist);
		Behavior turnRight = new P1_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P1_TurnLeft(speed, rotationSpeed);
		Behavior read = new LineCounting();
		Behavior [] b = {forward,correct, turnRight, turnLeft, read};
		arby = new SirDanielArbitrator(b,true);
		t =  new Thread(arby);

		
	}

@Override
public boolean takeControl() {
	// TODO Auto-generated method stub
	return Settings.labyrinth;
}

@Override
public void action() {
	LCD.drawString("I'm going to labyrinth", 0, 5);
	t.start();
}

@Override
public void suppress() {
	Settings.labyrinth = false;
}


}

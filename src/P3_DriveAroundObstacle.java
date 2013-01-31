import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class P3_DriveAroundObstacle implements Behavior{
	TouchSensor bumper;
	LightSensor light;
	UltrasonicSensor sonic;
	
    // constant values
    int speed = 3;
    int rotationSpeed = 2;
    int min_dist = 8;
    int max_dist = 13;
    int shouldBe = 10;
    int minimumDifference = 20;
	
	public P3_DriveAroundObstacle(TouchSensor bumper, LightSensor light, UltrasonicSensor sonic) {
		this.bumper = bumper;
		this.light = light;
		this.sonic = sonic;
	}
	
	@Override
	public boolean takeControl() {
		return bumper.isPressed();
	}

	@Override
	public void action() {
		Behavior turnLeft = new P3_TurnLeft(bumper, speed, rotationSpeed);
		Behavior turnRight = new P3_TurnRight(sonic, bumper, speed, rotationSpeed, shouldBe, minimumDifference, light);
		Behavior correctRight = new P3_CorrectRight(sonic, speed, rotationSpeed, max_dist, light);
		Behavior correctLeft = new P3_CorrectLeft(sonic, speed, rotationSpeed, min_dist, light);
		Behavior forward = new P3_DriveForward(rotationSpeed, light);
		Behavior [] bArray = {forward, correctRight, correctLeft, turnRight, turnLeft};
		Arbitrator arby = new Arbitrator(bArray, true);
		arby.start();
		
		
		Movement.turn_left(50);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}

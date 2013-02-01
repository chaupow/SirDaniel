package p3_LineFollower;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;
import general.Movement;
import general.SirDanielArbitrator;
import p1_labyrinth.P1_Behavior;


public class P3_DriveAroundObstacle implements Behavior{
	TouchSensor bumper;
	SirDanielArbitrator arby;
	Movement movement;
	public P3_DriveAroundObstacle(TouchSensor bumper) {
		
		Behavior p1 = new P1_Behavior();
		Behavior [] bArray = {p1};
		arby = new SirDanielArbitrator(bArray, true);
		
		movement = Movement.getInstance();
	}
	
	@Override
	public boolean takeControl() {
		return bumper.isPressed();
	}

	@Override
	public void action() {
		arby.run();		
		
	}

	@Override
	public void suppress() {
		arby.stop();
		
		//If you found the line again, orientate left.
		movement.turn_left(50);
	}

}

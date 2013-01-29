import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class LineFollower {

	public static void main(String[] args) {
		Button.waitForAnyPress();
		Behavior b1 = new DriveForward(2);
		Behavior b2 = new FollowLine(SensorPort.S4, 380);
		Behavior b3 = new SearchLine(SensorPort.S4, 380);
		Behavior [] bArray = {b1, b2, b3};
		Arbitrator arby = new Arbitrator(bArray);
	    arby.start();
	}
	
}

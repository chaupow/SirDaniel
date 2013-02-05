package p5_turntable;

import general.DriveForward;
import general.SirDanielArbitrator;
import general.SuperMotor;
import p4_LineFollower.FollowLine;
import p4_LineFollower.SearchLine;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class P5 {

	public static void main(String[] args) {
	
	Behavior drive = new DriveForward(1);
	Behavior turn = new TurnAround();
	Behavior turnIt = new TurnIt();

	Behavior [] b = {turnIt};
	SirDanielArbitrator arby = new SirDanielArbitrator(b);

	Thread t = new Thread(arby);
	Button.waitForAnyPress();

	//SuperMotor.calibrate();
	//SuperMotor.turnTo(90, false);
	t.start();
	
	}

}

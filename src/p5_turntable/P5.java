package p5_turntable;

import general.SirDanielArbitrator;
import general.SuperMotor;
import p4_LineFollower.FollowLine;
import p4_LineFollower.SearchLine;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class P5 {

	public static void main(String[] args) {
	
	Behavior follow = new FollowLine();
	Behavior search = new SearchLine();
	Behavior boxEntry = new BoxEntryDetect(1, 0);
	Behavior driveIn = new DriveInBox();
	Behavior turn = new TurnAround();
	Behavior turnIt = new TurnIt();

	Behavior [] b = {follow, boxEntry, driveIn, search, turn, turnIt};
	SirDanielArbitrator arby = new SirDanielArbitrator(b);

	Thread t = new Thread(arby);
	Button.waitForAnyPress();

	SuperMotor.calibrate();
	SuperMotor.turnTo(90, false);
	t.start();
	
	}

}
